package com.clubsis.model.producto;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Set;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */
@Entity
public class Producto {

    @Id
    @GeneratedValue
    private Integer idProducto;
    private String descripcion;
    private String nombre;
    private Double precioVentaUnitario;

    @ManyToMany
    private Set<Proveedor> proveedor;

    @ManyToMany
    private Set<OrdenCompra> ordenes;

    protected Producto() {
    }

    public Producto(Integer idProducto, String descripcion, String nombre, Double precioVentaUnitario) {
        this.idProducto = idProducto;
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.precioVentaUnitario = precioVentaUnitario;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
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

    /*public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
*/
}
