package com.clubsis.model.persona;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Blitz on 25/05/2016.
 */
@Entity
public class TipoSocio {
    @Id
    @GeneratedValue
    private Integer id;
    private String nombreTipo;
    private String descripcion;
    private Double costoMembresia;
    private Integer numerosInvitadosGratuitos;
    private Double costoInicial;
    private Double ingresoMinimo;

    @OneToMany(fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Socio> socios;

    protected TipoSocio() {
    }

    public TipoSocio(String nombreTipo, Set<Socio> socios, String descripcion, Double costoMembresia, Double costoInicial, Integer numerosInvitadosGratuitos, Double ingresoMinimo) {
        this.nombreTipo = nombreTipo;
        this.socios = socios;
        this.descripcion = descripcion;
        this.costoMembresia = costoMembresia;
        this.costoInicial = costoInicial;
        this.numerosInvitadosGratuitos = numerosInvitadosGratuitos;
        this.ingresoMinimo = ingresoMinimo;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreTipo() {
        return nombreTipo;
    }

    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getCostoMembresia() {
        return costoMembresia;
    }

    public void setCostoMembresia(Double costoMembresia) {
        this.costoMembresia = costoMembresia;
    }

    public Integer getNumerosInvitadosGratuitos() {
        return numerosInvitadosGratuitos;
    }

    public void setNumerosInvitadosGratuitos(Integer numerosInvitadosGratuitos) {
        this.numerosInvitadosGratuitos = numerosInvitadosGratuitos;
    }

    public Double getCostoInicial() {
        return costoInicial;
    }

    public void setCostoInicial(Double costoInicial) {
        this.costoInicial = costoInicial;
    }

    public Double getIngresoMinimo() {
        return ingresoMinimo;
    }

    public void setIngresoMinimo(Double ingresoMinimo) {
        this.ingresoMinimo = ingresoMinimo;
    }

    public Set<Socio> getSocios() {
        return socios;
    }

    public void setSocios(Set<Socio> socios) {
        this.socios = socios;
    }
}
