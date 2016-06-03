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
    private String motivoSuspension;

    @ManyToOne
    private Socio socio;

    protected Suspension() {
    }

    public Suspension(EstadoSuspension estado, Date fechaSolicitud, Date fechaRespuesta, Date fechaAnulacion, String motivoSuspension, Socio socio) {
        this.estado = estado;
        this.fechaSolicitud = fechaSolicitud;
        this.fechaRespuesta = fechaRespuesta;
        this.fechaAnulacion = fechaAnulacion;
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
}
