package com.clubsis.model.pago;

import com.clubsis.model.persona.Socio;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import com.clubsis.model.club.Club;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private Date fechaInicio;
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private Date fechaFin;
    private Boolean isActivo;
    private EstadoCuotaExtraordinaria estadoCuotaExtraordinaria; // no habrá isActivo

    @ManyToOne(fetch = FetchType.EAGER)
    private Socio socio;

    @ManyToOne
    private Club club;

    protected CuotaExtraordinaria() {
    }

    public CuotaExtraordinaria(String nombre, String descripcion, Date fechaInicio, Double monto, Date fechaFin, Socio socio, Boolean isActivo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.monto = monto;
        this.fechaFin = fechaFin;
        this.socio = socio;
        this.isActivo = isActivo;
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

}
