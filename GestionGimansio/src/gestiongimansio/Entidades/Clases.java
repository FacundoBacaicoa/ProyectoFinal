
package gestiongimansio.Entidades;

/**
 *
 * @author facun
 */
public class Clases {
       private int id_clase;
    private String nombre;
    private Entrenadores idEntrenador;
    private String horario;
    private int capacidad;
    private boolean estado;

    public Clases() {
    }

    public Clases(int id_clase, String nombre,Entrenadores idEntrenador, String horario, int capacidad, boolean estado) {
        this.id_clase = id_clase;
        this.nombre = nombre;
        this.idEntrenador = idEntrenador;
        this.horario = horario;
        this.capacidad = capacidad;
        this.estado = estado;
    }

    public Entrenadores getIdEntrenador() {
        return idEntrenador;
    }

    public void setIdEntrenador(Entrenadores idEntrenador) {
        this.idEntrenador = idEntrenador;
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
        return "Clases{" + "id_clase=" + id_clase + ", nombre=" + nombre + ", idEntrenador=" + idEntrenador + ", horario=" + horario + ", capacidad=" + capacidad + '}';
    }

}
