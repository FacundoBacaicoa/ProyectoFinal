
package gestiongimnasio.Entidades;

/**
 *
 * @author facun
 */
public class Clase {
       private int id_clase;
    private String nombre;
    private Entrenador id_entrenador;
    private String horario;
    private int capacidad;
    private boolean estado;

    public Clase() {
    }
    
    public Clase(int id_clase, String nombre,Entrenador id_entrenador, String horario, int capacidad, boolean estado) {
        this.id_clase = id_clase;
        this.nombre = nombre;
        this.id_entrenador = id_entrenador;
        this.horario = horario;
        this.capacidad = capacidad;
        this.estado = estado;
    }

    public Entrenador getIdEntrenador() {
        return id_entrenador;
    }

    public void setIdEntrenador(Entrenador id_entrenador) {
        this.id_entrenador = id_entrenador;
    }
    public Clase(int id_clase) {
        this.id_clase = id_clase;
    }

    public int getId_clase() {
        return id_clase;
    }

    public void setId_clase(int id_clase) {
        this.id_clase = id_clase;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

  

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Clases{" + "id_clase=" + id_clase + ", nombre=" + nombre + ", entrenador=" + id_entrenador + ", horario=" + horario + ", capacidad=" + capacidad + '}';
    }

}
