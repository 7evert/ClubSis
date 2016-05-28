package com.clubsis.model.privilegio;

import com.clubsis.model.club.Club;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */
@Entity
public class Permiso {
    @Id
    @GeneratedValue
    private Integer id;
    private String descripcion;

    //no habra relacion con permiso y sede
    //there is not going to be a relationship between sede and permiso
    @ManyToOne
    private Club club;
    @ManyToOne
    private Rol rol;



    protected Permiso() {
    }

    public Permiso(Integer id, String descripcion) {
        this.id= id;
        this.descripcion = descripcion;
        this.rol = rol;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer idPermiso) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
