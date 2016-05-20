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
    private Integer idSorteo;
    private Date fechaInicio;
    private Date fechaFin;
    private Integer ganador;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="id_bungalow")
    private Bungalow bungalow;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_club")
    private Club club;

    protected Sorteo() {
    }

    public Sorteo(Integer idSorteo, Date fechaInicio, Date fechaFin) {
        this.idSorteo= idSorteo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Integer getIdSorteo() {
        return idSorteo;
    }

    public void setIdSorteo(Integer idSorteo) {
        this.idSorteo = idSorteo;
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

    public Bungalow getBungalow() { return bungalow; }

    public void setBungalow(Bungalow bungalow) { this.bungalow = bungalow; }

    public Club getClub() { return club; }

    public void setClub(Club club) { this.club = club; }
}
