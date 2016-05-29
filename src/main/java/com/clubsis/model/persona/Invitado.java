package com.clubsis.model.persona;

import com.clubsis.model.evento.Evento;
import com.clubsis.model.evento.InvitadoEvento;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */
@Entity
public class Invitado {
    @Id
    @GeneratedValue
    private Integer id;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String tipoDocumento;
    private Integer numeroDocumento;
    private String nombres;
    private Boolean ingresoInvitado;



    @ManyToOne(fetch = FetchType.EAGER)
    private Socio socio;


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "invitado")
    private Set<InvitadoEvento> invitadoEventos= new HashSet<InvitadoEvento>(0);

    protected Invitado() {
    }

    public Invitado(String apellidoPaterno, String apellidoMaterno, String tipoDocumento, Integer numeroDocumento, String nombres, Boolean ingresoInvitado, Socio socio, Set<InvitadoEvento> invitadoEventos) {
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.nombres = nombres;
        this.ingresoInvitado = ingresoInvitado;
        this.socio = socio;
        this.invitadoEventos = invitadoEventos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Integer getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(Integer numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public Boolean getIngresoInvitado() {
        return ingresoInvitado;
    }

    public void setIngresoInvitado(Boolean ingresoInvitado) {
        this.ingresoInvitado = ingresoInvitado;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public Set<InvitadoEvento> getInvitadoEventos() {
        return invitadoEventos;
    }

    public void setInvitadoEventos(Set<InvitadoEvento> invitadoEventos) {
        this.invitadoEventos = invitadoEventos;
    }
}
