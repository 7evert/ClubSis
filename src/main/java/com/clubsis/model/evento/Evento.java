package com.clubsis.model.evento;
import com.clubsis.model.persona.*;
import com.clubsis.model.sede.Sede;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.persistence.criteria.Fetch;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */
@Entity

public class Evento {
    @Id
    @GeneratedValue
    private Integer id;
    private String descripcion;
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private Date fechaInicio;
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private Date fechaFin;
    private EstadoEvento estado;
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private Date fechaInicioInscripcion;
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private Date fechaFinInscripcion;
    private String url;
    private Integer isGratuito;
    private Integer isPublico;
    private String nombre;
    private Integer capacidad;

    @JsonIgnore
    @ManyToMany
    private Set<Empresa> empresas = new HashSet<>();

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "eventos")
    private Set<TarifaEvento> tarifaxEventos = new HashSet<TarifaEvento>(0);

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "evento")
    private Set<InvitadoEvento> invitadoeventos = new HashSet<InvitadoEvento>(0);

    // este es el OWNER de la relación con sede
    @ManyToOne
    private Sede sede; // es un campo autor_id en la base de datos

    protected Evento() {
    }

    public Evento(String descripcion, Date fechaInicio, Date fechaFin, EstadoEvento estado, Date fechaInicioInscripcion, Date fechaFinInscripcion, String url, Integer isGratuito, Integer isPublico, String nombre, Integer capacidad, Set<Empresa> empresas, Set<TarifaEvento> tarifaxEventos, Set<InvitadoEvento> invitadoeventos, Sede sede) {
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
        this.fechaInicioInscripcion = fechaInicioInscripcion;
        this.fechaFinInscripcion = fechaFinInscripcion;
        this.url = url;
        this.isGratuito = isGratuito;
        this.isPublico = isPublico;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.empresas = empresas;
        this.tarifaxEventos = tarifaxEventos;
        this.invitadoeventos = invitadoeventos;
        this.sede = sede;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public EstadoEvento getEstado() {
        return estado;
    }

    public void setEstado(EstadoEvento estado) {
        this.estado = estado;
    }

    public Date getFechaInicioInscripcion() {
        return fechaInicioInscripcion;
    }

    public void setFechaInicioInscripcion(Date fechaInicioInscripcion) {
        this.fechaInicioInscripcion = fechaInicioInscripcion;
    }

    public Date getFechaFinInscripcion() {
        return fechaFinInscripcion;
    }

    public void setFechaFinInscripcion(Date fechaFinInscripcion) {
        this.fechaFinInscripcion = fechaFinInscripcion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getIsGratuito() {
        return isGratuito;
    }

    public void setIsGratuito(Integer isGratuito) {
        this.isGratuito = isGratuito;
    }

    public Integer getIsPublico() {
        return isPublico;
    }

    public void setIsPublico(Integer isPublico) {
        this.isPublico = isPublico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public Set<Empresa> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(Set<Empresa> empresas) {
        this.empresas = empresas;
    }

    public Set<TarifaEvento> getTarifaxEventos() {
        return tarifaxEventos;
    }

    public void setTarifaxEventos(Set<TarifaEvento> tarifaxEventos) {
        this.tarifaxEventos = tarifaxEventos;
    }

    public Set<InvitadoEvento> getInvitadoeventos() {
        return invitadoeventos;
    }

    public void setInvitadoeventos(Set<InvitadoEvento> invitadoeventos) {
        this.invitadoeventos = invitadoeventos;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }
}
