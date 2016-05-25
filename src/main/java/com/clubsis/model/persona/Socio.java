package com.clubsis.model.persona;

import com.clubsis.model.club.Usuario;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import sun.util.PreHashedMap;

import java.util.Date;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */
@Entity
public class Socio {
    @Id
    @GeneratedValue
    private Integer id;
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private Date fechaInscripcion;
    private EstadoSocio estado;
    //@Column(columnDefinition = "integer auto_increment")
    private Integer codigoCarnet;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "socio")
    private Set<Invitado> invitados =new HashSet<Invitado>();

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Postulante> postulantes=new HashSet<Postulante>();

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER)
    private Set<Suspension> suspensiones =new HashSet<Suspension>();

    protected Socio() {
    }

    public Socio(Date fechaInscripcion, EstadoSocio estado, Set<Invitado> invitados, Integer codigoCarnet, Set<Postulante> postulantes, Set<Suspension> suspensiones) {
        this.fechaInscripcion = fechaInscripcion;
        this.estado = estado;
        this.invitados = invitados;
        this.codigoCarnet = codigoCarnet;
        this.postulantes = postulantes;
        this.suspensiones = suspensiones;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(Date fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public EstadoSocio getEstado() {
        return estado;
    }

    public void setEstado(EstadoSocio estado) {
        this.estado = estado;
    }

    public Integer getCodigoCarnet() {
        return codigoCarnet;
    }

    public void setCodigoCarnet(Integer codigoCarnet) {
        this.codigoCarnet = codigoCarnet;
    }

    public Set<Invitado> getInvitados() {
        return invitados;
    }

    public void setInvitados(Set<Invitado> invitados) {
        this.invitados = invitados;
    }

    public Set<Postulante> getPostulantes() {
        return postulantes;
    }

    public void setPostulantes(Set<Postulante> postulantes) {
        this.postulantes = postulantes;
    }

    public Set<Suspension> getSuspensiones() {
        return suspensiones;
    }

    public void setSuspensiones(Set<Suspension> suspensiones) {
        this.suspensiones = suspensiones;
    }
}
