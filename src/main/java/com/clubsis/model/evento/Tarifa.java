package com.clubsis.model.evento;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */
@Entity
public class Tarifa {


    @Id
    @GeneratedValue
    private Integer id;
    private String descripcion;
    private String nombre;


    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER,mappedBy="tarifaeventos",cascade=CascadeType.ALL)
    private Set<TarifaEvento> tarifaxEventos = new HashSet<TarifaEvento>(0);

    protected Tarifa() {
    }

    public Tarifa(String descripcion, String nombre, Set<TarifaEvento> tarifaxEventos) {
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.tarifaxEventos = tarifaxEventos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<TarifaEvento> getTarifaxEventos() {
        return tarifaxEventos;
    }

    public void setTarifaxEventos(Set<TarifaEvento> tarifaxEventos) {
        this.tarifaxEventos = tarifaxEventos;
    }
}
