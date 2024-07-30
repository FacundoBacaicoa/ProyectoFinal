/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
import java.util.Date;
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
    String[] nombresColumnas = {"ID Asistencia", "DNI Socio", "Nombre Socio", "Fecha", "Clase", "Horario"};
    DefaultTableModel modelo = new DefaultTableModel(null, nombresColumnas);
    String sql = "SELECT a.id_asistencia, s.DNI, s.Nombre, s.Apellido, a.fecha_asistencia, c.nombre AS nombre_clase, c.horario " +
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
            Object[] fila = new Object[6];
            fila[0] = rs.getInt("id_asistencia");
            fila[1] = rs.getString("DNI");
            fila[2] = rs.getString("Nombre") + " " + rs.getString("Apellido");
            fila[3] = rs.getDate("fecha_asistencia");
            fila[4] = rs.getString("nombre_clase");
            fila[5] = rs.getString("horario");
            modelo.addRow(fila);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al buscar asistencias: " + e.getMessage());
    }
    return modelo;
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
}

