package com.clubsis.model.bungalow;

import com.clubsis.model.sede.Sede;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */
@Entity
public class Bungalow {

    @Id
    @GeneratedValue
    private Integer id;
    private Integer capacidad;
    private Integer estado; //libre, en mantenimiento, ocupado, no irá en el formulario
    private Double precio;
    private String caracteristicas;
    private String ubicacionEnSede;
    private Integer piso;

    @ManyToOne
    private TipoBungalow tipoBungalow; // necesario (composición)

    @ManyToOne
    private Sede sede; // necesaria (composición)

    protected Bungalow() {
    }

    public Bungalow(Integer capacidad, Integer estado, Double precio, String caracteristicas, String ubicacionEnSede, Integer piso, TipoBungalow tipoBungalow, Sede sede) {
        this.capacidad = capacidad;
        this.estado = estado;
        this.precio = precio;
        this.caracteristicas = caracteristicas;
        this.ubicacionEnSede = ubicacionEnSede;
        this.piso = piso;
        this.tipoBungalow = tipoBungalow;
        this.sede = sede;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getUbicacionEnSede() {
        return ubicacionEnSede;
    }

    public void setUbicacionEnSede(String ubicacionEnSede) {
        this.ubicacionEnSede = ubicacionEnSede;
    }

    public Integer getPiso() {
        return piso;
    }

    public void setPiso(Integer piso) {
        this.piso = piso;
    }

    public TipoBungalow getTipoBungalow() {
        return tipoBungalow;
    }

    public void setTipoBungalow(TipoBungalow tipoBungalow) {
        this.tipoBungalow = tipoBungalow;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }
}
