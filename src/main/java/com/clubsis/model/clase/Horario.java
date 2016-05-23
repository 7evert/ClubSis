package com.clubsis.model.clase;

import com.clubsis.model.sede.Instalacion;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */

@Entity
public class Horario {
    @Id
    @GeneratedValue
    private Integer id;
    private Date dia;
    private Date horaInicio;
    private Date horaFin;
    private EstadoHorario estadoHorario;

    @ManyToOne
    private Clase clase;

    @ManyToOne
    private Instalacion instalacion;

    protected Horario() {
    }

    public Horario(Date dia, Date horaInicio, Date horaFin, EstadoHorario estadoHorario, Clase clase, Instalacion instalacion) {
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.estadoHorario = estadoHorario;
        this.clase = clase;
        this.instalacion = instalacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
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

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    public Instalacion getInstalacion() {
        return instalacion;
    }

    public void setInstalacion(Instalacion instalacion) {
        this.instalacion = instalacion;
    }
}
