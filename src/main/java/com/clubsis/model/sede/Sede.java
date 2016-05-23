package com.clubsis.model.sede;

import com.clubsis.model.bungalow.Bungalow;
import com.clubsis.model.evento.Evento;
import com.clubsis.model.producto.OrdenCompra;
import com.clubsis.model.producto.Proveedor;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Juan Tenorio on 12/4/2016.
 */

@Entity
public class Sede {

    @Id
    @GeneratedValue
    private Integer id;
    private String nombre;
    private String direccion;
    private String descripcion;

    @OneToMany(mappedBy = "sede")
    @JsonIgnore
    private Set<Bungalow> bungalows;

    @OneToMany(mappedBy ="sede")
    @JsonIgnore
    private Set<Evento> eventos = new HashSet<>();

    @ManyToMany
    private Set<Proveedor> proveedores;

    @OneToMany(mappedBy = "sede")
    @JsonIgnore
    private Set<OrdenCompra> ordenes;

    @OneToMany(mappedBy = "sede")
    @JsonIgnore
    private Set<Instalacion> instalaciones;


    protected Sede() {
    }

    public Sede(String nombre, String direccion, String descripcion, Set<Bungalow> bungalows, Set<Evento> eventos, Set<Proveedor> proveedores, Set<OrdenCompra> ordenes, Set<Instalacion> instalaciones) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.descripcion = descripcion;
        this.bungalows = bungalows;
        this.eventos = eventos;
        this.proveedores = proveedores;
        this.ordenes = ordenes;
        this.instalaciones = instalaciones;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<Bungalow> getBungalows() {
        return bungalows;
    }

    public void setBungalows(Set<Bungalow> bungalows) {
        this.bungalows = bungalows;
    }

    public Set<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(Set<Evento> eventos) {
        this.eventos = eventos;
    }

    public Set<Proveedor> getProveedores() {
        return proveedores;
    }

    public void setProveedores(Set<Proveedor> proveedores) {
        this.proveedores = proveedores;
    }

    public Set<OrdenCompra> getOrdenes() {
        return ordenes;
    }

    public void setOrdenes(Set<OrdenCompra> ordenes) {
        this.ordenes = ordenes;
    }

    public Set<Instalacion> getInstalaciones() {
        return instalaciones;
    }

    public void setInstalaciones(Set<Instalacion> instalaciones) {
        this.instalaciones = instalaciones;
    }
}
