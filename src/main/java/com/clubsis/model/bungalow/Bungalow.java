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



    // El cascade sirve para que se pueda pasar por JSON un objeto de tipo TipoBungalow
    // y que se cree también adicionalmente al Bungalow en la base de datos.
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_TipoBungalow")
    private TipoBungalow tipoBungalow; // necesario (composición)



    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_sede")
    private Sede sede; // necesaria (composición)
    private String ubicacionEnSede;
    private Integer piso;

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    public String getUbicacionEnSede() {
        return ubicacionEnSede;
    }

    public Bungalow(Integer capacidad, Integer estado, Double precio, String caracteristicas, TipoBungalow tipoBungalow, Sede sede, String ubicacionEnSede, Integer piso) {
        this.capacidad = capacidad;
        this.estado = estado;
        this.precio = precio;
        this.caracteristicas = caracteristicas;
        this.tipoBungalow = tipoBungalow;
        this.sede = sede;
        this.ubicacionEnSede = ubicacionEnSede;
        this.piso = piso;
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

    protected Bungalow() {
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

    public TipoBungalow getTipoBungalow() {
        return tipoBungalow;
    }

    public void setTipoBungalow(TipoBungalow tipoBungalow) {
        this.tipoBungalow = tipoBungalow;
    }
}
