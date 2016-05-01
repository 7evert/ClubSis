package com.clubsis.model.bungalow;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */
public class ServicioBungalow {
    private Integer idServicioBungalow;
    private String descripcion;
    private Double precio;

    protected ServicioBungalow(){
    }

    public ServicioBungalow(Integer idServicioBungalow, String descripcion, Double precio) {
        this.idServicioBungalow = idServicioBungalow;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public Integer getIdServicioBungalow() {
        return idServicioBungalow;
    }

    public void setIdServicioBungalow(Integer idServicioBungalow) {
        this.idServicioBungalow = idServicioBungalow;
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
