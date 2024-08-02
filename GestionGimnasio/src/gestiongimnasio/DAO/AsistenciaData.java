
package gestiongimnasio.DAO;

import gestiongimnasio.Entidades.Asistencia;
import gestiongimnasio.Entidades.Clase;
import gestiongimnasio.Entidades.Socio;
import java.security.Timestamp;
import java.util.ArrayList;
import java.util.List;
import org.mariadb.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author facun
 */
public class AsistenciaData {
      private Connection con = null;

    public AsistenciaData() {
        con = (Connection) Conexion.getConexion();
    }
    
      public List<Asistencia> obtenerHistorialAsistenciasPorDni(int dni) {
        List<Asistencia> asistencias = new ArrayList<>();
        SocioDAO socioDAO = new SocioDAO();
        Socio socio = socioDAO.buscarSocioPorDni(dni);
        
        if (socio == null) {
            JOptionPane.showMessageDialog(null, "No se encontró un socio con el DNI proporcionado.");
            return asistencias;
        }

        String sql = "SELECT a.id_asistencia, a.id_clase, a.fecha_asistencia, " +
                     "c.nombre AS nombre_clase, c.horario " +
                     "FROM asistencia a " +
                     "JOIN clases c ON a.id_clase = c.id_clase " +
                     "WHERE a.id_socio = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, socio.getId_Socio());
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Asistencia asistencia = new Asistencia();
                asistencia.setId_asistencia(rs.getInt("id_asistencia"));
                asistencia.setFechaAsistencia(rs.getDate("fecha_asistencia"));
                
                Clase clase = new Clase();
                clase.setId_clase(rs.getInt("id_clase"));
                clase.setNombre(rs.getString("nombre_clase"));
                clase.setHorario(rs.getString("horario"));
                asistencia.setId_Clase(clase);
                
                asistencia.setId_Socio(socio);
                
                asistencias.add(asistencia);
            }
            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener el historial de asistencias: " + ex.getMessage());
        }
        
        return asistencias;
    }
   public DefaultTableModel buscarAsistencia(String buscar) {
        String[] nombresColumnas = {"ID Asistencia", "DNI Socio", "Nombre Socio", "Fecha", "Clase", "Horario", "Estado"};
        DefaultTableModel modelo = new DefaultTableModel(null, nombresColumnas);
        String sql = "SELECT a.id_asistencia, s.DNI, s.Nombre, s.Apellido, a.fecha_asistencia, c.nombre AS nombre_clase, c.horario, a.estado " +
                     "FROM asistencia a " +
                     "JOIN socios s ON a.id_socio = s.ID_Socio " +
                     "JOIN clases c ON a.id_clase = c.id_clase " +
                     "WHERE s.DNI LIKE ? " +
                     "OR s.Nombre LIKE ? " +
                     "OR s.Apellido LIKE ? " +
                     "OR a.id_asistencia LIKE ? " +
                     "ORDER BY a.fecha_asistencia DESC";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            String searchTerm = "%" + buscar + "%";
            for (int i = 1; i <= 4; i++) {
                ps.setString(i, searchTerm);
            }
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Object[] fila = new Object[7];
                fila[0] = rs.getInt("id_asistencia");
                fila[1] = rs.getString("DNI");
                fila[2] = rs.getString("Nombre") + " " + rs.getString("Apellido");
                fila[3] = rs.getDate("fecha_asistencia");
                fila[4] = rs.getString("nombre_clase");
                fila[5] = rs.getString("horario");
                fila[6] = rs.getString("estado");
                modelo.addRow(fila);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar asistencias: " + e.getMessage());
        }
        return modelo;
    }

    public void actualizarEstadoAsistencia(int idAsistencia, String estado) {
        String sql = "UPDATE asistencia SET estado = ? WHERE id_asistencia = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, estado);
            ps.setInt(2, idAsistencia);
            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el estado de asistencia: " + e.getMessage());
        }
    }


      public DefaultTableModel listarAsistencias(int dni) {
    String[] nombresColumnas = {"ID Asistencia", "Fecha", "Clase", "Horario"};
    DefaultTableModel modelo = new DefaultTableModel(null, nombresColumnas);
    
    AsistenciaData asistenciaData = new AsistenciaData();
    List<Asistencia> asistencias = asistenciaData.obtenerHistorialAsistenciasPorDni(dni);
    
    for (Asistencia asistencia : asistencias) {
        Object[] fila = new Object[4];
        fila[0] = asistencia.getId_asistencia();
        fila[1] = asistencia.getFechaAsistencia();
        fila[2] = asistencia.getId_Clase().getNombre();
        fila[3] = asistencia.getId_Clase().getHorario();
        modelo.addRow(fila);
    }
    
    return modelo;
}
   public void registrarAsistencia(int idSocio, int idClase, Date fecha) {
    String sql = "INSERT INTO asistencia (ID_Socio, ID_Clase, Fecha_asistencia) VALUES (?, ?, ?)";
    try (PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setInt(1, idSocio);
        ps.setInt(2, idClase);
        ps.setDate(3, fecha);
        ps.executeUpdate();
        JOptionPane.showMessageDialog(null, "Asistencia registrada exitosamente.");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al registrar asistencia: " + e.getMessage());
    }
}
   
    public List<Asistencia> obtenerAsistenciasPorIdSocio(int idSocio) {
    List<Asistencia> asistencias = new ArrayList<>();
    String sql = "SELECT * FROM asistencia WHERE Id_Socio = ?";

    try (PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setInt(1, idSocio);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Asistencia asistencia = new Asistencia();
            asistencia.setId_asistencia(rs.getInt("Id_Asistencia"));
            asistencia.setId_Socio(new Socio(rs.getInt("Id_Socio"))); 
            asistencia.setId_Clase(new Clase(rs.getInt("Id_Clase"))); 
            asistencia.setFechaAsistencia(rs.getDate("Fecha_asistencia"));
            asistencias.add(asistencia);
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al obtener las asistencias del socio: " + ex.getMessage());
    }

    return asistencias;
}
   
}

