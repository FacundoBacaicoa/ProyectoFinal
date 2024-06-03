/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestiongimansio.Entidades;

/**
 *
 * @author facun
 */
public class Entrenadores {
     private int id_entrenadores;
    private String dni;
    private String nombre;
    private String apellido;
    private String especialidad;
    private boolean estado;

    public Entrenadores() {
    }

    public Entrenadores(int id_entrenadores, String dni, String nombre, String apellido, String especialidad, boolean estado) {
        this.id_entrenadores = id_entrenadores;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad = especialidad;
        this.estado = estado;
    }

    public int getId_entrenadores() {
        return id_entrenadores;
    }

    public void setId_entrenadores(int id_entrenadores) {
        this.id_entrenadores = id_entrenadores;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
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
        return "Entrenadores{" + "id_entrenadores=" + id_entrenadores + ", nombre=" + nombre + ", apellido=" + apellido + ", especialidad=" + especialidad + '}';
    }

}
