package com.clubsis.model.producto;

import javax.persistence.*;

import com.clubsis.model.sede.Sede;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.web.filter.ShallowEtagHeaderFilter;

import java.util.Set;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */
@Entity
public class Proveedor {

    @Id
    @GeneratedValue
    private Integer idProveedor;
    private String nombre;
    private String descripcion;
    private String numContacto;
    private String direccion;

    @ManyToMany
    private Set<Producto> productos;

    @OneToMany
    private Set<OrdenCompra> ordenes;

    @ManyToMany
    private Set<Sede> sedes;

    protected Proveedor() {
    }

    public Proveedor(Integer idProveedor, String nombre, String descripcion, String numContacto, String direccion) {
        this.idProveedor = idProveedor;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.numContacto = numContacto;
        this.direccion = direccion;
    }

    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
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
}
