package gestiongimnasio.DAO;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import gestiongimnasio.Entidades.Entrenador;
import javax.swing.table.DefaultTableModel;

public class EntrenadorData {

    private Connection con = null;

    public EntrenadorData() {
        con = (Connection) Conexion.getConexion();
    }

public void guardarEntrenador(Entrenador entrenador) {
        String sql = "INSERT INTO entrenadores(DNI, Nombre, Apellido, Especialidad, Estado) VALUES(?, ?, ?, ?, ?)";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, entrenador.getDni());
            ps.setString(2, entrenador.getNombre());
            ps.setString(3, entrenador.getApellido());
            ps.setString(4, entrenador.getEspecialidad());
            ps.setBoolean(5, entrenador.isEstado());
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    entrenador.setId_entrenadores(rs.getInt(1));
                    JOptionPane.showMessageDialog(null, "Entrenador guardado");
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar el entrenador: " + ex.getMessage());
        }
    }

    public void modificarEntrenador(Entrenador entrenador) {
        String sql = "UPDATE entrenadores SET DNI=?, Nombre=?, Apellido=?, Especialidad=?, Estado=? WHERE ID_Entrenador=?";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, entrenador.getDni());
            ps.setString(2, entrenador.getNombre());
            ps.setString(3, entrenador.getApellido());
            ps.setString(4, entrenador.getEspecialidad());
            ps.setBoolean(5, entrenador.isEstado());
            ps.setInt(6, entrenador.getId_entrenadores());

            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Entrenador modificado");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar el entrenador: " + ex.getMessage());
        }
    }

    public boolean eliminarEntrenador(int id) {
        boolean exito = false;
        try (Connection con = Conexion.getConexion()) {
            con.setAutoCommit(false);

            try (PreparedStatement psClases = con.prepareStatement("DELETE FROM clases WHERE ID_Entrenador = ?");
                 PreparedStatement psEntrenador = con.prepareStatement("DELETE FROM entrenadores WHERE ID_Entrenador = ?")) {

                psClases.setInt(1, id);
                psClases.executeUpdate();

                psEntrenador.setInt(1, id);
                int resultado = psEntrenador.executeUpdate();

                if (resultado > 0) {
                    con.commit();
                    exito = true;
                    JOptionPane.showMessageDialog(null, "Entrenador y clases asociadas eliminadas con éxito");
                } else {
                    con.rollback();
                    JOptionPane.showMessageDialog(null, "No se encontró el entrenador con ID: " + id);
                }

            } catch (SQLException ex) {
                con.rollback();
                JOptionPane.showMessageDialog(null, "Error al eliminar: " + ex.getMessage());
            } finally {
                con.setAutoCommit(true);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos: " + e.getMessage());
        }

        return exito;
    }

    public DefaultTableModel mostrarEntrenadores() {
        String[] columnas = {"ID", "Nombre", "Apellido", "Especialidad", "Estado"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return (columnIndex == 0) ? Integer.class : String.class;
            }
        };

        String sql = "SELECT ID_Entrenador, Nombre, Apellido, Especialidad, Estado FROM entrenadores";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                modelo.addRow(new Object[]{
                    rs.getInt("ID_Entrenador"),
                    rs.getString("Nombre"),
                    rs.getString("Apellido"),
                    rs.getString("Especialidad"),
                    rs.getBoolean("Estado")
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar entrenadores: " + e.getMessage());
        }

        return modelo;
    }

    public DefaultTableModel buscarEntrenadores(String buscar) {
        String[] columnas = {"ID", "Nombre", "Apellido", "Especialidad", "Estado"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);

        String sql = "SELECT ID_Entrenador, Nombre, Apellido, Especialidad, Estado FROM entrenadores " +
                     "WHERE Nombre LIKE ? OR Apellido LIKE ? OR Especialidad LIKE ? OR ID_Entrenador LIKE ?";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            String filtro = "%" + buscar + "%";
            for (int i = 1; i <= 4; i++) {
                ps.setString(i, filtro);
            }

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    modelo.addRow(new Object[]{
                        rs.getInt("ID_Entrenador"),
                        rs.getString("Nombre"),
                        rs.getString("Apellido"),
                        rs.getString("Especialidad"),
                        rs.getBoolean("Estado")
                    });
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar entrenadores: " + e.getMessage());
        }

        return modelo;
    }

    public Entrenador buscarEntrenadorPorDNI(int dni) {
        Entrenador entrenador = null;
        String sql = "SELECT ID_Entrenador, DNI, Nombre, Apellido, Especialidad, Estado FROM entrenadores WHERE DNI = ?";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, dni);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    entrenador = new Entrenador(
                        rs.getInt("ID_Entrenador"),
                        rs.getInt("DNI"),
                        rs.getString("Nombre"),
                        rs.getString("Apellido"),
                        rs.getString("Especialidad"),
                        rs.getBoolean("Estado")
                    );
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener el entrenador: " + ex.getMessage());
        }

        return entrenador;
    }

    public Entrenador buscarEntrenadorPorNombre(String nombre) {
        Entrenador entrenador = null;
        String sql = "SELECT ID_Entrenador, DNI, Nombre, Apellido, Especialidad, Estado FROM entrenadores WHERE Nombre = ?";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, nombre);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    entrenador = new Entrenador(
                        rs.getInt("ID_Entrenador"),
                        rs.getInt("DNI"),
                        rs.getString("Nombre"),
                        rs.getString("Apellido"),
                        rs.getString("Especialidad"),
                        rs.getBoolean("Estado")
                    );
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener el entrenador: " + ex.getMessage());
        }

        return entrenador;
    }

    public void agregarEntrenadorSiNoExiste(Entrenador entrenador) {
        Entrenador existente = buscarEntrenadorPorDNI(entrenador.getDni());
        if (existente == null) {
            guardarEntrenador(entrenador);
        } else {
            entrenador.setId_entrenadores(existente.getId_entrenadores());
        }
    }

}



