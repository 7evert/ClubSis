package com.clubsis.model.bungalow;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */

@Entity
public class TipoBungalow {

    @Id
    @GeneratedValue
    private Integer id;
    private String nombre;
    private String caracteristicas;
    private Integer capacidad;
    private EstadoTipoBungalow estado;

    @OneToMany(mappedBy = "tipoBungalow")
    @JsonIgnore
    private Set<Bungalow> bungalows;

    protected TipoBungalow(){
    }

    public TipoBungalow(String nombre, String caracteristicas, Set<Bungalow> bungalows, Integer capacidad) {
        this.nombre = nombre;
        this.caracteristicas = caracteristicas;
        this.bungalows = bungalows;
        this.capacidad = capacidad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public Set<Bungalow> getBungalows() {
        return bungalows;
    }

    public void setBungalows(Set<Bungalow> bungalows) {
        this.bungalows = bungalows;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public EstadoTipoBungalow getEstado() {
        return estado;
    }

    public void setEstado(EstadoTipoBungalow estado) {
        this.estado = estado;
    }
}
