package com.clubsis.model.evento;

import com.clubsis.model.persona.Persona;

import javax.persistence.*;

/**
 * Created by Juan Tenorio on 31/5/2016.
 */
@Entity
public class PersonaEvento {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;

    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Persona persona;

    protected PersonaEvento(){

    }

    public PersonaEvento(Evento evento, Persona persona) {
        this.evento = evento;
        this.persona = persona;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}
