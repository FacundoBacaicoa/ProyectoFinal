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
        String sql = "UPDATE entrenadores SET DNI=?, Nombre=?, Apellido=?, Especialidad=?, Estado=? WHERE ID_Entrenador=?";

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
    
public boolean eliminarEntrenador(int id) {
    PreparedStatement psClases = null;
    PreparedStatement psEntrenador = null;
    boolean exito = false;

    try {
        String sqlClases = "DELETE FROM clases WHERE ID_Entrenador = ?";
        psClases = con.prepareStatement(sqlClases);
        psClases.setInt(1, id);
        psClases.executeUpdate();

        // Luego, eliminamos el entrenador
        String sqlEntrenador = "DELETE FROM entrenadores WHERE ID_Entrenador = ?";
        psEntrenador = con.prepareStatement(sqlEntrenador);
        psEntrenador.setInt(1, id);
        int resultado = psEntrenador.executeUpdate();

        if (resultado > 0) {
            con.commit();
            exito = true;
            JOptionPane.showMessageDialog(null, "Entrenador y sus clases asociadas eliminados con éxito");
        } else {
            con.rollback(); 
            JOptionPane.showMessageDialog(null, "No se encontró el entrenador con ID: " + id);
        }

    } catch (SQLException ex) {
        try {
            if (con != null) con.rollback(); 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(null, "Error al eliminar el entrenador y sus clases: " + ex.getMessage());
    } finally {
        try {
            if (psClases != null) psClases.close();
            if (psEntrenador != null) psEntrenador.close();
            if (con != null) {
                con.setAutoCommit(true);  // Restauramos el auto-commit
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    return exito;
}
    
    public DefaultTableModel mostrarEntrenadores() {
    String[] nombresColumnas = {"ID", "Nombre", "Apellido", "Especialidad", "Estado"};
    DefaultTableModel modelo = new DefaultTableModel(null, nombresColumnas) {
        @Override
        public Class<?> getColumnClass(int columnIndex) {
            if (columnIndex == 0) {
                return Integer.class; // Asegurar que la columna ID es Integer
            }
            return String.class;
        }
    };

    String sql = "SELECT ID_Entrenador, Nombre, Apellido, Especialidad, Estado FROM entrenadores";
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Object[] registros = new Object[5];
            registros[0] = rs.getInt("ID_Entrenador"); // Asegurar que es un Integer
            registros[1] = rs.getString("Nombre");
            registros[2] = rs.getString("Apellido");
            registros[3] = rs.getString("Especialidad");
            registros[4] = rs.getBoolean("Estado");

            modelo.addRow(registros);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al conectar. " + e.getMessage());
    }
    return modelo;
}

     public DefaultTableModel buscarEntrenadores(String buscar)
    {   
        String []  nombresColumnas = {"ID","Nombre","Apellido","Especialidad", "Estado"};
        
        String [] registros = new String[5];
        
        DefaultTableModel modelo = new DefaultTableModel(null, nombresColumnas);
        
        String sql = "SELECT Id_Entrenador, Nombre, Apellido, Especialidad, Estado " +
             "FROM entrenadores " +
             "WHERE Nombre LIKE '%"+buscar+"%' " +
             "OR Apellido LIKE '%"+buscar+"%' " +
             "OR Especialidad LIKE '%"+buscar+"%' " +
             "OR ID_Entrenador LIKE '%"+buscar+"%'";   
        
        try
        {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                
                registros[0] = rs.getString("ID_Entrenador");
                
                registros[1] = rs.getString("Nombre");
               
                registros[2] = rs.getString("Apellido");
                
                registros[3] = rs.getString("Especialidad");
                
                registros[4] = rs.getString("Estado");
                
                modelo.addRow(registros);
                
                
            }                      
        }
        catch(SQLException e)
        {
            
            JOptionPane.showMessageDialog(null,"Error al conectar. "+e.getMessage());
            
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
    public Entrenador buscarEntrenadorPorNombre(String nombre) {
    Entrenador entrenador = null;
    String sql = "SELECT Id_Entrenador, DNI, Nombre, Apellido, Especialidad, Estado FROM entrenadores WHERE Nombre = ?";
    try (PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setString(1, nombre);
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



