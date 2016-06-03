package com.clubsis.model.evento;

import com.clubsis.model.persona.Invitado;

import javax.persistence.*;

/**
 * Created by Juan Tenorio on 29/5/2016.
 */
@Entity
public class InvitadoEvento {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;

    @ManyToOne
    @JoinColumn(name = "invitado_id")
    private Invitado invitado;

    private String tipo;
    protected InvitadoEvento(){

    }

    public InvitadoEvento(Evento evento, Invitado invitado, String tipo) {
        this.evento = evento;
        this.invitado = invitado;
        this.tipo = tipo;
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

    public Invitado getInvitado() {
        return invitado;
    }

    public void setInvitado(Invitado invitado) {
        this.invitado = invitado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
