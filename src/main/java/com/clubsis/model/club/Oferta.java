package com.clubsis.model.club;

import java.util.Date;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */
public class Oferta {
    private Integer idOferta;
    private String nombreOferta;
    private String descripcion;
    private Double porcentajeDescueto;
    private String tipoPagoAplicable;
    private Date fechaInicio;
    private Date fechaFin;
    private String estado;

    public Integer getIdOferta() {
        return idOferta;
    }

    public void setIdOferta(Integer idOferta) {
        this.idOferta = idOferta;
    }

    public String getNombreOferta() {
        return nombreOferta;
    }

    public void setNombreOferta(String nombreOferta) {
        this.nombreOferta = nombreOferta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPorcentajeDescueto() {
        return porcentajeDescueto;
    }

    public void setPorcentajeDescueto(Double porcentajeDescueto) {
        this.porcentajeDescueto = porcentajeDescueto;
    }

    public String getTipoPagoAplicable() {
        return tipoPagoAplicable;
    }

    public void setTipoPagoAplicable(String tipoPagoAplicable) {
        this.tipoPagoAplicable = tipoPagoAplicable;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
