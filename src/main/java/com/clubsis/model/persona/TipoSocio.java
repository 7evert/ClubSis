package com.clubsis.model.persona;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
    private Integer numeroInvitadosGratuitos;
    private Double costoInicial; // en el diagrama está como Integer (mal)

    @OneToMany(mappedBy = "tipo")
    private Set<Socio> socios;

    protected TipoSocio() {}

    public TipoSocio(String nombre, String descripcion, Double costoMembresia, Integer numeroInvitadosGratuitos, Double costoInicial, Set<Socio> socios) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costoMembresia = costoMembresia;
        this.numeroInvitadosGratuitos = numeroInvitadosGratuitos;
        this.costoInicial = costoInicial;
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
