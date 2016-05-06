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
    private Date fechaFinal;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<ServicioBungalow> serviciosBungalows; // por ahora no hay

    @ManyToOne(fetch = FetchType.EAGER)
    private Bungalow bungalow;

    public ReservaBungalow(Date fechaReserva, Date fechaFinal, Set<ServicioBungalow> serviciosBungalows, Bungalow bungalow) {
        this.fechaReserva = fechaReserva;
        this.fechaFinal = fechaFinal;
        this.serviciosBungalows = serviciosBungalows;
        this.bungalow = bungalow;
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

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }
}
