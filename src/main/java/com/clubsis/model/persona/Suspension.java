package com.clubsis.model.persona;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by User on 19/05/2016.
 */
@Entity
public class Suspension {
    @Id
    @GeneratedValue
    private Integer id;
    private EstadoSuspension estado;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date fechaSolicitud;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date fechaRespuesta;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date fechaAnulacion;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date fechaInicio;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date fechaFin;
    private String motivoSuspension;

    @ManyToOne
    private Socio socio;

    protected Suspension() {
    }

    public Suspension(EstadoSuspension estado, Date fechaAnulacion, Date fechaRespuesta, Date fechaSolicitud, Date fechaInicio, Date fechaFin, String motivoSuspension, Socio socio) {
        this.estado = estado;
        this.fechaAnulacion = fechaAnulacion;
        this.fechaRespuesta = fechaRespuesta;
        this.fechaSolicitud = fechaSolicitud;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.motivoSuspension = motivoSuspension;
        this.socio = socio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EstadoSuspension getEstado() {
        return estado;
    }

    public void setEstado(EstadoSuspension estado) {
        this.estado = estado;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public Date getFechaRespuesta() {
        return fechaRespuesta;
    }

    public void setFechaRespuesta(Date fechaRespuesta) {
        this.fechaRespuesta = fechaRespuesta;
    }

    public Date getFechaAnulacion() {
        return fechaAnulacion;
    }

    public void setFechaAnulacion(Date fechaAnulacion) {
        this.fechaAnulacion = fechaAnulacion;
    }

    public String getMotivoSuspension() {
        return motivoSuspension;
    }

    public void setMotivoSuspension(String motivoSuspension) {
        this.motivoSuspension = motivoSuspension;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }


    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
}
