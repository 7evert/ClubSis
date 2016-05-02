package com.clubsis.model.bungalow;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */
@Entity
public class ReservaBungalow {
    @Id
    @GeneratedValue
    private Integer idReserva;
    private Date fechaReserva;

    @ManyToMany(fetch = FetchType.EAGER)
    //private ServicioBungalow servicioBungalow;
    private Set<ServicioBungalow> serviciosBungalows;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_bungalow")
    private Bungalow bungalow;

    public ReservaBungalow(Date fechaReserva, Set<ServicioBungalow> serviciosBungalows) {
        this.fechaReserva = fechaReserva;
        this.serviciosBungalows = serviciosBungalows;
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

    public Set<ServicioBungalow> getServiciosBungalows() {
        return serviciosBungalows;
    }

    public void setServiciosBungalows(Set<ServicioBungalow> serviciosBungalows) {
        this.serviciosBungalows = serviciosBungalows;
    }

    public Bungalow getBungalow() {
        return bungalow;
    }

    public void setBungalow(Bungalow bungalow) {
        this.bungalow = bungalow;
    }
}
