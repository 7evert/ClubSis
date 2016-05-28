package com.clubsis.model.privilegio;

import com.clubsis.model.club.Club;
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
    private String descripcion;

    @ManyToOne
    private Club club;

    @OneToMany(fetch= FetchType.EAGER, mappedBy= "rol")
    @JsonIgnore
    private Set<Permiso> permisos;

    protected Rol() {
    }

    public Rol(Integer id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
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
}
