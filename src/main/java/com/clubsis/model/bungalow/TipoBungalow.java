package com.clubsis.model.bungalow;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */

@Entity
public class TipoBungalow {
    @Id
    @GeneratedValue
    @Column(name = "id_TipoBungalow")
    private Integer id;
    private String descripcion;
    private String caracteristicas;




//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoBungalow", orphanRemoval = true)
//    private Set<Bungalow> bungalows;


    protected TipoBungalow(){
    }

    // No olvidar poner TODOS los atributos en el constructor y con sus getters y setters


    public TipoBungalow(String descripcion, String caracteristicas) {
        this.descripcion = descripcion;
        this.caracteristicas = caracteristicas;
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

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }
}
