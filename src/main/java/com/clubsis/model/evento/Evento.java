package com.clubsis.model.evento;
import com.clubsis.model.bungalow.EstadoBungalow;
import com.clubsis.model.persona.*;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */
@Entity

public class Evento {
    @Id
    @GeneratedValue
    private Integer idEvento;
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

    @ManyToMany
    private Set<TarifaEvento> tarifaEventos;

    @ManyToMany
    private Set<Persona> personas;

    @ManyToMany
    private Set<Empresa> empresas;

    protected Evento() {
    }

    public Evento(Integer idEvento, Date fechaInicio, String descripcion, Date fechaFin, EstadoEvento estado, Date fechaInicioInscripcion, String reglamento, Date fechaFinInscripcion) {
        this.idEvento = idEvento;
        this.fechaInicio = fechaInicio;
        this.descripcion = descripcion;
        this.fechaFin = fechaFin;
        this.estado = estado;
        this.fechaInicioInscripcion = fechaInicioInscripcion;
        this.reglamento = reglamento;
        this.fechaFinInscripcion = fechaFinInscripcion;
    }

    public Integer getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Integer idEvento) {
        this.idEvento = idEvento;
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
}
