package com.clubsis.model.sede;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */
public class Instalacion {
    private Integer idInstalacion;
    private String descripcion;
    private String referencia;
    private Integer capacidad;
    private Double precioReserva;
    private Integer estado;

    public Integer getIdInstalacion() {
        return idInstalacion;
    }

    public void setIdInstalacion(Integer idInstalacion) {
        this.idInstalacion = idInstalacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public Double getPrecioReserva() {
        return precioReserva;
    }

    public void setPrecioReserva(Double precioReserva) {
        this.precioReserva = precioReserva;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }
}
