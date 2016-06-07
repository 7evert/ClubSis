package com.clubsis.model.persona;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Blitz on 22/05/2016.
 */
@Entity
public class SocioPostulante {
    @Id
    @GeneratedValue
    private Integer id;

    private String observaciones;

    @ManyToOne
    @JoinColumn(name = "socio_id")
    private Socio socio;

    @ManyToOne
    @JoinColumn(name = "postulante_id")
    private Postulante postulante;

    protected SocioPostulante (){
        
    }
    public SocioPostulante(String observaciones, Socio socio, Postulante postulante) {
        this.observaciones = observaciones;
        this.socio = socio;
        this.postulante = postulante;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
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
}
