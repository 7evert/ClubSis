package com.clubsis.model.sede;

import com.clubsis.model.clase.Horario;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */

@Entity
public class Instalacion {
    @Id
    @GeneratedValue
    private Integer id;
    private String descripcion;
    private String referencia;
    private Integer capacidad;
    private Double precioReserva;
    private EstadoInstalacion estado;
    private String urlFoto;

    @OneToMany(mappedBy = "instalacion")
    private Set<Horario> horarios;

    @OneToMany(mappedBy = "instalacion")
    private Set<ReservaInstalacion> reservas;

    @ManyToOne
    private Sede sede;

    protected Instalacion() {
    }

    public Instalacion(String descripcion, String referencia, Integer capacidad, Double precioReserva, EstadoInstalacion estado, String urlFoto) {
        this.descripcion = descripcion;
        this.referencia = referencia;
        this.capacidad = capacidad;
        this.precioReserva = precioReserva;
        this.estado = estado;
        this.urlFoto = urlFoto;
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

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public Double getPrecioReserva() {
        return precioReserva;
    }

    public void setPrecioReserva(Double precioReserva) {
        this.precioReserva = precioReserva;
    }

    public EstadoInstalacion getEstado() {
        return estado;
    }

    public void setEstado(EstadoInstalacion estado) {
        this.estado = estado;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }
}
