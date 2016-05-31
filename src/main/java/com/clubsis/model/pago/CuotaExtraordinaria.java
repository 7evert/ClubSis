package com.clubsis.model.pago;

import com.clubsis.model.persona.Socio;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import com.clubsis.model.club.Club;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Sebastian on 23-May-16.
 */

@Entity
public class CuotaExtraordinaria {
    @Id
    @GeneratedValue
    private Integer id;
    private String nombre;
    private String descripcion;
    private Double monto;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date fechaInicio;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date fechaFin;
    private EstadoCuotaExtraordinaria estadoCuotaExtraordinaria; // no habrá isActivo

    @ManyToOne(fetch = FetchType.EAGER)
    private Socio socio;

    @ManyToOne
    private Club club;

    protected CuotaExtraordinaria() {
    }

    public CuotaExtraordinaria(String nombre, String descripcion, Double monto, Date fechaInicio, Date fechaFin, EstadoCuotaExtraordinaria estadoCuotaExtraordinaria, Socio socio, Club club) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.monto = monto;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estadoCuotaExtraordinaria = estadoCuotaExtraordinaria;
        this.socio = socio;
        this.club = club;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public EstadoCuotaExtraordinaria getEstadoCuotaExtraordinaria() {
        return estadoCuotaExtraordinaria;
    }

    public void setEstadoCuotaExtraordinaria(EstadoCuotaExtraordinaria estadoCuotaExtraordinaria) {
        this.estadoCuotaExtraordinaria = estadoCuotaExtraordinaria;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }
}
