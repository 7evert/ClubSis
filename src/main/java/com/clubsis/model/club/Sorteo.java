package com.clubsis.model.club;

import com.clubsis.model.persona.Socio;

import java.util.Date;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */
public class Sorteo {
    private Integer idSocio;
    private Date fechaInicio;
    private Date fechaFin;
    private Socio ganador;

    public Integer getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(Integer idSocio) {
        this.idSocio = idSocio;
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

    public Socio getGanador() {
        return ganador;
    }

    public void setGanador(Socio ganador) {
        this.ganador = ganador;
    }
}
