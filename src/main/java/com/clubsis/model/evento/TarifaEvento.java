package com.clubsis.model.evento;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */
@Entity
public class TarifaEvento {

    @Id
    @GeneratedValue
    private Integer idTarifa;
    private String descripcion;
    private Double precio;
    private String nombre;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy ="tarifaEventos")
    private Set<Evento> eventos;

    protected TarifaEvento() {
    }

    public TarifaEvento(Integer idTarifa, String descripcion, Double precio) {
        this.idTarifa = idTarifa;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public Integer getIdTarifa() {
        return idTarifa;
    }

    public void setIdTarifa(Integer idTarifa) {
        this.idTarifa = idTarifa;
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

    public void setEvento( Evento evento){
        eventos.add(evento);
    }
}
