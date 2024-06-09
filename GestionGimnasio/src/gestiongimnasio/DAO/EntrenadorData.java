package gestiongimnasio.DAO;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.Connection;
import org.mariadb.jdbc.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import gestiongimnasio.Entidades.Entrenador;
/**
 *
 * @author Facu
 */
public class EntrenadorData {
    private Connection con = null;

    public EntrenadorData() {
        con = Conexion.getConexion();
    }

    public void guardarEntrenador(Entrenador entrenador) {
        String sql = "INSERT INTO entrenadores(DNI, Nombre, Apellido, Especialidad, Estado) VALUES(?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, entrenador.getDni());
            ps.setString(2, entrenador.getNombre());
            ps.setString(3, entrenador.getApellido());
            ps.setString(4, entrenador.getEspecialidad());
            ps.setBoolean(5, entrenador.isEstado());
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                entrenador.setId_entrenadores(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Entrenador guardado");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla entrenador");
        }
    }

    public List<Entrenador> listarEntrenadores() {
        String sql = "SELECT Id_Entrenador, DNI, Nombre, Apellido, Especialidad, Estado FROM entrenadores";
        ArrayList<Entrenador> entrenadores = new ArrayList<>();
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Entrenador entrenador = new Entrenador();
                entrenador.setId_entrenadores(rs.getInt("Id_Entrenador"));
                entrenador.setDni(rs.getInt("DNI"));
                entrenador.setNombre(rs.getString("Nombre"));
                entrenador.setApellido(rs.getString("Apellido"));
                entrenador.setEspecialidad(rs.getString("Especialidad"));
                entrenador.setEstado(rs.getBoolean("Estado"));

                entrenadores.add(entrenador);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla entrenador");
        }
        
        return entrenadores;
    }

    public Entrenador buscarEntrenadorPorNombre(String nombre) {
        String sql = "SELECT Id_Entrenador, DNI, Nombre, Apellido, Especialidad, Estado FROM entrenadores WHERE Nombre LIKE ?";
        Entrenador entrenador = null;
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                entrenador = new Entrenador();
                entrenador.setId_entrenadores(rs.getInt("Id_Entrenador"));
                entrenador.setDni(rs.getInt("DNI"));
                entrenador.setNombre(rs.getString("Nombre"));
                entrenador.setApellido(rs.getString("Apellido"));
                entrenador.setEspecialidad(rs.getString("Especialidad"));
                entrenador.setEstado(rs.getBoolean("Estado"));
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ningún entrenador con ese nombre");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla entrenador");
        }
        
        return entrenador;
    }

    public Entrenador buscarEntrenadorPorEspecialidad(String especialidad) {
        String sql = "SELECT Id_Entrenador, DNI, Nombre, Apellido, Especialidad, Estado FROM entrenadores WHERE Especialidad LIKE ?";
        Entrenador entrenador = null;
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, especialidad);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                entrenador = new Entrenador();
                entrenador.setId_entrenadores(rs.getInt("Id_Entrenador"));
                entrenador.setDni(rs.getInt("DNI"));
                entrenador.setNombre(rs.getString("Nombre"));
                entrenador.setApellido(rs.getString("Apellido"));
                entrenador.setEspecialidad(rs.getString("Especialidad"));
                entrenador.setEstado(rs.getBoolean("Estado"));
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ningún entrenador con esa especialidad");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla entrenador");
        }
        
        return entrenador;
    }
}
