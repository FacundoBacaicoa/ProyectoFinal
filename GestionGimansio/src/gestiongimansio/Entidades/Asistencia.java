
package gestiongimansio.Entidades;

import java.util.Date;

/**
 *
 * @author facun
 */
public class Asistencia {
        private int id_asistencia;
    private Socios id_Socio;
    private Clases id_Clase;
    private Date fechaAsistencia;

    public Asistencia() {
    }

    public Asistencia(int id_asistencia, Socios id_Socio, Clases id_Clase, Date fechaAsistencia) {
        this.id_asistencia = id_asistencia;
        this.id_Socio = id_Socio;
        this.id_Clase = id_Clase;
        this.fechaAsistencia = fechaAsistencia;
    }

    public int getId_asistencia() {
        return id_asistencia;
    }

    public void setId_asistencia(int id_asistencia) {
        this.id_asistencia = id_asistencia;
    }

    public Socios getId_Socio() {
        return id_Socio;
    }

    public void setId_Socio(Socios id_Socio) {
        this.id_Socio = id_Socio;
    }

    public Clases getId_Clase() {
        return id_Clase;
    }

    public void setId_Clase(Clases id_Clase) {
        this.id_Clase = id_Clase;
    }

    public Date getFechaAsistencia() {
        return fechaAsistencia;
    }

    public void setFechaAsistencia(Date fechaAsistencia) {
        this.fechaAsistencia = fechaAsistencia;
    }

    @Override
    public String toString() {
        return "Asistencia{" + "id_asistencia=" + id_asistencia + ", id_Socio=" + id_Socio + ", id_Clase=" + id_Clase + ", fechaAsistencia=" + fechaAsistencia + '}';
    }

  


}
