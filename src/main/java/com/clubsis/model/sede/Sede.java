package com.clubsis.model.sede;

/**
 * Created by Juan Tenorio on 12/4/2016.
 */
public class Sede {
    private Integer idSede;
    private String descripcion;
    private String direccion;

    protected Sede() {
    }

    public Sede(Integer idSede, String descripcion, String direccion) {
        this.idSede = idSede;
        this.descripcion = descripcion;
        this.direccion = direccion;
    }

    public Integer getIdSede() {
        return idSede;
    }

    public void setIdSede(Integer idSede) {
        this.idSede = idSede;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
