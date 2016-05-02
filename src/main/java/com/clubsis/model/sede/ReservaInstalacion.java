package com.clubsis.model.sede;

import java.util.Date;
import javax.persistence.*;
import com.clubsis.model.persona.Persona;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */
@Entity
public class ReservaInstalacion {
    @Id
    @GeneratedValue
    private Integer idReserva;
    private Date fechaReserva;
    private String estado;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_instalacion")
    Instalacion instalacion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_persona")
    Persona persona;
    protected ReservaInstalacion() {
    }

    public ReservaInstalacion(String estado, Integer idReserva, Date fechaReserva) {
        this.estado = estado;
        this.idReserva = idReserva;
        this.fechaReserva = fechaReserva;
    }

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
