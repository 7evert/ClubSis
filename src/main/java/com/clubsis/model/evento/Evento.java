package com.clubsis.model.evento;
import com.clubsis.model.persona.*;
import com.clubsis.model.sede.Sede;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
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
    private String reglamento;
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private Date fechaInicioInscripcion;
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private Date fechaFinInscripcion;
    private String url;
    private Integer isGratuito;
    private Integer isPublico;
    private String nombre;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "eventos",cascade= CascadeType.ALL)
    private Set<TarifaEvento> tarifaxEventos = new HashSet<TarifaEvento>(0);

    @JsonIgnore
    @ManyToMany
    private Set<Persona> personas = new HashSet<>();

    @JsonIgnore
    @ManyToMany
    private Set<Empresa> empresas = new HashSet<>();

    // este es el OWNER de la relación con sede
    @ManyToOne
    private Sede sede; // es un campo autor_id en la base de datos

    protected Evento() {
    }

    public Evento(String descripcion, Date fechaInicio, EstadoEvento estado, Date fechaFin, String reglamento, String url, Date fechaFinInscripcion, Date fechaInicioInscripcion, Integer isGratuito, Integer isPublico, String nombre, Set<TarifaEvento> tarifaxEventos, Set<Persona> personas, Set<Empresa> empresas, Sede sede) {
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.estado = estado;
        this.fechaFin = fechaFin;
        this.reglamento = reglamento;
        this.url = url;
        this.fechaFinInscripcion = fechaFinInscripcion;
        this.fechaInicioInscripcion = fechaInicioInscripcion;
        this.isGratuito = isGratuito;
        this.isPublico = isPublico;
        this.nombre = nombre;
        this.tarifaxEventos = tarifaxEventos;
        this.personas = personas;
        this.empresas = empresas;
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

    public String getReglamento() {
        return reglamento;
    }

    public void setReglamento(String reglamento) {
        this.reglamento = reglamento;
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


    public Set<TarifaEvento> getTarifaxEventos() {
        return tarifaxEventos;
    }

    public void setTarifaxEventos(Set<TarifaEvento> tarifaxEventos) {
        this.tarifaxEventos = tarifaxEventos;
    }

    public Set<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(Set<Persona> personas) {
        this.personas = personas;
    }

    public Set<Empresa> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(Set<Empresa> empresas) {
        this.empresas = empresas;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }
}
