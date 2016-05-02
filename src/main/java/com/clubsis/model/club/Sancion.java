package com.clubsis.model.club;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Rodrigo López on 30/04/2016.
 */
@Entity
public class Sancion {
    @Id
    @GeneratedValue
    private Integer idSancion;
    private String nombre;
    private Double costo;
    private String descripcion;
    private Date fechaPago;
    private String estado;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_club")
    Club club;

    protected Sancion() {
    }

    public Sancion(Integer idSancion, String nombre, Double costo, String descripcion, Date fechaPago, String estado) {
        this.idSancion = idSancion;
        this.nombre = nombre;
        this.costo = costo;
        this.descripcion = descripcion;
        this.fechaPago = fechaPago;
        this.estado = estado;
    }

    public Integer getIdSancion() {
        return idSancion;
    }

    public void setIdSancion(Integer idSancion) {
        this.idSancion = idSancion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
