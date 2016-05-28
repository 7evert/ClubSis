package com.clubsis.model.persona;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Blitz on 22/05/2016.
 */
@Entity
@AssociationOverrides({
        @AssociationOverride(
                name = "id.socio", joinColumns = @JoinColumn(name="socio_id")),
        @AssociationOverride(
                name ="id.postulante",joinColumns=@JoinColumn(name="postulante_id")
        ),
})
public class Socio_Postulante{
    //Se puede evitar crear una clase para ambos ID's pero eso implicaría que la tabla cruzada tenga su propio id
    @EmbeddedId
    private Socio_PostulanteID id = new Socio_PostulanteID();

    private String observaciones ;

    protected Socio_Postulante() {}

    public Socio_Postulante(Socio_PostulanteID id, String observaciones) {
        this.id = id;
        this.observaciones = observaciones;
    }

    public Socio_PostulanteID getId() {
        return id;
    }

    public void setId(Socio_PostulanteID id) {
        this.id = id;
    }

    @Transient
    public Socio getSocio() {
        return getId().getSocio();
    }

    public void setSocio(Socio socio) {
        getId().setSocio(socio);
    }

    @Transient
    public Postulante getPostulante() {
        return getId().getPostulante();
    }

    public void setPostulante(Postulante postulante) {
        getId().setPostulante(postulante);
    }



    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Socio_Postulante that = (Socio_Postulante) o;

        if (getId() != null ? !getId().equals(that.getId())
                : that.getId() != null)
            return false;

        return true;
    }

    public int hashCode() {
        return (getId() != null ? getId().hashCode() : 0);
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
