package gestiongimnasio_;

import gestiongimnasio.DAO.ClaseData;
import gestiongimnasio.DAO.EntrenadorData;
import gestiongimnasio.DAO.SocioDAO;
import gestiongimnasio.Entidades.Clase;
import gestiongimnasio.Entidades.Entrenador;
import gestiongimnasio.Entidades.Socio;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

public class GestionGimnasio {
    public static void main(String[] args) {
 //     String url = "jdbc:mysql://localhost:3306/Gimnasio";
//      String user = "root";
//       String password = "";
//
//        try (Connection con = DriverManager.getConnection(url, user, password)) {
//            SocioDAO socioDAO = new SocioDAO(con);
//
//            // Crear un nuevo socio
//            Socio nuevoSocio = new Socio(0, "12345678", "Juan", "Perez", 25, "juan@example.com", "123456789", true);
//            socioDAO.agregarSocio(nuevoSocio);
//
//            // Obtener y mostrar todos los socios
//            List<Socio> socios = socioDAO.obtenerSocios();
//            for (Socio socio : socios) {
//                System.out.println(socio);
//            }
//
//            // Actualizar un socio
//            Socio socioActualizado = socios.get(0);
//            socioActualizado.setNombre("Juan Carlos");
//            socioDAO.actualizarSocio(socioActualizado);
//
//            // Eliminar un socio
//            if (!socios.isEmpty()) {
//                int idEliminar = socios.get(0).getId_membresia();
//                socioDAO.eliminarSocio(idEliminar);
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        
       // ------------------------------------------------------------------------------
       
       //Entrenador entrenador = new Entrenador(1,12345678, "Lucas","Hernandez","Funcional",true);
       //EntrenadorData entData = new EntrenadorData();
       
        // --------------------------GuardarEntrenador--------------------------
       //entData.guardarEntrenador(entrenador);
       
       // --------------------------Listar--------------------------
       // for (Entrenador entrenador1 : entData.listarEntrenadores()) {
            //System.out.println(entrenador1.getDni());
            //entData.listarEntrenadores();
      
      //--------------------------BuscarPorNombre-------------------------
      
            //  Entrenador entranadorPorNombre = entData.buscarEntrenadorPorNombre("Lucas");
        //if (entranadorPorNombre != null) {
          //  System.out.println("ID: " + entranadorPorNombre.getId_entrenadores());
           // System.out.println("Apellido: " + entranadorPorNombre.getApellido());
           // System.out.println("Nombre: " + entranadorPorNombre.getNombre());
           
           //----------------------------GuardarClase------------------------------//
           
          ClaseData claseD = new ClaseData();

        // Ejemplo de agregar una nueva clase
        Entrenador entrenador = new Entrenador(1,12345678, "Lucas","Hernandez","Funcional",true);
        Clase nuevaClase = new Clase(1,"Yoga", entrenador, "18:00:00", 20, true);
        claseD.guardarClase(nuevaClase);
           
           
           
           
           
           //-----------------------------BuscarClase-------------------------------//
          
            // Cambia los parámetros según tu configuración de la base de datos
       

            // Crear una instancia de Main y llamar al método buscarClases
           
            //List<Clase> clases = clasemetodo.buscarClases("Yoga", "Juan Perez", "18:00");

            // Imprimir los resultados
            //for (Clase clase : clases) {
             //   System.out.println("ID Clase: " + clase.getId_clase());
               // System.out.println("Nombre Clase: " + clase.getNombre());
               // System.out.println("Entrenador: " + clase.getIdEntrenador().getNombre() + " " + clase.getIdEntrenador().getApellido());
               // System.out.println("Horario: " + clase.getHorario());
               // System.out.println("Capacidad: " + clase.getCapacidad());
               // System.out.println("Estado: " + (clase.isEstado() ? "Activo" : "Inactivo"));
                //System.out.println("-----");
            }

            // Cerrar la conexión
       
      
        }

    
