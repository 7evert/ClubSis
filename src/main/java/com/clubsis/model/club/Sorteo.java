package com.clubsis.model.club;

import com.clubsis.model.bungalow.Bungalow;
import javax.persistence.*;
import java.util.Date;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */
@Entity
public class Sorteo {
    @Id
    @GeneratedValue
    private Integer id;
    private Date fechaInicio;
    private Date fechaFin;

    // TODO: agregar una relación muchos a muchos con Socio y que en la tabla cruzada haya un atributo que indique si un
    // socio ha ganado un sorteo o no (boolean)
    private Integer codigoGanador;
    
    @ManyToOne
    private Bungalow bungalow;

    @ManyToOne
    private Club club;

    protected Sorteo() {
    }

    public Sorteo(Date fechaInicio, Date fechaFin, Integer codigoGanador, Bungalow bungalow, Club club) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.codigoGanador = codigoGanador;
        this.bungalow = bungalow;
        this.club = club;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Integer getCodigoGanador() {
        return codigoGanador;
    }

    public void setCodigoGanador(Integer codigoGanador) {
        this.codigoGanador = codigoGanador;
    }

    public Bungalow getBungalow() {
        return bungalow;
    }

    public void setBungalow(Bungalow bungalow) {
        this.bungalow = bungalow;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }
}
