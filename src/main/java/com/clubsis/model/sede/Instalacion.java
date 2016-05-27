package com.clubsis.model.sede;

import com.clubsis.model.clase.Horario;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */

@Entity
public class Instalacion {
    @Id
    @GeneratedValue
    @Column(name = "id_instalacion")
    private Integer idInstalacion;
    private String descripcion;
    private String referencia;
    private Integer capacidad;
    private Double precioReserva;
    private Integer estado;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "instalacion")
    @JsonIgnore
    private Set<Horario> horarios;

    protected Instalacion() {
    }

    public Instalacion(String descripcion, String referencia, Integer capacidad, Double precioReserva, Integer estado, Set<Horario> horarios) {
        this.descripcion = descripcion;
        this.referencia = referencia;
        this.capacidad = capacidad;
        this.precioReserva = precioReserva;
        this.estado = estado;
        this.horarios = horarios;
    }

    public Integer getIdInstalacion() {
        return idInstalacion;
    }

    public void setIdInstalacion(Integer idInstalacion) {
        this.idInstalacion = idInstalacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public Double getPrecioReserva() {
        return precioReserva;
    }

    public void setPrecioReserva(Double precioReserva) {
        this.precioReserva = precioReserva;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Set<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(Set<Horario> horarios) {
        this.horarios = horarios;
    }
}
