package com.clubsis.model.producto;

import javax.persistence.*;

import com.clubsis.model.sede.Sede;
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

    private EstadoProducto estadoProducto;

    @ManyToMany
    private Set<Proveedor> proveedores = new HashSet<>();

    @ManyToMany
    private Set<OrdenCompra> ordenes = new HashSet<>();
/*
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "productos")
    @JsonIgnore
    private Set<Sede> sedes = new HashSet<>();
*/
    @OneToMany(mappedBy="id.producto",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Producto_Sede> sedes=new HashSet<Producto_Sede>();

    protected Producto() {
    }

    public Producto(String descripcion, String nombre, Double precioVentaUnitario, EstadoProducto estadoProducto, Set<Proveedor> proveedores, Set<OrdenCompra> ordenes, Set<Producto_Sede> sedes) {
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.precioVentaUnitario = precioVentaUnitario;
        this.estadoProducto = estadoProducto;
        this.proveedores = proveedores;
        this.ordenes = ordenes;
        this.sedes = sedes;
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

    public EstadoProducto getEstadoProducto() {
        return estadoProducto;
    }

    public void setEstadoProducto(EstadoProducto estadoProducto) {
        this.estadoProducto = estadoProducto;
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

    public Set<Producto_Sede> getSedes() {
        return sedes;
    }

    public void setSedes(Set<Producto_Sede> sedes) {
        this.sedes = sedes;
    }
}
