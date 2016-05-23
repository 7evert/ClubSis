package com.clubsis.model.clase;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

    @ManyToOne
    private Ciclo ciclo;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "clase")
    @JsonIgnore
    private Set<RegistroClase> registros = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "clase")
    @JsonIgnore
    private Set<Horario> horarios = new HashSet<>();

    protected Clase() {
    }

    public Clase(Integer nivel, String rangoEdad, Double precioCiclo, Double precioMes, Integer capacidad, String profesor, EstadoClase estadoClase, Ciclo ciclo, Set<RegistroClase> registros, Set<Horario> horarios) {
        this.nivel = nivel;
        this.rangoEdad = rangoEdad;
        this.precioCiclo = precioCiclo;
        this.precioMes = precioMes;
        this.capacidad = capacidad;
        this.profesor = profesor;
        this.estadoClase = estadoClase;
        this.ciclo = ciclo;
        this.registros = registros;
        this.horarios = horarios;
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

    public Ciclo getCiclo() {
        return ciclo;
    }

    public void setCiclo(Ciclo ciclo) {
        this.ciclo = ciclo;
    }

    public Set<RegistroClase> getRegistros() {
        return registros;
    }

    public void setRegistros(Set<RegistroClase> registros) {
        this.registros = registros;
    }

    public Set<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(Set<Horario> horarios) {
        this.horarios = horarios;
    }
}
