package com.clubsis.model.evento;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */
@Entity
public class TarifaEvento {

    @Id

    @GeneratedValue
    private Integer id;
    private String descripcion;
    private Double precio;
    private String nombre;

    @JsonIgnore
    @ManyToMany(mappedBy ="tarifaEventos")
    private Set<Evento> eventos = new HashSet<>();

    protected TarifaEvento() {
    }

    public TarifaEvento(Double precio, String descripcion, String nombre, Set<Evento> eventos) {
        this.precio = precio;
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.eventos = eventos;
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

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(Set<Evento> eventos) {
        this.eventos = eventos;
    }
}
