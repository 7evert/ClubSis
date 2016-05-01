package com.clubsis.model.persona;

import java.util.Date;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */
public class Socio {
    private Integer idSocio;
    private Date fechaInscripcion;
    private Integer estado;
    private Integer codigoCarnet;

    protected Socio() {
    }

    public Socio(Integer idSocio, Date fechaInscripcion, Integer estado, Integer codigoCarnet) {
        this.idSocio = idSocio;
        this.fechaInscripcion = fechaInscripcion;
        this.estado = estado;
        this.codigoCarnet = codigoCarnet;
    }

    public Integer getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(Integer idSocio) {
        this.idSocio = idSocio;
    }

    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(Date fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Integer getCodigoCarnet() {
        return codigoCarnet;
    }

    public void setCodigoCarnet(Integer codigoCarnet) {
        this.codigoCarnet = codigoCarnet;
    }
}
