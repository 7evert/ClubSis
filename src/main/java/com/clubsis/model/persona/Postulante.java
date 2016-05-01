package com.clubsis.model.persona;

import java.util.Date;
import java.util.List;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */
public class Postulante {
    private List<String> observaciones;
    private Date fechaPostulacion;

    protected Postulante() {
    }

    public Postulante(List<String> observaciones, Date fechaPostulacion) {
        this.observaciones = observaciones;
        this.fechaPostulacion = fechaPostulacion;
    }

    public List<String> getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(List<String> observaciones) {
        this.observaciones = observaciones;
    }

    public Date getFechaPostulacion() {
        return fechaPostulacion;
    }

    public void setFechaPostulacion(Date fechaPostulacion) {
        this.fechaPostulacion = fechaPostulacion;
    }
}
