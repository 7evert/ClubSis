package com.clubsis.model.evento;

import javax.persistence.*;

/**
 * Created by Juan Tenorio on 22/5/2016.
 */

@Entity
public class TarifaEvento {
    @Id
    @GeneratedValue
    private Integer id;

    private double precio;


    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "evento_id")
    private Evento eventos;



    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "tarifaevento_id")
    private Tarifa tarifaeventos;

    protected TarifaEvento() {
    }

    public TarifaEvento(double precio, Evento eventos, Tarifa tarifaeventos) {
        this.precio = precio;
        this.eventos = eventos;
        this.tarifaeventos = tarifaeventos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Evento getEventos() {
        return eventos;
    }

    public void setEventos(Evento eventos) {
        this.eventos = eventos;
    }

    public Tarifa getTarifaeventos() {
        return tarifaeventos;
    }

    public void setTarifaeventos(Tarifa tarifaeventos) {
        this.tarifaeventos = tarifaeventos;
    }
}

