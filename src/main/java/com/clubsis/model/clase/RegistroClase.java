package com.clubsis.model.clase;

import java.util.Date;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */
public class RegistroClase {
    private Integer idPersona;
    private Date fechaRegistro;
    private String estado;

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
