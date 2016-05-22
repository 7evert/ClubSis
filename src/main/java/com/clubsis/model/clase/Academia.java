package com.clubsis.model.clase;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */

@Entity
public class Academia {
    @Id
    @GeneratedValue
    private Integer id;
    private String nombre;
    private String descripcion;
    private String urlFoto;

    private EstadoAcademia estadoAcademia;

    protected Academia() {
    }

    public Academia(String nombre, String descripcion, String urlFoto, EstadoAcademia estadoAcademia) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.urlFoto = urlFoto;
        this.estadoAcademia = estadoAcademia;
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

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public EstadoAcademia getEstadoAcademia() {
        return estadoAcademia;
    }

    public void setEstadoAcademia(EstadoAcademia estadoAcademia) {
        this.estadoAcademia = estadoAcademia;
    }
}
