package com.clubsis.model.clase;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */

@Entity
public class Ciclo {
    @Id
    @GeneratedValue
    private Integer id;
    private String descripcion;
    private Date fechaInicio;
    private Date fechaFin;
    private EstadoCiclo estadoCiclo;

    @ManyToMany
    private Set<Academia> academias = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "ciclo")
    @JsonIgnore
    private Set<Clase> clases = new HashSet<>();

    protected Ciclo() {
    }

    public Ciclo(String descripcion, Date fechaInicio, Date fechaFin, EstadoCiclo estadoCiclo, Set<Academia> academias, Set<Clase> clases) {
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estadoCiclo = estadoCiclo;
        this.academias = academias;
        this.clases = clases;
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

    public EstadoCiclo getEstadoCiclo() {
        return estadoCiclo;
    }

    public void setEstadoCiclo(EstadoCiclo estadoCiclo) {
        this.estadoCiclo = estadoCiclo;
    }

    public Set<Academia> getAcademias() {
        return academias;
    }

    public void setAcademias(Set<Academia> academias) {
        this.academias = academias;
    }

    public Set<Clase> getClases() {
        return clases;
    }

    public void setClases(Set<Clase> clases) {
        this.clases = clases;
    }
}
