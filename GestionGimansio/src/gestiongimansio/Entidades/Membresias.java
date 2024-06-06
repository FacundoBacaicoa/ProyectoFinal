
package gestiongimansio.Entidades;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author facun
 */
public class Membresias {
    private int id_membresia;
    private Socios id_Socio;
    private int cantidadPases;
    private Date fechaInicio;
    private Date fechaFin;
    private BigDecimal costo;
    private boolean estado;

    public Membresias() {
    }

    public Membresias(int id,Socios idSocio, int cantidadPases, Date fechaInicio, Date fechaFin, BigDecimal costo, boolean estado) {
        this.id_membresia = id;
        this.id_Socio = idSocio;
        this.cantidadPases = cantidadPases;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.costo = costo;
        this.estado = estado;
    }

    public int getId() {
        return id_membresia;
    }

    public void setId(int id) {
        this.id_membresia = id;
    }

    public int getId_membresia() {
        return id_membresia;
    }

    public void setId_membresia(int id_membresia) {
        this.id_membresia = id_membresia;
    }

    public Socios getId_Socio() {
        return id_Socio;
    }

    public void setId_Socio(Socios id_Socio) {
        this.id_Socio = id_Socio;
    }



    public int getCantidadPases() {
        return cantidadPases;
    }

    public void setCantidadPases(int cantidadPases) {
        this.cantidadPases = cantidadPases;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Membresias{" + "id_membresia=" + id_membresia + ", cantidadPases=" + cantidadPases + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + '}';
    }

}
