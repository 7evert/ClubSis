package com.clubsis.model.persona;

<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Blitz on 25/05/2016.
 */
=======
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

/**
 * Created by Sebastian on 23-May-16.
 */

>>>>>>> master
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

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "tipo")
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

    public Integer getNumeroInvitadosGratuitos() {
        return numeroInvitadosGratuitos;
    }

    public void setNumeroInvitadosGratuitos(Integer numeroInvitadosGratuitos) {
        this.numeroInvitadosGratuitos = numeroInvitadosGratuitos;
    }

    public Double getCostoInicial() {
        return costoInicial;
    }

    public void setCostoInicial(Double costoInicial) {
        this.costoInicial = costoInicial;
    }

    public Set<Socio> getSocios() {
        return socios;
    }

    public void setSocios(Set<Socio> socios) {
        this.socios = socios;
    }
}
