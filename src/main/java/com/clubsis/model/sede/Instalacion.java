package com.clubsis.model.sede;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;
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
    private Integer id;
    private String nombre;
    private String caracteristicas;
    private String referencia;
    private Integer capacidad;
    private Double precioReserva;
    private String estado;

    @ManyToOne
    private Sede sede; // necesaria (composición)
/*
    @OneToMany(fetch=FetchType.EAGER,mappedBy = "instalacion")
    @JsonIgnore
    private Set<Horario> horarios;
*/
    @OneToMany(mappedBy = "instalacion")
    @JsonIgnore
    private Set<ReservaInstalacion> reservaInstalacionSet; // no es necesario al inicio (vacío)

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "instalacion")
    @JsonIgnore
    private Set<Horario> horarios;

    @ManyToOne
    private Sede sede;

    @OneToMany(mappedBy = "instalacion")
    private Set<ReservaInstalacion> reservas;

    protected Instalacion() {
    }

    public Instalacion(String descripcion, String referencia, Integer capacidad, Double precioReserva, Integer estado, Set<Horario> horarios, Sede sede, Set<ReservaInstalacion> reservas) {
        this.descripcion = descripcion;
        this.referencia = referencia;
    public Instalacion(Integer idInstalacion, String referencia, String caracteristicas, Integer capacidad, Double precioReserva, String estado,Sede sede) {
        this.setId(idInstalacion);
        this.referencia = referencia;
        this.setCaracteristicas(caracteristicas);
        this.capacidad = capacidad;
        this.precioReserva = precioReserva;
        this.estado = estado;
        this.horarios = horarios;
        this.sede = sede;
        this.reservas = reservas;
        this.sede=sede;
        this.setEstado(estado);
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    public Set<ReservaInstalacion> getReservaInstalacionSet() {
        return reservaInstalacionSet;
    }

    public void setReservaInstalacionSet(Set<ReservaInstalacion> reservaInstalacionSet) {
        this.reservaInstalacionSet = reservaInstalacionSet;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Set<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(Set<Horario> horarios) {
        this.horarios = horarios;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    public Set<ReservaInstalacion> getReservas() {
        return reservas;
    }

    public void setReservas(Set<ReservaInstalacion> reservas) {
        this.reservas = reservas;
    }
/*
    public Set<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(Set<Horario> horarios) {
        this.horarios = horarios;
    }
    */
}
