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
                Class.forName("org.mariadb.jdbc.Driver");
                connection = DriverManager.getConnection(URL + DB, USUARIO, PASSWORD);
                LOGGER.info("Conexión establecida exitosamente.");
            } else if (!connection.isValid(5)) {
                connection.close();
                connection = DriverManager.getConnection(URL + DB, USUARIO, PASSWORD);
                LOGGER.info("Conexión restablecida exitosamente.");
            }
        } catch (ClassNotFoundException ex) {
            LOGGER.log(Level.SEVERE, "Error al cargar los drivers", ex);
            JOptionPane.showMessageDialog(null, "Error al cargar los drivers: " + ex.getMessage());
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error al conectarse a la base de datos", ex);
            JOptionPane.showMessageDialog(null, "Error al conectarse a la base de datos: " + ex.getMessage());
        }
        return connection;
    }
}