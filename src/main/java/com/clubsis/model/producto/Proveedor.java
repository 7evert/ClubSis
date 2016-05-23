package com.clubsis.model.producto;

import javax.persistence.*;

import com.clubsis.model.sede.Sede;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.web.filter.ShallowEtagHeaderFilter;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */
@Entity
public class Proveedor {

    @Id
    @GeneratedValue
    private Integer id;
    private String nombre;
    private String descripcion;
    private String numContacto;
    private String direccion;
    private Integer isHabilitado;


    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "proveedores")
    @JsonIgnore
    private Set<Producto> productos = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "proveedor")
    @JsonIgnore
    private Set<OrdenCompra> ordenes = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "proveedores")
    @JsonIgnore
    private Set<Sede> sedes = new HashSet<>();

    public Proveedor() {
    }

    public Proveedor(String nombre, String descripcion, String numContacto, String direccion, Integer isHabilitado, Set<Producto> productos, Set<OrdenCompra> ordenes, Set<Sede> sedes) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.numContacto = numContacto;
        this.direccion = direccion;
        this.isHabilitado = isHabilitado;
        this.productos = productos;
        this.ordenes = ordenes;
        this.sedes = sedes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNumContacto() {
        return numContacto;
    }

    public void setNumContacto(String numContacto) {
        this.numContacto = numContacto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Set<Producto> getProductos() {
        return productos;
    }

    public void setProductos(Set<Producto> productos) {
        this.productos = productos;
    }

    public Set<OrdenCompra> getOrdenes() {
        return ordenes;
    }

    public void setOrdenes(Set<OrdenCompra> ordenes) {
        this.ordenes = ordenes;
    }

    public Set<Sede> getSedes() {
        return sedes;
    }

    public void setSedes(Set<Sede> sedes) {
        this.sedes = sedes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIsHabilitado() {
        return isHabilitado;
    }

    public void setIsHabilitado(Integer isHabilitado) {
        this.isHabilitado = isHabilitado;
    }
}
