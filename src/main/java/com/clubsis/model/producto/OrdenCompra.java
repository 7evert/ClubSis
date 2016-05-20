package com.clubsis.model.producto;

import com.clubsis.model.sede.Sede;
import org.hibernate.exception.DataException;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import java.util.Set;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */
@Entity
public class OrdenCompra {

    @Id
    @GeneratedValue
    private Integer idOrdenCompra;
    private EstadoOrdenCompra estado;
    private Date fechaSolicitud;
    private Date fechaCancelación;
    private Double montoTotal;

    @ManyToOne
    private Proveedor proveedor;

    @ManyToMany
    private Set<Producto> productos;

    @ManyToOne
    private Sede sede;

    protected OrdenCompra() {
    }

    public OrdenCompra(Integer idOrdenCompra, EstadoOrdenCompra estado, Date fechaSolicitud, Date fechaCancelación, Double montoTotal) {
        this.idOrdenCompra = idOrdenCompra;
        this.estado = estado;
        this.fechaSolicitud = fechaSolicitud;
        this.fechaCancelación = fechaCancelación;
        this.montoTotal = montoTotal;
    }

    public Integer getIdOrdenCompra() {
        return idOrdenCompra;
    }

    public void setIdOrdenCompra(Integer idOrdenCompra) {
        this.idOrdenCompra = idOrdenCompra;
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

   /* public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }*/

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }
}
