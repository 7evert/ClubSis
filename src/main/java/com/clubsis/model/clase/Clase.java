package com.clubsis.model.clase;

import com.clubsis.model.pago.Pago;
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

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "clase")
    @JsonIgnore
    private Set<Pago> pagos = new HashSet<>();

    @ManyToOne
    //@JsonIgnore
    private Academia academia;

    protected Clase() {
    }

    public Clase(Integer nivel, Double precioCiclo, String rangoEdad, Double precioMes, Integer capacidad, EstadoClase estadoClase, String profesor, Ciclo ciclo, Set<RegistroClase> registros, Set<Horario> horarios, Set<Pago> pagos, Academia academia) {
        this.nivel = nivel;
        this.precioCiclo = precioCiclo;
        this.rangoEdad = rangoEdad;
        this.precioMes = precioMes;
        this.capacidad = capacidad;
        this.estadoClase = estadoClase;
        this.profesor = profesor;
        this.ciclo = ciclo;
        this.registros = registros;
        this.horarios = horarios;
        this.pagos = pagos;
        this.academia = academia;
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

    public Academia getAcademia() {
        return academia;
    }

    public void setAcademia(Academia academia) {
        this.academia = academia;
    }
}
