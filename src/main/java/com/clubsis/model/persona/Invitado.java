package com.clubsis.model.persona;

import com.clubsis.model.evento.Evento;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
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
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private Date fechaVisita;
    private String tipoDocumento;
    private Integer numeroDocumento;
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private Date fechaSalida;
    private String nombres;
    private Boolean ingresoInvitado;


    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Socio socio;


    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Evento> eventos= new HashSet<Evento>(0);

    protected Invitado() {
    }

    public Invitado(String apellidoPaterno, Date fechaVisita, String apellidoMaterno, Integer numeroDocumento, String tipoDocumento, Date fechaSalida, Set<Evento> eventos, Socio socio, Boolean ingresoInvitado, String nombres) {
        this.apellidoPaterno = apellidoPaterno;
        this.fechaVisita = fechaVisita;
        this.apellidoMaterno = apellidoMaterno;
        this.numeroDocumento = numeroDocumento;
        this.tipoDocumento = tipoDocumento;
        this.fechaSalida = fechaSalida;
        this.eventos = eventos;
        this.socio = socio;
        this.ingresoInvitado = ingresoInvitado;
        this.nombres = nombres;
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

    public Date getFechaVisita() {
        return fechaVisita;
    }

    public void setFechaVisita(Date fechaVisita) {
        this.fechaVisita = fechaVisita;
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

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
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

    public Set<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(Set<Evento> eventos) {
        this.eventos = eventos;
    }
}
