package com.clubsis.model.bungalow;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */
@Entity
public class ReservaBungalow {
    @Id
    @GeneratedValue
    private Integer idReserva;
    private Date fechaReserva;

    //@ManyToMany(fetch = FetchType.EAGER)
    //@JoinColumn(name="servicioBungalow")
    private ServicioBungalow servicioBungalow;

    public ReservaBungalow(Integer idReserva, Date fechaReserva) {
        this.idReserva = idReserva;
        this.fechaReserva = fechaReserva;
    }

    protected ReservaBungalow() {
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
}
