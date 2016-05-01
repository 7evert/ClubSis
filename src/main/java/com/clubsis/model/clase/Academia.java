package com.clubsis.model.clase;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */
public class Academia {
    private Integer idAcademia;
    private String descripcion;

    public Academia(Integer idAcademia, String descripcion) {
        this.idAcademia = idAcademia;
        this.descripcion = descripcion;
    }

    protected Academia() {
    }

    public Integer getIdAcademia() {
        return idAcademia;
    }

    public void setIdAcademia(Integer idAcademia) {
        this.idAcademia = idAcademia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
