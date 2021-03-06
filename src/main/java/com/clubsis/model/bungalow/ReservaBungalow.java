package com.clubsis.model.bungalow;

import com.clubsis.model.pago.Pago;
import com.clubsis.model.persona.Socio;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFormat;

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
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date fechaReserva;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date fechaFinal;
    private EstadoReservaBungalow estado;

    @ManyToMany
    private Set<ServicioBungalow> serviciosBungalows; // por ahora no hay

    // En este caso, la relación en el UML es 0..* a 1, este bungalow siempre debe existir, no puede ser nulo
    @ManyToOne
    private Bungalow bungalow;

    @ManyToOne
    private Socio socio;

    @OneToOne(mappedBy = "reservaBungalow")
    @JsonIgnore
    private Pago pago;

    protected ReservaBungalow() {
    }

    public ReservaBungalow(Date fechaReserva, Date fechaFinal, EstadoReservaBungalow estado, Set<ServicioBungalow> serviciosBungalows, Bungalow bungalow, Socio socio,Pago pago) {
        this.fechaReserva = fechaReserva;
        this.fechaFinal = fechaFinal;
        this.estado = estado;
        this.serviciosBungalows = serviciosBungalows;
        this.setBungalow(bungalow);
        this.socio = socio;
        this.setPago(pago);
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

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }
}
