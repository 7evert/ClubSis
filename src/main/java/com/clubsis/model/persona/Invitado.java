package com.clubsis.model.persona;

import java.util.Date;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */
public class Invitado {
    private Integer idInvitado;
    private Date fechaVisita;
    private Boolean esExoneradoPago;

    public Integer getIdInvitado() {
        return idInvitado;
    }

    public void setIdInvitado(Integer idInvitado) {
        this.idInvitado = idInvitado;
    }

    public Date getFechaVisita() {
        return fechaVisita;
    }

    public void setFechaVisita(Date fechaVisita) {
        this.fechaVisita = fechaVisita;
    }

    public Boolean getEsExoneradoPago() {
        return esExoneradoPago;
    }

    public void setEsExoneradoPago(Boolean esExoneradoPago) {
        this.esExoneradoPago = esExoneradoPago;
    }
}
