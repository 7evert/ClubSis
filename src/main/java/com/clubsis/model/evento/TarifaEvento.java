package com.clubsis.model.evento;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */
public class TarifaEvento {
    private Integer idTarifa;
    private String descripcion;
    private Double precio;

    public Integer getIdTarifa() {
        return idTarifa;
    }

    public void setIdTarifa(Integer idTarifa) {
        this.idTarifa = idTarifa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
