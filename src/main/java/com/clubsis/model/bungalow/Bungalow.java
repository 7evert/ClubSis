package com.clubsis.model.bungalow;

import javax.persistence.*;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */
@Entity
public class Bungalow {

    @Id
    @GeneratedValue
    private Integer idBungalow;

    private Integer capacidad;

    private Integer estado;

    private Double precio;

    private String caracteristicas;

    //@ManyToOne(fetch = FetchType.EAGER)
    //@JoinColumn(name="tipoBungalow")
    private TipoBungalow tipoBungalow;

    protected Bungalow() {
    }

    public Bungalow(String caracteristicas, Double precio, Integer capacidad, Integer estado, Integer idBungalow) {
        this.caracteristicas = caracteristicas;
        this.precio = precio;
        this.capacidad = capacidad;
        this.estado = estado;
        this.idBungalow = idBungalow;
    }

    public Integer getIdBungalow() {
        return idBungalow;
    }

    public void setIdBungalow(Integer idBungalow) {
        this.idBungalow = idBungalow;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public TipoBungalow getTipoBungalow() {
        return tipoBungalow;
    }

    public void setTipoBungalow(TipoBungalow tipoBungalow) {
        this.tipoBungalow = tipoBungalow;
    }
}
