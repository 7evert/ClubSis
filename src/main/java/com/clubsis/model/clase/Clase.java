package com.clubsis.model.clase;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */

@Entity
public class Clase {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer nivel;
    private String rangoEdad;
    private Double precioCiclo;
    private Double precioMes;
    private Integer capacidad;
    private String profesor;

    private EstadoClase estadoClase;

    protected Clase() {
    }

    public Clase(Integer nivel, String rangoEdad, Double precioCiclo, Double precioMes, Integer capacidad, String profesor, EstadoClase estadoClase) {
        this.nivel = nivel;
        this.rangoEdad = rangoEdad;
        this.precioCiclo = precioCiclo;
        this.precioMes = precioMes;
        this.capacidad = capacidad;
        this.profesor = profesor;
        this.estadoClase = estadoClase;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public String getRangoEdad() {
        return rangoEdad;
    }

    public void setRangoEdad(String rangoEdad) {
        this.rangoEdad = rangoEdad;
    }

    public Double getPrecioCiclo() {
        return precioCiclo;
    }

    public void setPrecioCiclo(Double precioCiclo) {
        this.precioCiclo = precioCiclo;
    }

    public Double getPrecioMes() {
        return precioMes;
    }

    public void setPrecioMes(Double precioMes) {
        this.precioMes = precioMes;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public EstadoClase getEstadoClase() {
        return estadoClase;
    }

    public void setEstadoClase(EstadoClase estadoClase) {
        this.estadoClase = estadoClase;
    }
}
