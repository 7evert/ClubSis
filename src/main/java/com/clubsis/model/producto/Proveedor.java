package com.clubsis.model.producto;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */
public class Proveedor {
    private Integer idProveedor;
    private String descripcion;

    protected Proveedor() {
    }

    public Proveedor(Integer idProveedor, String descripcion) {
        this.idProveedor = idProveedor;
        this.descripcion = descripcion;
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
}
