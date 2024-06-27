package gestiongimnasio.DAO;

import gestiongimnasio.Entidades.Clase;
import gestiongimnasio.Entidades.Entrenador;
import gestiongimnasio.Entidades.Socio;
import org.mariadb.jdbc.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class ClaseData {

    private Connection con = null;

    public ClaseData() {
        con = Conexion.getConexion();
    }

   public void guardarClase(Clase clase) {
    String sql = "INSERT INTO clases(Nombre, ID_Entrenador, Horario, Capacidad, Estado) VALUES (?, ?, ?, ?, ?)";
    try {
        try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, clase.getNombre());
            ps.setInt(2, clase.getIdEntrenador().getId_entrenadores());
            ps.setString(3, clase.getHorario());
            ps.setInt(4, clase.getCapacidad());
            ps.setBoolean(5, clase.isEstado());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                clase.setId_clase(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Clase Guardada");
            }
        }
    } catch (SQLException ex) {
        if (ex.getErrorCode() == 1062) { // Código de error para clave duplicada en MySQL
            JOptionPane.showMessageDialog(null, "Error: El entrenador ya tiene una clase en el horario seleccionado.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Clase: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
}
   }
    public void listarClases() {
        String sql = "SELECT ID_Clase, Nombre, ID_Entrenador, Horario, Capacidad, Estado FROM clases";
        ArrayList<Clase> clases = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Clase clase = new Clase();
                clase.setId_clase(rs.getInt("id_clase"));
                clase.setNombre(rs.getString("nombre"));
                //Falta IdEntrenador
                //Falta Horario
                clase.setCapacidad(rs.getInt("capacidad"));
                clase.setEstado(rs.getBoolean("estado"));

            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla clases");
        }

    }
    
     public List<Clase> buscarClases(String nombre, String entrenador, String horario) {
    List<Clase> clases = new ArrayList<>();
    String sql = "SELECT c.id_clase, c.nombre AS nombre_clase, e.ID_Entrenador, e.nombre AS nombre_entrenador, e.apellido, c.horario, c.capacidad, c.estado " +
                 "FROM clases c " +
                 "JOIN entrenadores e ON c.id_entrenador = e.ID_Entrenador " +
                 "WHERE (? IS NULL OR c.nombre LIKE ?) " +
                 "AND (? IS NULL OR CONCAT(e.nombre, ' ', e.apellido) LIKE ?) " +
                 "AND (? IS NULL OR c.horario = ?)";

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, nombre != null ? "%" + nombre + "%" : null);
        ps.setString(2, nombre != null ? "%" + nombre + "%" : null);
        ps.setString(3, entrenador != null ? "%" + entrenador + "%" : null);
        ps.setString(4, entrenador != null ? "%" + entrenador + "%" : null);
       ps.setString(5, horario != null ? horario : null);
       ps.setString(6, horario != null ? "%" + horario + "%" : null);
        
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Clase clase = new Clase();
            clase.setId_clase(rs.getInt("id_clase"));
            clase.setNombre(rs.getString("nombre_clase"));
            Entrenador entrenadorObj = new Entrenador();
            entrenadorObj.setId_entrenadores(rs.getInt("ID_Entrenador")); // Ajuste aquí
            entrenadorObj.setNombre(rs.getString("nombre_entrenador"));
            entrenadorObj.setApellido(rs.getString("apellido"));
            clase.setIdEntrenador(entrenadorObj);
            clase.setHorario(rs.getString("horario"));
            clase.setCapacidad(rs.getInt("capacidad"));
            clase.setEstado(rs.getBoolean("estado"));
            clases.add(clase);
        }

        rs.close();
        ps.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al buscar clases: " + ex.getMessage());
    }

    return clases;
}
    
public void inscribirSocioEnClase(Socio socio, Clase clase) {
    String sqlCheckCapacity = "SELECT capacidad FROM clases WHERE id_clase = ?";
    String sqlInsert = "INSERT INTO asistencia (id_socio, id_clase, fecha_asistencia) VALUES (?, ?, CURRENT_DATE)";
    String sqlUpdateCapacity = "UPDATE clases SET capacidad = capacidad - 1 WHERE id_clase = ?";
    String sqlUpdatePases = "UPDATE membresias SET cantidadPases = cantidadPases - 1 WHERE id_socio = ? AND estado = true";

    try {
        String sqlGetMembresia = "SELECT id_membresia, cantidadPases FROM membresias WHERE id_socio = ? AND estado = true";
        PreparedStatement psGetMembresia = con.prepareStatement(sqlGetMembresia);
        psGetMembresia.setInt(1, socio.getId_Socio());
        ResultSet rsMembresia = psGetMembresia.executeQuery();

        if (rsMembresia.next()) {
            int idMembresia = rsMembresia.getInt("id_membresia");
            int cantidadPases = rsMembresia.getInt("cantidadPases");

            if (cantidadPases <= 0) {
                JOptionPane.showMessageDialog(null, "El socio no tiene pases disponibles para inscribirse en la clase.");
                return;
            }

            PreparedStatement psCheck = con.prepareStatement(sqlCheckCapacity);
            psCheck.setInt(1, clase.getId_clase());
            ResultSet rsCheck = psCheck.executeQuery();

            if (rsCheck.next()) {
                int capacidad = rsCheck.getInt("capacidad");
                if (capacidad > 0) {
                    PreparedStatement psInsert = con.prepareStatement(sqlInsert);
                    psInsert.setInt(1, socio.getId_Socio());
                    psInsert.setInt(2, clase.getId_clase());
                    int filasInsertadas = psInsert.executeUpdate();

                    if (filasInsertadas > 0) {
                        PreparedStatement psUpdate = con.prepareStatement(sqlUpdateCapacity);
                        psUpdate.setInt(1, clase.getId_clase());
                        psUpdate.executeUpdate();

                        PreparedStatement psUpdatePases = con.prepareStatement(sqlUpdatePases);
                        psUpdatePases.setInt(1, socio.getId_Socio());
                        psUpdatePases.executeUpdate();

                        JOptionPane.showMessageDialog(null, "El socio " + socio.getNombre() + " fue inscrito correctamente en la clase " + clase.getNombre() + ". Pases restantes: " + (cantidadPases - 1));
                        
                        psUpdate.close();
                        psUpdatePases.close();
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo inscribir al socio en la clase.");
                    }

                    psInsert.close();
                } else {
                    JOptionPane.showMessageDialog(null, "La clase ya ha alcanzado su capacidad máxima.");
                }
            }

            rsCheck.close();
            psCheck.close();
        } else {
            JOptionPane.showMessageDialog(null, "El socio no tiene una membresía activa.");
        }

        rsMembresia.close();
        psGetMembresia.close();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al inscribir al socio en la clase: " + e.getMessage());
    }
}
    public List<Clase> listarTodasLasClases() {
    List<Clase> clases = new ArrayList<>();
    String sql = "SELECT * FROM clases";

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Clase clase = new Clase();
            clase.setId_clase(rs.getInt("ID_Clase"));
            clase.setNombre(rs.getString("Nombre"));
            clase.setHorario(rs.getString("Horario"));
            clase.setCapacidad(rs.getInt("Capacidad"));
            clase.setEstado(rs.getBoolean("Estado"));
            clases.add(clase);
        }

        ps.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al obtener la lista de clases: " + ex.getMessage());
    }

    return clases;
}
}
