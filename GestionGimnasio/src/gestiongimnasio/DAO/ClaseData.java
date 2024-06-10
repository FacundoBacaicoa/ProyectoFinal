package gestiongimnasio.DAO;

import gestiongimnasio.Entidades.Clase;
import gestiongimnasio.Entidades.Socio;
import org.mariadb.jdbc.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;

public class ClaseData {

    private Connection con = null;

    public ClaseData() {
        con = Conexion.getConexion();
    }

    public void guardarClase(Clase clase) {
        String sql = "INSERT INTO clases(Nombre, ID_Entrenador, Horario,Capacidad,Estado)VALUES(?, ?, ?, ?, ?)";
        try {
            try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, clase.getNombre());
                ps.setInt(2, clase.getIdEntrenador().getId_entrenadores());
                
                ps.setTime(3, Time.valueOf(clase.getHorario()));
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
                clase.setIdEntrenador(rs.getInt("ID_Entrenador"));
                //Falta Horario
                clase.setCapacidad(rs.getInt("capacidad"));
                clase.setEstado(rs.getBoolean("estado"));

            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla clases");
        }

    }
    
      //Falta Buscar Clase
    
    public void inscribirSocioEnClase(Socio socio, Clase clase) {
    String sql = "INSERT INTO inscripciones (id_socio, id_clase) VALUES (?, ?)";
    
    try {
        PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, socio.getId_Socio());
        ps.setInt(2, clase.getId_clase());
        
        int filasInsertadas = ps.executeUpdate();
        
        if (filasInsertadas > 0) {
            System.out.println("El socio " + socio.getNombre() + " fue inscrito correctamente en la clase " + clase.getNombre());
        } else {
            System.out.println("No se pudo inscribir al socio en la clase.");
        }
    } catch (SQLException e) {
        System.out.println("Error al inscribir al socio en la clase: " + e.getMessage());
    }
}
}
