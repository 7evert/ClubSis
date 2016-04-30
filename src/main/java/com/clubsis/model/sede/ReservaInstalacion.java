package com.clubsis.model.sede;

import java.util.Date;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */
public class ReservaInstalacion {
    private Integer idReserva;
    private Date fechaReserva;
    private String estado;

    public Integer getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
