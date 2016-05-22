package com.clubsis.model.clase;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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

    protected Horario() {
    }

    public Horario(Date dia, Date horaInicio, Date horaFin, EstadoHorario estadoHorario) {
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.estadoHorario = estadoHorario;
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
}
