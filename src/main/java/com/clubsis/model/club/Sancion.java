package com.clubsis.model.club;

import com.clubsis.model.persona.Socio;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by Blitz on 30/04/2016.
 */
@Entity
public class Sancion {
    @Id
    @GeneratedValue
    private Integer id;
    private String nombre;
    private Double costo;
    private String descripcion;
    private Date fechaPago;

    private EstadoSancion estado;

    @ManyToOne
    private Club club;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Socio> socios;

    protected Sancion() {
    }

    public Sancion(String nombre, Double costo, String descripcion, EstadoSancion estado, Date fechaPago, Club club, Set<Socio> socios) {
        this.nombre = nombre;
        this.costo = costo;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fechaPago = fechaPago;
        this.club = club;
        this.socios = socios;
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

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public EstadoSancion getEstado() {
        return estado;
    }

    public void setEstado(EstadoSancion estado) {
        this.estado = estado;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public Set<Socio> getSocios() {
        return socios;
    }

    public void setSocios(Set<Socio> socios) {
        this.socios = socios;
    }
}
