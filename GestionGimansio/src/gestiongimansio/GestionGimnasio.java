package gestiongimansio;

import gestiongimnasio.DAO.SocioDAO;
import gestiongimansio.Entidades.Socio;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class GestionGimnasio {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/Gimnasio";
        String user = "root";
        String password = "";

        try (Connection con = DriverManager.getConnection(url, user, password)) {
            SocioDAO socioDAO = new SocioDAO(con);

            // Crear un nuevo socio
            Socio nuevoSocio = new Socio(0, "12345678", "Juan", "Perez", 25, "juan@example.com", "123456789", true);
            socioDAO.agregarSocio(nuevoSocio);

            // Obtener y mostrar todos los socios
            List<Socio> socios = socioDAO.obtenerSocios();
            for (Socio socio : socios) {
                System.out.println(socio);
            }

            // Actualizar un socio
            Socio socioActualizado = socios.get(0);
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