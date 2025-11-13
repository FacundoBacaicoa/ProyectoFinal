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
    String query = "INSERT INTO socios (DNI, Nombre, Apellido, Edad, Correo, Teléfono, Estado) VALUES (?, ?, ?, ?, ?, ?, ?)";
    try (PreparedStatement ps = con.prepareStatement(query)) {
        ps.setInt(1, socio.getDni());
        ps.setString(2, socio.getNombre());
        ps.setString(3, socio.getApellido());
        ps.setInt(4, socio.getEdad());
        ps.setString(5, socio.getCorreo());
        ps.setString(6, socio.getTelefono()); 
        ps.setBoolean(7, socio.isEstado());
        ps.executeUpdate();
        JOptionPane.showMessageDialog(null, "Socio guardado correctamente.");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "No se pudo acceder a la tabla Socio. Error: " + e.getMessage());
    }
}


    public DefaultTableModel listarSocios() {

        String[] nombresColumnas = {"ID_Socio", "DNI" , "Nombre", "Apellido","Edad","Correo","Teléfono","Estado"};
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

   public boolean actualizarSocio(Socio socio) {
    String query = "UPDATE socios SET DNI = ?, Nombre = ?, Apellido = ?, Edad = ?, Correo = ?, Teléfono = ?, Estado = ? WHERE ID_Socio = ?";
    try (PreparedStatement ps = con.prepareStatement(query)) {
        ps.setInt(1, socio.getDni());
        ps.setString(2, socio.getNombre());
        ps.setString(3, socio.getApellido());
        ps.setInt(4, socio.getEdad());
        ps.setString(5, socio.getCorreo());
        ps.setString(6, socio.getTelefono());
        ps.setBoolean(7, socio.isEstado());
        ps.setInt(8, socio.getId_Socio());
        int filasActualizadas = ps.executeUpdate();
        return filasActualizadas > 0;
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al actualizar socio: " + ex.getMessage());
        return false;
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
public List<Socio> obtenerTodosLosSocios() {
    List<Socio> socios = new ArrayList<>();
    String sql = "SELECT * FROM socios";

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Socio socio = new Socio();
            socio.setId_Socio(rs.getInt("ID_Socio"));
            socio.setDni(rs.getInt("DNI"));
            socio.setNombre(rs.getString("Nombre"));
            socio.setApellido(rs.getString("Apellido"));
            socio.setEdad(rs.getInt("Edad"));
            socio.setCorreo(rs.getString("Correo"));
            socio.setTelefono(rs.getString("Teléfono"));
            socio.setEstado(rs.getBoolean("Estado"));
            socios.add(socio);
        }

        ps.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al obtener la lista de socios: " + ex.getMessage());
    }

    return socios;
}
public Socio buscarSocioPorNombreApellido(String nombre, String apellido) {
        String sql = "SELECT * FROM socios WHERE Nombre = ? AND Apellido = ?";
        Socio socio = null;

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                socio = new Socio();
                socio.setId_Socio(rs.getInt("ID_Socio"));
                socio.setDni(rs.getInt("DNI"));
                socio.setNombre(rs.getString("Nombre"));
                socio.setApellido(rs.getString("Apellido"));
                socio.setEdad(rs.getInt("Edad"));
                socio.setCorreo(rs.getString("Correo"));
                socio.setTelefono(rs.getString("Teléfono"));
                socio.setEstado(rs.getBoolean("Estado"));
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar socio: " + ex.getMessage());
        }

        return socio;
    }

public Socio buscarSocioPorDni(int id) {
    String sql = "SELECT * FROM socios WHERE DNI = ?";
    Socio socio = null;
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            socio = new Socio();
            socio.setId_Socio(rs.getInt("ID_Socio"));
            socio.setDni(rs.getInt("DNI"));
            socio.setNombre(rs.getString("Nombre"));
            socio.setApellido(rs.getString("Apellido"));
            socio.setEdad(rs.getInt("Edad"));
            socio.setCorreo(rs.getString("Correo"));
            socio.setTelefono(rs.getString("Teléfono"));
            socio.setEstado(rs.getBoolean("Estado"));
        }
        ps.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al buscar socio: " + ex.getMessage());
    }
    return socio;
}
public Socio obtenerSocioPorId(int id) {
    String sql = "SELECT * FROM socios WHERE ID_Socio = ?";
    Socio socio = null;

    try (Connection conn = Conexion.getConexion(); 
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, id);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                socio = new Socio();
                socio.setId_Socio(rs.getInt("ID_Socio"));
                socio.setDni(rs.getInt("DNI"));
                socio.setNombre(rs.getString("Nombre"));
                socio.setApellido(rs.getString("Apellido"));
                socio.setEdad(rs.getInt("Edad"));
                socio.setCorreo(rs.getString("Correo"));
                socio.setTelefono(rs.getString("Teléfono"));
                socio.setEstado(rs.getBoolean("Estado"));
            }
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al buscar socio por ID: " + ex.getMessage());
    }

    return socio;
}

public List<Socio> buscarSociosPorNombreParcial(String texto) {
    List<Socio> lista = new ArrayList<>();
    String sql = "SELECT * FROM socio WHERE nombre ILIKE ? OR apellido ILIKE ?";
    
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, texto + "%");
        ps.setString(2, texto + "%");
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            Socio s = new Socio();
            s.setId_Socio(rs.getInt("id_socio"));
            s.setNombre(rs.getString("nombre"));
            s.setApellido(rs.getString("apellido"));
            lista.add(s);
        }
        ps.close();
    } catch (SQLException ex) {
        System.out.println("Error al buscar socios parcialmente: " + ex.getMessage());
    }
    
    return lista;
}


}
