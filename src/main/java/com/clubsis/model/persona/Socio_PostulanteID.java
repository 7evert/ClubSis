package com.clubsis.model.persona;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by Blitz on 22/05/2016.
 */
@Embeddable
public class Socio_PostulanteID implements Serializable{
    @ManyToOne(cascade = CascadeType.ALL)
    private Socio socio;
    @ManyToOne(cascade = CascadeType.ALL)
    private Postulante postulante;

    protected Socio_PostulanteID() {
    }

    public Socio_PostulanteID(Socio socio, Postulante postulante) {
        this.socio = socio;
        this.postulante = postulante;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public Postulante getPostulante() {
        return postulante;
    }

    public void setPostulante(Postulante postulante) {
        this.postulante = postulante;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Socio_PostulanteID that = (Socio_PostulanteID) o;

        if (socio != null ? !socio.equals(that.socio) : that.socio != null) return false;
        if (postulante != null ? !postulante.equals(that.postulante) : that.postulante != null)
            return false;

        return true;
    }

    public int hashCode() {
        int result;
        result = (socio != null ? socio.hashCode() : 0);
        result = 31 * result + (postulante != null ? postulante.hashCode() : 0);
        return result;
    }

}
