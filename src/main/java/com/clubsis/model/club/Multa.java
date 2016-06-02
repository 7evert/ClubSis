package com.clubsis.model.club;

import com.clubsis.model.pago.Pago;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Blitz on 01/06/2016.
 */
@Entity
public class Multa {
    @Id
    @GeneratedValue
    private Integer id;
    private String nombre;
    private Double costo;
    private String descripcion;
    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "multa")
    private Set<Pago> pagos =new HashSet<Pago>();


    protected Multa() {
    }

    public Multa(String nombre, Double costo, String descripcion, Set<Pago> pagos) {
        this.nombre = nombre;
        this.costo = costo;
        this.descripcion = descripcion;
        this.pagos = pagos;
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

    public Set<Pago> getPagos() {
        return pagos;
    }

    public void setPagos(Set<Pago> pagos) {
        this.pagos = pagos;
    }
}
