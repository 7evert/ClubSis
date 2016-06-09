package com.clubsis.model.privilegio;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */
@Entity
public class Permiso {
    @Id
    @GeneratedValue
    private Integer id;
    private String nombre;
    private String descripcion;

    @ManyToMany(mappedBy = "permisos")
    @JsonIgnore
    private Set<Rol> roles;


    protected Permiso() {
    }

    public Permiso(String nombre, String descripcion, Set<Rol> roles) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.roles = roles;
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

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }
}
