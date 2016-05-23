package com.clubsis.model.producto;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */
@Entity
public class Producto {

    @Id
    @GeneratedValue
    private Integer id;
    private String descripcion;
    private String nombre;
    private Double precioVentaUnitario;

    @ManyToMany
    private Set<Proveedor> proveedores = new HashSet<>();

    @ManyToMany
    private Set<OrdenCompra> ordenes = new HashSet<>();

    protected Producto() {
    }

    public Producto(String descripcion, Double precioVentaUnitario, String nombre, Set<Proveedor> proveedores, Set<OrdenCompra> ordenes) {
        this.descripcion = descripcion;
        this.precioVentaUnitario = precioVentaUnitario;
        this.nombre = nombre;
        this.proveedores = proveedores;
        this.ordenes = ordenes;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecioVentaUnitario() {
        return precioVentaUnitario;
    }

    public void setPrecioVentaUnitario(Double precioVentaUnitario) {
        this.precioVentaUnitario = precioVentaUnitario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

}
