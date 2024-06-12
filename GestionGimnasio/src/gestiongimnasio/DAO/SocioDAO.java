package gestiongimnasio.DAO;

import gestiongimnasio.Entidades.Socio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class SocioDAO {

    

     private Connection con = null;

    public SocioDAO() {
        con = Conexion.getConexion();
    }

    public void agregarSocio(Socio socio) throws SQLException {
        String query = "INSERT INTO socios (DNI, Nombre, Apellido,Edad,Correo,Teléfono,Estado) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, socio.getDni());
            ps.setString(2, socio.getNombre());
            ps.setString(3, socio.getApellido());
            ps.setInt(4, socio.getEdad());
            ps.setString(5, socio.getCorreo());
            ps.setInt(6, socio.getTelefono());
            ps.setBoolean(7, socio.isEstado());
            ps.executeUpdate();
        }
    }

    public DefaultTableModel listarSocios() {

        String[] nombresColumnas = {"ID_Socio", "DNI" , "Nombre", "Apellido","Edad","Correo","Teléfono","Estado"};//Indica el nombre de las columnas en la tabla

        String[] registros = new String[8];

        DefaultTableModel modelo = new DefaultTableModel(null, nombresColumnas);

        String sql = "SELECT ID_Socio,DNI, Nombre, Apellido,Edad,Correo,Teléfono,Estado FROM socios";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                registros[0] = rs.getString("ID_Socio");

                registros[1] = rs.getString("DNI");

                registros[2] = rs.getString("Nombre");

                registros[3] = rs.getString("Apellido");

                registros[4] = rs.getString("Edad");

                registros[5] = rs.getString("Correo");

                registros[6] = rs.getString("Teléfono");

                registros[7] = rs.getString("Estado");
                modelo.addRow(registros);
            }
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Error al conectar. " + e.getMessage());

        }
        return modelo;
    }

    public void actualizarSocio(Socio socio) throws SQLException {
        String query = "UPDATE socios SET DNI = ?, Nombre = ?, Apellido = ?, Edad = ?, Correo = ?, Teléfono = ?, Estado = ? WHERE ID_Socio = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, socio.getDni());
            ps.setString(2, socio.getNombre());
            ps.setString(3, socio.getApellido());
            ps.setInt(4, socio.getEdad());
            ps.setString(5, socio.getCorreo());
            ps.setInt(6, socio.getTelefono());
            ps.setBoolean(7, socio.isEstado());
            ps.setInt(8, socio.getId_Socio());
            ps.executeUpdate();
        }
    }

    public void eliminarSocio(int id) throws SQLException {
        String query = "DELETE FROM socios WHERE ID_Socio = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

public DefaultTableModel buscarSocio(String buscar) {
    String[] nombresColumnas = {"ID_Socio", "Nombre", "Apellido", "Edad", "Correo", "Teléfono", "Estado"};
    String[] registros = new String[7];
    DefaultTableModel modelo = new DefaultTableModel(null, nombresColumnas);

    String sql = "SELECT ID_Socio, Nombre, Apellido, Edad, Correo, Teléfono, Estado " +
                 "FROM socios " +
                 "WHERE Nombre LIKE '%" + buscar + "%' " +
                 "OR Apellido LIKE '%" + buscar + "%' " +
                 "OR ID_Socio  LIKE '%" + buscar + "%' " ;
               
                

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            registros[0] = rs.getString("ID_Socio");
            registros[1] = rs.getString("Nombre");
            registros[2] = rs.getString("Apellido");
            registros[3] = rs.getString("Edad");
            registros[4] = rs.getString("Correo");
            registros[5] = rs.getString("Teléfono");
            registros[6] = rs.getString("Estado");
            modelo.addRow(registros);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al conectar. " + e.getMessage());
    }
    return modelo;
}
}
