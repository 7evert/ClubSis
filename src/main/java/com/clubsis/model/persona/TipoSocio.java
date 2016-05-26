package com.clubsis.model.persona;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Sebastian on 23-May-16.
 */

@Entity
public class TipoSocio {
    @Id
    @GeneratedValue
    private Integer id;
    private String nombre;
    private String descripcion;
    private Double costoMembresia;
    private Integer numerosInvitadosGratuitos;
    private Double costoInicial;
    private Double ingresoMinimo;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "tipo")
    @JsonIgnore
    private Set<Socio> socios;

    protected TipoSocio() {
    }

    public TipoSocio(String nombre, String descripcion, Double costoMembresia, Integer numerosInvitadosGratuitos, Double costoInicial, Double ingresoMinimo, Set<Socio> socios) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costoMembresia = costoMembresia;
        this.numerosInvitadosGratuitos = numerosInvitadosGratuitos;
        this.costoInicial = costoInicial;
        this.ingresoMinimo = ingresoMinimo;
        this.socios = socios;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
