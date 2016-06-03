package com.clubsis.model.bungalow;

import com.clubsis.model.persona.Socio;

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
    private EstadoReservaBungalow estado;

    @ManyToMany
    private Set<ServicioBungalow> serviciosBungalows; // por ahora no hay

    // En este caso, la relación en el UML es 0..* a 1, este bungalow siempre debe existir, no puede ser nulo
    @ManyToOne
    private Bungalow bungalow;

    @ManyToOne
    private Socio socio;

    protected ReservaBungalow() {
    }

    public ReservaBungalow(Date fechaReserva, Date fechaFinal, EstadoReservaBungalow estado, Set<ServicioBungalow> serviciosBungalows, Bungalow bungalow) {
        this.fechaReserva = fechaReserva;
        this.fechaFinal = fechaFinal;
        this.estado = estado;
        this.serviciosBungalows = serviciosBungalows;
        this.bungalow = bungalow;
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

    public EstadoReservaBungalow getEstado() {
        return estado;
    }

    public void setEstado(EstadoReservaBungalow estado) {
        this.estado = estado;
    }
}
