package com.clubsis.model.clase;

import com.clubsis.model.persona.Persona;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
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
    private String estado;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Persona> personas = new HashSet<Persona>();

    protected RegistroClase() {
    }

    public RegistroClase(Date fechaRegistro, String estado, Set<Persona> personas) {
        this.fechaRegistro = fechaRegistro;
        this.estado = estado;
        this.personas = personas;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Set<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(Set<Persona> personas) {
        this.personas = personas;
    }

}
