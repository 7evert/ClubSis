package com.clubsis.model.clase;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */
public class RegistroClase {
    @Id
    @GeneratedValue
    private Integer id;
    private Date fechaRegistro;
    private EstadoRegistroClase estado;

    @ManyToOne
    private Clase clase;

    // TODO: ManyToMany con Persona, no hay relación con Socio

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Persona> personas = new HashSet<Persona>();

    protected RegistroClase() {
    }

    public RegistroClase(Integer idPersona, Date fechaRegistro, String estado) {
        this.idPersona = idPersona;
        this.fechaRegistro = fechaRegistro;
        this.estado = estado;
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

    public Set<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(Set<Persona> personas) {
        this.personas = personas;
    }


    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }
}
