package com.clubsis.model.privilegio;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */

@Entity
public class Rol {
    @Id
    @GeneratedValue
    private Integer idRol;
    private String descripcion;

    @OneToMany(fetch= FetchType.EAGER, mappedBy= "rol")
    @JsonIgnore
    private Set<Permiso> permisos;

    protected Rol() {
    }

    public Rol(Integer idRol, String descripcion) {
        this.idRol = idRol;
        this.descripcion = descripcion;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
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
}
