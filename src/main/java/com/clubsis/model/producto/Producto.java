package com.clubsis.model.producto;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */
public class Producto {
    private Integer idProducto;
    private String descripcion;

    protected Producto() {
    }

    public Producto(Integer idProducto, String descripcion) {
        this.idProducto = idProducto;
        this.descripcion = descripcion;
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
}
