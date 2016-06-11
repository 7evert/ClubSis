package com.clubsis.model.sede;

import com.clubsis.model.bungalow.Bungalow;
import com.clubsis.model.club.Usuario;
import com.clubsis.model.evento.Evento;
import com.clubsis.model.producto.OrdenCompra;
import com.clubsis.model.producto.Producto;
import com.clubsis.model.producto.Producto_Sede;
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
    private String telefono;
    private String administrador;
    private EstadoSede estado;
    @JsonIgnore
    @OneToMany(mappedBy = "sede", cascade = CascadeType.ALL)
    private Set<Bungalow> bungalows;

    @JsonIgnore
    @OneToMany(mappedBy = "sede", cascade = CascadeType.ALL)
    private Set<Evento> eventos = new HashSet<>();

    @ManyToMany
    private Set<Proveedor> proveedores = new HashSet<>();

    @OneToMany(mappedBy = "sede")
    @JsonIgnore
    private Set<OrdenCompra> ordenes;

    @OneToMany(mappedBy = "sede")
    @JsonIgnore
    private Set<Instalacion> instalaciones;

    @ManyToMany
    private Set<Concesion> concesiones = new HashSet<>();

    @OneToMany(mappedBy="id.sede",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Producto_Sede> productos =new HashSet<Producto_Sede>();

    @ManyToMany(mappedBy = "sedes")
    @JsonIgnore
    private Set<Usuario> usuarios = new HashSet<>();

    protected Sede() {
    }

    public Sede(String nombre, String direccion, String descripcion, String telefono, String administrador, EstadoSede estado, Set<Bungalow> bungalows, Set<Evento> eventos, Set<Proveedor> proveedores, Set<OrdenCompra> ordenes, Set<Instalacion> instalaciones, Set<Concesion> concesiones, Set<Producto_Sede> productos, Set<Usuario> usuarios) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.descripcion = descripcion;
        this.telefono = telefono;
        this.administrador = administrador;
        this.estado = estado;
        this.bungalows = bungalows;
        this.eventos = eventos;
        this.proveedores = proveedores;
        this.ordenes = ordenes;
        this.instalaciones = instalaciones;
        this.concesiones = concesiones;
        this.productos = productos;
        this.usuarios = usuarios;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getAdministrador() {
        return administrador;
    }

    public void setAdministrador(String administrador) {
        this.administrador = administrador;
    }

    public EstadoSede getEstado() {
        return estado;
    }

    public void setEstado(EstadoSede estado) {
        this.estado = estado;
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

    public Set<Concesion> getConcesiones() {
        return concesiones;
    }

    public void setConcesiones(Set<Concesion> concesiones) {
        this.concesiones = concesiones;
    }

    public Set<Producto_Sede> getProductos() {
        return productos;
    }

    public void setProductos(Set<Producto_Sede> productos) {
        this.productos = productos;
    }

    public Set<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
