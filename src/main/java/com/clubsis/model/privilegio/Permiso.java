package com.clubsis.model.privilegio;

import com.clubsis.repository.privilegios.RolRepository;

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
    private Integer idPermiso;
    private String descripcion;

    @ManyToOne
    private Rol rol;



    protected Permiso() {
    }

    public Permiso(Integer idPermiso, String descripcion, Rol rol) {
        this.idPermiso = idPermiso;
        this.descripcion = descripcion;
        this.rol = rol;

    }

    public Integer getIdPermiso() {
        return idPermiso;
    }

    public void setIdPermiso(Integer idPermiso) {
        this.idPermiso = idPermiso;
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
