package com.clubsis.model.clase;

import com.clubsis.model.pago.Pago;
import com.clubsis.model.persona.Persona;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */
@Entity
public class RegistroClase {
    @Id
    @GeneratedValue
    private Integer id;
    private Date fechaRegistro;
    private EstadoRegistroClase estado;

    @ManyToOne
    private Clase clase;

    // Observación: no hay relación con Socio


    @ManyToOne(fetch = FetchType.EAGER)
    private Persona persona ;

    @OneToOne(mappedBy = "registroClase")
    @JsonIgnore
    private Pago pago;

    protected RegistroClase() {
    }

    public RegistroClase(Date fechaRegistro, EstadoRegistroClase estado, Clase clase, Persona persona,Pago pago) {
        this.fechaRegistro = fechaRegistro;
        this.estado = estado;
        this.clase = clase;
        this.persona = persona;
        this.setPago(pago);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public EstadoRegistroClase getEstado() {
        return estado;
    }

    public void setEstado(EstadoRegistroClase estado) {
        this.estado = estado;
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }
}
