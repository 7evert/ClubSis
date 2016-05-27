package com.clubsis.model.producto;

import com.clubsis.model.sede.Sede;
import org.hibernate.exception.DataException;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */
@Entity
public class OrdenCompra {

    @Id
    @GeneratedValue
    private Integer id;
    private EstadoOrdenCompra estado;
    private Date fechaSolicitud;
    private Date fechaCancelación;
    private Double montoTotal;

    @ManyToOne
    private Proveedor proveedor;

    @ManyToMany
    private Set<Producto> productos = new HashSet<>();

    @ManyToOne
    private Sede sede;

    protected OrdenCompra() {
    }

    public OrdenCompra(EstadoOrdenCompra estado, Date fechaSolicitud, Double montoTotal, Date fechaCancelación, Proveedor proveedor, Set<Producto> productos, Sede sede) {
        this.estado = estado;
        this.fechaSolicitud = fechaSolicitud;
        this.montoTotal = montoTotal;
        this.fechaCancelación = fechaCancelación;
        this.proveedor = proveedor;
        this.productos = productos;
        this.sede = sede;
    }


    public EstadoOrdenCompra getEstado() {
        return estado;
    }

    public void setEstado(EstadoOrdenCompra estado) {
        this.estado = estado;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public Date getFechaCancelación() {
        return fechaCancelación;
    }

    public void setFechaCancelación(Date fechaCancelación) {
        this.fechaCancelación = fechaCancelación;
    }

    public Double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }


    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Set<Producto> getProductos() {
        return productos;
    }

    public void setProductos(Set<Producto> productos) {
        this.productos = productos;
    }
}
