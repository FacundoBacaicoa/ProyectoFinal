package gestiongimnasio.DAO;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;
import java.util.logging.Level;

public class Conexion {
    private static final Logger LOGGER = Logger.getLogger(Conexion.class.getName());
    private static final String URL = "jdbc:mariadb://localhost/";
    private static final String DB = "gimnasio";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "";
    private static Connection connection;

    private Conexion() {
    }

   public static Connection getConexion() {
    try {
        if (connection == null || connection.isClosed()) {
            crearNuevaConexion();
        } else {
            try {
                if (!connection.isValid(2)) {
                    LOGGER.warning("Conexión inválida, intentando reconectar...");
                    crearNuevaConexion();
                }
            } catch (SQLException ex) {
                LOGGER.warning("Error al validar la conexión, intentando reconectar...");
                crearNuevaConexion();
            }
        }
    } catch (SQLException ex) {
        LOGGER.log(Level.SEVERE, "Error al verificar o cerrar conexión", ex);
        JOptionPane.showMessageDialog(null, "Error al verificar conexión: " + ex.getMessage());
    }

    return connection;
}

private static void crearNuevaConexion() {
    try {
        Class.forName("org.mariadb.jdbc.Driver");
        connection = DriverManager.getConnection(URL + DB, USUARIO, PASSWORD);
        LOGGER.info("Conexión creada correctamente.");
    } catch (ClassNotFoundException ex) {
        LOGGER.log(Level.SEVERE, "No se encontró el driver JDBC", ex);
        JOptionPane.showMessageDialog(null, "No se encontró el driver JDBC: " + ex.getMessage());
    } catch (SQLException ex) {
        LOGGER.log(Level.SEVERE, "Error al crear la conexión", ex);
        JOptionPane.showMessageDialog(null, "Error al crear la conexión: " + ex.getMessage());
    }
}
}
