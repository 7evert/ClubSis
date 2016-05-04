package com.clubsis.model.bungalow;

import javax.persistence.*;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */
@Entity
public class Bungalow {

    @Id
    @GeneratedValue
    @Column(name="id_bungalow")
    private Integer idBungalow;

    private Integer capacidad;

    private Integer estado; //libre, en mantenimiento, ocupado, no irá en el formulario

    private Double precio;

    private String caracteristicas;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_tipo_bungalow")
    private TipoBungalow tipoBungalow;

    // TODO: poner atributos Sede y nombre (string) y ubicación (dirección) dentro de la sede (string), nivel (piso)


    protected Bungalow() {
    }

    public Bungalow(Integer capacidad, Integer estado, Double precio, String caracteristicas, TipoBungalow tipoBungalow) {
        this.capacidad = capacidad;
        this.estado = estado;
        this.precio = precio;
        this.caracteristicas = caracteristicas;
        this.tipoBungalow = tipoBungalow;
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
