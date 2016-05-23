package com.clubsis.model.clase;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;
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

    @OneToMany(mappedBy = "ciclo")
    private Set<Clase> clases;

    // TODO: ManyToMany con Academia

    protected Ciclo() {
    }

    public Ciclo(String descripcion, Date fechaInicio, Date fechaFin, EstadoCiclo estadoCiclo) {
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estadoCiclo = estadoCiclo;
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
}
