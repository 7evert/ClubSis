package com.clubsis.model.clase;

import com.clubsis.model.persona.Persona;
import com.clubsis.model.persona.Socio;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */

@Entity
public class RegistroClase {
    @Id
    @GeneratedValue
    private Integer id;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date fechaRegistro;
    private EstadoRegistroClase estado;

    @ManyToOne
    private Clase clase;

    @ManyToOne
    private Persona persona;

    @ManyToOne
    private Socio socio;

    protected RegistroClase() {
    }

    public RegistroClase(Date fechaRegistro, EstadoRegistroClase estado, Clase clase, Persona persona, Socio socio) {

        this.fechaRegistro = fechaRegistro;
        this.estado = estado;
        this.clase = clase;
        this.persona = persona;
        this.socio = socio;
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

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }
}
