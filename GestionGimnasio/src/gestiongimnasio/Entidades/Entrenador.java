
package gestiongimnasio.Entidades;

/**
 *
 * @author facun
 */
public class Entrenador {
     private int id_entrenadores;
    private int dni;
    private String nombre;
    private String apellido;
    private String especialidad;
    private boolean estado;//que todo el borrado sea logico menos la asistencia 

    public Entrenador() {
    }

    public Entrenador(int id_entrenadores, int dni, String nombre, String apellido, String especialidad, boolean estado) {
        this.id_entrenadores = id_entrenadores;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad = especialidad;
        this.estado = estado;
    }
    
        public Entrenador(int dni, String nombre, String apellido, String especialidad, boolean estado) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad = especialidad;
        this.estado = estado;
    }
    
    public int getId_entrenadores() {
        return id_entrenadores;
    }

    public void setId_entrenadores(int id_entrenador) {
        this.id_entrenadores = id_entrenador;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Entrenadores{" + "id_entrenador=" + id_entrenadores + ", nombre=" + nombre + ", apellido=" + apellido + ", especialidad=" + especialidad + '}';
    }

}
