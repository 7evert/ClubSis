package com.clubsis.model.pago;

import java.util.Date;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */
public class Cuota {
    private Integer idCuota;
    private String estado;
    private Date fechaVencimiento;
    private Integer numero;
    private Date fechaPago;
    private String tipo;

    public Integer getIdCuota() {
        return idCuota;
    }

    public void setIdCuota(Integer idCuota) {
        this.idCuota = idCuota;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
