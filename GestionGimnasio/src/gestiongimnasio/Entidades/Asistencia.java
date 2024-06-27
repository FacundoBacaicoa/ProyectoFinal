
package gestiongimnasio.Entidades;

import java.util.Date;

/**
 *
 * @author facun
 */
public class Asistencia {
    private int id_asistencia;
    private Socio Socio;
    private Clase Clase;
    private Date fechaAsistencia;

    public Asistencia() {
    }

    public Asistencia(int id_asistencia, Socio Socio, Clase Clase, Date fechaAsistencia) {
        this.id_asistencia = id_asistencia;
        this.Socio = Socio;
        this.Clase = Clase;
        this.fechaAsistencia = fechaAsistencia;
    }

    public int getId_asistencia() {
        return id_asistencia;
    }

    public void setId_asistencia(int id_asistencia) {
        this.id_asistencia = id_asistencia;
    }

    public Socio getId_Socio() {
        return Socio;
    }

    public void setId_Socio(Socio Socio) {
        this.Socio = Socio;
    }

    public Clase getId_Clase() {
        return Clase;
    }

    public void setId_Clase(Clase Clase) {
        this.Clase = Clase;
    }

    public Date getFechaAsistencia() {
        return fechaAsistencia;
    }

    public void setFechaAsistencia(Date fechaAsistencia) {
        this.fechaAsistencia = fechaAsistencia;
    }

    @Override
    public String toString() {
        return "Asistencia{" + "id_asistencia=" + id_asistencia + ", Socio=" + Socio + ", Clase=" + Clase + ", fechaAsistencia=" + fechaAsistencia + '}';
    }

  


}
