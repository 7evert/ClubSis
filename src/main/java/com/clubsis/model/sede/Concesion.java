package com.clubsis.model.sede;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */
@Entity
public class Concesion {
    @Id
    @GeneratedValue
    private Integer id;
    private String razonSocial;
    private String ruc;
    private Date fechaInicio;
    private Date fechaVencimiento;
    private EstadoConcesion estadoConcesion;
    private String servicios;
    private String administrador;
    private String telefono;
    //ponerlo en SEDES!!!!

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "concesiones")
    @JsonIgnore
    private Set<Sede> sedes = new HashSet<>();

    protected Concesion() {
    }

    public Concesion(String razonSocial, String ruc, Date fechaInicio, Date fechaVencimiento, EstadoConcesion estadoConcesion, String servicios, String administrador, String telefono, Set<Sede> sedes) {
        this.razonSocial = razonSocial;
        this.ruc = ruc;
        this.fechaInicio = fechaInicio;
        this.fechaVencimiento = fechaVencimiento;
        this.estadoConcesion = estadoConcesion;
        this.servicios = servicios;
        this.administrador = administrador;
        this.telefono = telefono;
        this.sedes = sedes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public EstadoConcesion getEstadoConcesion() {
        return estadoConcesion;
    }

    public void setEstadoConcesion(EstadoConcesion estadoConcesion) {
        this.estadoConcesion = estadoConcesion;
    }

    public String getServicios() {
        return servicios;
    }

    public void setServicios(String servicios) {
        this.servicios = servicios;
    }

    public String getAdministrador() {
        return administrador;
    }

    public void setAdministrador(String administrador) {
        this.administrador = administrador;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Set<Sede> getSedes() {
        return sedes;
    }

    public void setSedes(Set<Sede> sedes) {
        this.sedes = sedes;
    }
}
