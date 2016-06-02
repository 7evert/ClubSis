package com.clubsis.model.sede;

import com.clubsis.model.pago.Pago;
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

    @OneToMany(mappedBy = "instalacion")
    @JsonIgnore
    private Set<ReservaInstalacion> reservas;

    @OneToMany(mappedBy = "instalacion")
    @JsonIgnore
    private Set<Pago> pago;

    protected Instalacion() {
    }

    public Instalacion(String nombre, String caracteristicas, String referencia, Integer capacidad, Double precioReserva, String estado, Sede sede, Set<ReservaInstalacion> reservaInstalacionSet, Set<Horario> horarios, Set<ReservaInstalacion> reservas, Set<Pago> pago) {
        this.nombre = nombre;
        this.caracteristicas = caracteristicas;
        this.referencia = referencia;
        this.capacidad = capacidad;
        this.precioReserva = precioReserva;
        this.estado = estado;
        this.sede = sede;
        this.reservaInstalacionSet = reservaInstalacionSet;
        this.horarios = horarios;
        this.reservas = reservas;
        this.pago = pago;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

    public Set<ReservaInstalacion> getReservaInstalacionSet() {
        return reservaInstalacionSet;
    }

    public void setReservaInstalacionSet(Set<ReservaInstalacion> reservaInstalacionSet) {
        this.reservaInstalacionSet = reservaInstalacionSet;
    }

    public Set<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(Set<Horario> horarios) {
        this.horarios = horarios;
    }

    public Set<Pago> getPago() {
        return pago;
    }

    public void setPago(Set<Pago> pago) {
        this.pago = pago;
    }
}
