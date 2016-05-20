package com.clubsis.model.persona;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by User on 19/05/2016.
 */
@Entity
public class Suspension {
    @Id
    @GeneratedValue
    @Column(name = "id_suspension")
    private Integer idSuspension;
    private EstadoSuspension estado;
    private Date fechaSolicitud;
    private Date fechaRespuesta;
    private Date fechaAnulacion;
    private String motivoSuspension;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_socio")
    private Socio socio;

    protected Suspension() {
    }


    public Suspension(EstadoSuspension estado, Date fechaSolicitud, String motivoSuspension, Date fechaAnulacion, Date fechaRespuesta) {
        this.setEstado(estado);
        this.setFechaSolicitud(fechaSolicitud);
        this.setMotivoSuspension(motivoSuspension);
        this.setFechaAnulacion(fechaAnulacion);
        this.setFechaRespuesta(fechaRespuesta);
    }

    public Integer getIdSuspension() {
        return idSuspension;
    }

    public void setIdSuspension(Integer idSuspension) {
        this.idSuspension = idSuspension;
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
