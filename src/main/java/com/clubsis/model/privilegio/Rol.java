package com.clubsis.model.privilegio;

import com.clubsis.model.club.Club;
import com.clubsis.model.club.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */
@Entity
public class Rol {
    @Id
    @GeneratedValue
    private Integer id;
    private String nombre;
    private String descripcion;
    private Boolean esActivo;

    @ManyToOne
    private Club club;

    @OneToMany(fetch = FetchType.EAGER, mappedBy ="rol")
    private Set<Usuario> usuarios; // no se que nombre ponerle

    @OneToMany(fetch= FetchType.EAGER, mappedBy= "rol")
    @JsonIgnore
    private Set<Permiso> permisos;

    protected Rol() {
    }

    public Rol(Integer id,String nombre,Boolean esActivo, String descripcion,Set<Permiso> permisos) {
        this.id = id;
        this.nombre=nombre;
        this.descripcion = descripcion;
        this.esActivo=esActivo;
        this.permisos=permisos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<Permiso> getPermisos() {
        return permisos;
    }

    public void setPermisos(Set<Permiso> permisos) {
        this.permisos = permisos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getEsActivo() {
        return esActivo;
    }

    public void setEsActivo(Boolean esActivo) {
        this.esActivo = esActivo;
    }
}
