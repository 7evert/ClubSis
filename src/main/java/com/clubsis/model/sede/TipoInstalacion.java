package com.clubsis.model.sede;

import com.clubsis.model.bungalow.EstadoBungalow;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by MAYRA on 02/06/2016.
 */
@Entity
public class TipoInstalacion {
    @Id
    @GeneratedValue
    private Integer id;
    private String nombre;
    private String caracteristicas;
    private EstadoInstalacion estado;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "tipo")
    @JsonIgnore
    private Set<Instalacion> instalaciones;

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

    public Set<Instalacion> getInstalaciones() {
        return instalaciones;
    }

    public void setInstalaciones(Set<Instalacion> instalaciones) {
        this.instalaciones = instalaciones;
    }

    public EstadoInstalacion getEstado() {
        return estado;
    }

    public void setEstado(EstadoInstalacion estado) {
        this.estado = estado;
    }
}
