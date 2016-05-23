package com.clubsis.model.sede;

import com.clubsis.model.bungalow.ReservaBungalow;
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
    @Column(name="id_instalacion")
    private Integer id;
    private String nombre;
    private String caracteristicas;;
    private String referencia;
    private Integer capacidad;
    private Double precioReserva;
    private Integer estado;

    @ManyToOne
    private Sede sede; // necesaria (composición)

    @OneToMany(mappedBy = "instalacion")

    @JsonIgnore
    private Set<ReservaInstalacion> reservaInstalacionSet; // no es necesario al inicio (vacío)

    protected Instalacion() {
    }

    public Instalacion(Integer idInstalacion, String referencia, String caracteristicas, Integer capacidad, Double precioReserva, Integer estado,Sede sede) {
        this.setId(idInstalacion);
        this.referencia = referencia;
        this.setCaracteristicas(caracteristicas);
        this.capacidad = capacidad;
        this.precioReserva = precioReserva;
        this.sede=sede;
        this.estado = estado;
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
}
