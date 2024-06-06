package gestiongimansio;

import gestiongimansio.DAO.SocioDAO;
import gestiongimansio.Entidades.Socios;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class GestionGimansio {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/Gimnasio";
        String user = "root";
        String password = "";

        try (Connection con = DriverManager.getConnection(url, user, password)) {
            SocioDAO socioDAO = new SocioDAO(con);

            // Crear un nuevo socio
            Socios nuevoSocio = new Socios(0, "12345678", "Juan", "Perez", 25, "juan@example.com", "123456789", true);
            socioDAO.agregarSocio(nuevoSocio);

            // Obtener y mostrar todos los socios
            List<Socios> socios = socioDAO.obtenerSocios();
            for (Socios socio : socios) {
                System.out.println(socio);
            }

            // Actualizar un socio
            Socios socioActualizado = socios.get(0);
            socioActualizado.setNombre("Juan Carlos");
            socioDAO.actualizarSocio(socioActualizado);

            // Eliminar un socio
            if (!socios.isEmpty()) {
                int idEliminar = socios.get(0).getId_membresia();
                socioDAO.eliminarSocio(idEliminar);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}