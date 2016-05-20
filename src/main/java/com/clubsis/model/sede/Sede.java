package com.clubsis.model.sede;

import com.clubsis.model.bungalow.Bungalow;
import com.clubsis.model.evento.Evento;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Juan Tenorio on 12/4/2016.
 */

@Entity
public class Sede {

    @Id
    @GeneratedValue
    private Integer id;
    private String nombre;
    private String direccion;

    @OneToMany(mappedBy = "sede")
    @JsonIgnore
    private Set<Bungalow> bungalows;

    @OneToMany(mappedBy ="sede")
    private Set<Evento> eventos = new HashSet<>();

    protected Sede() {
    }

    public Sede(String nombre, String direccion, Set<Bungalow> bungalows) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.bungalows = bungalows;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Set<Bungalow> getBungalows() {
        return bungalows;
    }

    public void setBungalows(Set<Bungalow> bungalows) {
        this.bungalows = bungalows;
    }
}
