package com.clubsis.model.bungalow;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */

@Entity
public class TipoBungalow {
    @Id
    @GeneratedValue
    @Column(name = "id_tipo_bungalow")
    private Integer idTipoBungalow;
    private String descripcion;
    private String caracteristicas;

    protected TipoBungalow(){
    }

    public TipoBungalow(String descripcion, String caracteristicas) {
        this.descripcion = descripcion;
        this.caracteristicas = caracteristicas;
    }

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
