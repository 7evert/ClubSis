package com.clubsis.model.clase;

import com.clubsis.model.sede.Instalacion;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */

@Entity
public class Horario {
    @Id
    @GeneratedValue
    private Integer id;
    private String dia; // lunes, martes...
    private Date horaInicio;
    private Date horaFin;
    private EstadoHorario estadoHorario;

    @ManyToOne
    private Instalacion instalacion;

    @ManyToOne
    @JsonIgnore
    private Clase clase;

    protected Horario() {
    }

    public Horario(String dia, Date horaInicio, Date horaFin, EstadoHorario estadoHorario, Clase clase, Instalacion instalacion) {
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.estadoHorario = estadoHorario;
        this.instalacion = instalacion;
        this.clase = clase;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
    }

    public EstadoHorario getEstadoHorario() {
        return estadoHorario;
    }

    public void setEstadoHorario(EstadoHorario estadoHorario) {
        this.estadoHorario = estadoHorario;
    }

    public Instalacion getInstalacion() {
        return instalacion;
    }

    public void setInstalacion(Instalacion instalacion) {
        this.instalacion = instalacion;
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }
}
