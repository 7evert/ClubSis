package com.clubsis.model.sede;

import java.util.Date;
import javax.persistence.*;

import com.clubsis.model.persona.Empresa;
import com.clubsis.model.persona.Persona;
import com.clubsis.model.persona.Socio;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */
@Entity
public class ReservaInstalacion {
    @Id
    @GeneratedValue
    private Integer id;
    private Date fechaReserva;
    private EstadoReservaInstalacion estado;

    @ManyToOne
    private Instalacion instalacion;

    @ManyToOne
    private Empresa empresa;

    @ManyToOne
    private Socio socio;

    protected ReservaInstalacion() {
    }

    public ReservaInstalacion(Date fechaReserva, EstadoReservaInstalacion estado, Instalacion instalacion, Empresa empresa, Socio socio) {
        this.fechaReserva = fechaReserva;
        this.estado = estado;
        this.instalacion = instalacion;
        this.empresa = empresa;
        this.socio = socio;
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

    public EstadoReservaInstalacion getEstado() {
        return estado;
    }

    public void setEstado(EstadoReservaInstalacion estado) {
        this.estado = estado;
    }

    public Instalacion getInstalacion() {
        return instalacion;
    }

    public void setInstalacion(Instalacion instalacion) {
        this.instalacion = instalacion;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }
}
