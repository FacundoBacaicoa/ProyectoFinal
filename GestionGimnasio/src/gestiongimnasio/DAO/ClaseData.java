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
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Clase");
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
    String sql = "SELECT c.id_clase, c.nombre AS nombre_clase, e.id_entrenadores, e.nombre AS nombre_entrenador, e.apellido, c.horario, c.capacidad, c.estado " +
                 "FROM clases c " +
                 "JOIN entrenadores e ON c.id_entrenador = e.id_entrenadores " +
                 "WHERE (? IS NULL OR c.nombre LIKE ?) " +
                 "AND (? IS NULL OR CONCAT(e.nombre, ' ', e.apellido) LIKE ?) " +
                 "AND (? IS NULL OR c.horario LIKE ?)";

    try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombre != null ? "%" + nombre + "%" : null);
            ps.setString(2, nombre != null ? "%" + nombre + "%" : null);
            ps.setString(3, entrenador != null ? "%" + entrenador + "%" : null);
            ps.setString(4, entrenador != null ? "%" + entrenador + "%" : null);
            ps.setString(5, horario != null ? "%" + horario + "%" : null);
            ps.setString(6, horario != null ? "%" + horario + "%" : null);

            ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Clase clase = new Clase();
            clase.setId_clase(rs.getInt("id_clase"));
            clase.setNombre(rs.getString("nombre_clase"));
            Entrenador entrenadorObj = new Entrenador();
            entrenadorObj.setId_entrenadores(rs.getInt("id_entrenadores"));
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
        JOptionPane.showMessageDialog(null, "Error al buscar clases");
    }

    return clases;
}
    
    public void inscribirSocioEnClase(Socio socio, Clase clase) {
    String sqlCheckCapacity = "SELECT capacidad FROM clases WHERE id_clase = ?";
    String sqlInsert = "INSERT INTO inscripciones (id_socio, id_clase) VALUES (?, ?)";
    String sqlUpdateCapacity = "UPDATE clases SET capacidad = capacidad - 1 WHERE id_clase = ?";

    try {
        // Verificar la capacidad de la clase
        PreparedStatement psCheck = con.prepareStatement(sqlCheckCapacity);
        psCheck.setInt(1, clase.getId_clase());
        ResultSet rsCheck = psCheck.executeQuery();

        if (rsCheck.next()) {
            int capacidad = rsCheck.getInt("capacidad");
            if (capacidad > 0) {
                // Inscribir al socio en la clase
                PreparedStatement psInsert = con.prepareStatement(sqlInsert);
                psInsert.setInt(1, socio.getId_Socio());
                psInsert.setInt(2, clase.getId_clase());
                int filasInsertadas = psInsert.executeUpdate();

                if (filasInsertadas > 0) {
                    // Actualizar la capacidad de la clase
                    PreparedStatement psUpdate = con.prepareStatement(sqlUpdateCapacity);
                    psUpdate.setInt(1, clase.getId_clase());
                    psUpdate.executeUpdate();

                    JOptionPane.showMessageDialog(null, "El socio " + socio.getNombre() + " fue inscrito correctamente en la clase " + clase.getNombre());
                    psUpdate.close();  // Asegúrate de cerrar psUpdate aquí
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo inscribir al socio en la clase.");
                }

                psInsert.close();  // Cerrar psInsert aquí
            } else {
                JOptionPane.showMessageDialog(null, "La clase ya ha alcanzado su capacidad máxima.");
            }
        }

        rsCheck.close();  // Cerrar rsCheck aquí
        psCheck.close();  // Cerrar psCheck aquí
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al inscribir al socio en la clase: " + e.getMessage());
    }
}   
}
