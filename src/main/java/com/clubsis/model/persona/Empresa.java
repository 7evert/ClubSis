package com.clubsis.model.persona;

import com.clubsis.model.evento.Evento;
import com.clubsis.model.sede.ReservaInstalacion;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */
@Entity
public class Empresa {
    @Id
    @GeneratedValue
    private Integer id;
    private String razonSocial;
    private String ruc;
    private String representante;
    private String telefono;
    private String celularContacto;
    private String correoElectronico;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy ="empresas")
    private Set<Evento> eventos;

    @OneToMany(fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<ReservaInstalacion> reservasInstalacion;

    protected Empresa() {
    }

    public Empresa(String razonSocial, String ruc, String representante, String telefono, String correoElectronico, String celularContacto) {
        this.razonSocial = razonSocial;
        this.ruc = ruc;
        this.representante = representante;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.celularContacto = celularContacto;
    }



    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRepresentante() {
        return representante;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelularContacto() {
        return celularContacto;
    }

    public void setCelularContacto(String celularContacto) {
        this.celularContacto = celularContacto;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(Set<Evento> eventos) {
        this.eventos = eventos;
    }

    public Set<ReservaInstalacion> getReservasInstalacion() {
        return reservasInstalacion;
    }

    public void setReservasInstalacion(Set<ReservaInstalacion> reservasInstalacion) {
        this.reservasInstalacion = reservasInstalacion;
    }
}
