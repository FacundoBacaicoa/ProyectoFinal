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
import javax.swing.table.DefaultTableModel;
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
    
    public void modificarEntrenador(Entrenador entrenador) {
    String sql = "UPDATE entrenadores SET DNI=?, Nombre=?, Apellido=?, Especialidad=?, Estado=? WHERE id_entrenadores=?";
    
    try {
        PreparedStatement ps = con.prepareStatement(sql);
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
        ps.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla entrenadores");
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

    public DefaultTableModel mostrarEntrenadores() {

        int contador = 1;

        String[] nombresColumnas = {"ID_Entrenador", "Nombre", "Apellido", "Especialidad "};

        String[] registros = new String[5];

        DefaultTableModel modelo = new DefaultTableModel(null, nombresColumnas);

        String sql = "SELECT Id_Entrenador, Nombre, Apellido, Especialidad, Estado FROM entrenadores";

        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                registros[0] = Integer.toString(contador);

                registros[1] = rs.getString("ID_Entrenador");

                registros[2] = rs.getString("Nombre");

                registros[3] = rs.getString("Apellido");

                registros[4] = rs.getString("Especialidad");

                modelo.addRow(registros);

                contador++;

            }
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Error al conectar. " + e.getMessage());

        }
        return modelo;
    }
    
   public void agregarEntrenadorSiNoExiste(Entrenador entrenador) {
    Entrenador existente = buscarEntrenadorPorDNI(entrenador.getDni());
    if (existente == null) {
        guardarEntrenador(entrenador);
    } else {
        entrenador.setId_entrenadores(existente.getId_entrenadores()); // Actualiza el ID del entrenador existente
    }
}

    public Entrenador buscarEntrenadorPorDNI(int dni) {
    Entrenador entrenador = null;
    String sql = "SELECT Id_Entrenador, DNI, Nombre, Apellido, Especialidad, Estado FROM entrenadores WHERE DNI = ?";
    try (PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setInt(1, dni);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                entrenador = new Entrenador(
                    rs.getInt("Id_Entrenador"),
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



}


