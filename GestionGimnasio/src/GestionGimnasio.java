
import gestiongimnasio.DAO.ClaseData;
import gestiongimnasio.DAO.EntrenadorData;
import gestiongimnasio.Entidades.Clase;
import gestiongimnasio.Entidades.Entrenador;

public class GestionGimnasio {
    public static void main(String[] args) {
        ClaseData claseD = new ClaseData();
        EntrenadorData entrenadorData = new EntrenadorData();
        
        Entrenador entrenador = new Entrenador(1, 12345678, "Lucas", "Hernandez", "Funcional", true);
        
        // Verificar si el entrenador existe, si no, añadirlo
        entrenadorData.agregarEntrenadorSiNoExiste(entrenador);

        // Ahora podemos agregar la clase
        Clase nuevaClase = new Clase(1, "Yoga", entrenador, "18:00:00", 20, true);
        claseD.guardarClase(nuevaClase);
    }
}
