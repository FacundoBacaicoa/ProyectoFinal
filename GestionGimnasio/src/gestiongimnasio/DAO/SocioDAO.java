package gestiongimnasio.DAO;

import gestiongimnasio.Entidades.Socio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SocioDAO {
    private Connection con;

    public SocioDAO(Connection con) {
        this.con = con;
    }

    public void agregarSocio(Socio socio) throws SQLException {
        String query = "INSERT INTO socios (dni, nombre, apellido, edad, correo, telefono, estado) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, socio.getDni());
            ps.setString(2, socio.getNombre());
            ps.setString(3, socio.getApellido());
            ps.setInt(4, socio.getEdad());
            ps.setString(5, socio.getCorreo());
            ps.setString(6, socio.getTelefono());
            ps.setBoolean(7, socio.isEstado());
            ps.executeUpdate();
        }
    }

    public List<Socio> obtenerSocios() throws SQLException {
        List<Socio> socios = new ArrayList<>();
        String query = "SELECT * FROM socios";
        try (PreparedStatement ps = con.prepareStatement(query); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Socio socio = new Socio(
                    rs.getInt("id_socio"),
                    rs.getString("dni"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getInt("edad"),
                    rs.getString("correo"),
                    rs.getString("telefono"),
                    rs.getBoolean("estado")
                );
                socios.add(socio);
            }
        }
        return socios;
    }

    // Otros métodos para actualizar y eliminar socios

    public void actualizarSocio(Socio socio) throws SQLException {
        String query = "UPDATE socios SET dni = ?, nombre = ?, apellido = ?, edad = ?, correo = ?, telefono = ?, estado = ? WHERE id_socio = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, socio.getDni());
            ps.setString(2, socio.getNombre());
            ps.setString(3, socio.getApellido());
            ps.setInt(4, socio.getEdad());
            ps.setString(5, socio.getCorreo());
            ps.setString(6, socio.getTelefono());
            ps.setBoolean(7, socio.isEstado());
            ps.setInt(8, socio.getId_membresia());
            ps.executeUpdate();
        }
    }

    public void eliminarSocio(int id) throws SQLException {
        String query = "DELETE FROM socios WHERE id_socio = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
