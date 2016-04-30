package com.clubsis.model.bungalow;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */
public class TipoBungalow {
    private Integer idTipoBungalow;
    private String descripcion;
    private String caracteristicas;

    public Integer getIdTipoBungalow() {
        return idTipoBungalow;
    }

    public void setIdTipoBungalow(Integer idTipoBungalow) {
        this.idTipoBungalow = idTipoBungalow;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }
}
