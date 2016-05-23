package com.clubsis.model.clase;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */

@Entity
public class RegistroClase {
    @Id
    @GeneratedValue
    private Integer id;
    private Date fechaRegistro;
    private EstadoRegistroClase estado;

    @ManyToOne
    private Clase clase;

    // TODO: ManyToMany con Persona, no hay relación con Socio

    protected RegistroClase() {
    }

    public RegistroClase(Date fechaRegistro, EstadoRegistroClase estado, Clase clase) {
        this.fechaRegistro = fechaRegistro;
        this.estado = estado;
        this.clase = clase;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public EstadoRegistroClase getEstado() {
        return estado;
    }

    public void setEstado(EstadoRegistroClase estado) {
        this.estado = estado;
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }
}
