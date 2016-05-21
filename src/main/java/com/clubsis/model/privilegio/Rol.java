package com.clubsis.model.privilegio;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */
public class Rol {
    private Integer idRol;
    private String descripcion;

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
}