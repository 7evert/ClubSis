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
    private Integer id;
    private Date fechaReserva;
    private Date fechaFinal;

    @ManyToMany
    private Set<ServicioBungalow> serviciosBungalows; // por ahora no hay

    @OneToOne
    private Bungalow bungalow;

    public ReservaBungalow(Date fechaReserva, Date fechaFinal, Set<ServicioBungalow> serviciosBungalows, Bungalow bungalow) {
        this.fechaReserva = fechaReserva;
        this.fechaFinal = fechaFinal;
        this.serviciosBungalows = serviciosBungalows;
        this.bungalow = bungalow;
    }

    protected ReservaBungalow() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
