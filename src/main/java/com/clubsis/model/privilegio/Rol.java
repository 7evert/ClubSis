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
public class Rol {
    @Id
    @GeneratedValue
    private Integer id;
    private String descripcion;

    @ManyToOne
    private Club club;

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
}
