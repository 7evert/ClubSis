package com.clubsis.model.bungalow;

import java.util.Date;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */
public class ReservaBungalow {
    private Integer idReserva;
    private Date fechaReserva;

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
}
