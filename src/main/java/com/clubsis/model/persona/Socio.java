package com.clubsis.model.persona;

import com.clubsis.model.club.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import javax.persistence.*;
import java.util.Set;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */
@Entity
public class Socio {
    @Id
    @GeneratedValue
    private Integer id;
    private Date fechaInscripcion;
    private Integer estado;
    //@Column(columnDefinition = "integer auto_increment")
    private Integer codigoCarnet;

    @OneToMany(fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Invitado> Invitados;

    @OneToMany(fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Persona> personas;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Postulante> postulantes;

    @OneToMany(fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Suspension> suspension;


    protected Socio() {
    }

    public Socio(Date fechaInscripcion, Integer estado, Integer codigoCarnet) {
        this.fechaInscripcion = fechaInscripcion;
        this.estado = estado;
        this.codigoCarnet = codigoCarnet;
    }



    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(Date fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Integer getCodigoCarnet() {
        return codigoCarnet;
    }

    public void setCodigoCarnet(Integer codigoCarnet) {
        this.codigoCarnet = codigoCarnet;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<Invitado> getInvitados() {
        return Invitados;
    }

    public void setInvitados(Set<Invitado> invitados) {
        Invitados = invitados;
    }

    public Set<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(Set<Persona> personas) {
        this.personas = personas;
    }

    public Set<Postulante> getPostulantes() {
        return postulantes;
    }

    public void setPostulantes(Set<Postulante> postulantes) {
        this.postulantes = postulantes;
    }

    public Set<Suspension> getSuspension() {
        return suspension;
    }

    public void setSuspension(Set<Suspension> suspension) {
        this.suspension = suspension;
    }
}
