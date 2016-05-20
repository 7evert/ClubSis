package com.clubsis.model.privilegio;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */
public class Permiso {
    private Integer idPermiso;
    private String descripcion;

    protected Permiso() {
    }

    public Permiso(Integer idPermiso, String descripcion) {
        this.idPermiso = idPermiso;
        this.descripcion = descripcion;
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
}
