package com.clubsis.model.clase;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */

@Entity
public class Academia {
    @Id
    @GeneratedValue
    private Integer id;
    private String nombre;
    private String descripcion;
    private String urlFoto;
    private EstadoAcademia estadoAcademia;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "academias")
    @JsonIgnore
    private Set<Ciclo> ciclos = new HashSet<>();

    protected Academia() {
    }

    public Academia(String nombre, String descripcion, String urlFoto, EstadoAcademia estadoAcademia, Set<Ciclo> ciclos) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.urlFoto = urlFoto;
        this.estadoAcademia = estadoAcademia;
        this.ciclos = ciclos;
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

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public EstadoAcademia getEstadoAcademia() {
        return estadoAcademia;
    }

    public void setEstadoAcademia(EstadoAcademia estadoAcademia) {
        this.estadoAcademia = estadoAcademia;
    }

    public Set<Ciclo> getCiclos() {
        return ciclos;
    }

    public void setCiclos(Set<Ciclo> ciclos) {
        this.ciclos = ciclos;
    }
}
