package com.clubsis.model.pago;

import java.util.Date;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */
public class PagoMembresia {
    private Integer idPagoMembresia;
    private Date fechaVencimiento;
    private Double montoPago;
    private String estado;
    private Date fechaPago;
    private Date fechaAnulacion;

    protected PagoMembresia() {
    }

    public PagoMembresia(Integer idPagoMembresia, Date fechaVencimiento, Double montoPago, String estado, Date fechaPago, Date fechaAnulacion) {
        this.idPagoMembresia = idPagoMembresia;
        this.fechaVencimiento = fechaVencimiento;
        this.montoPago = montoPago;
        this.estado = estado;
        this.fechaPago = fechaPago;
        this.fechaAnulacion = fechaAnulacion;
    }

    public Integer getIdPagoMembresia() {
        return idPagoMembresia;
    }

    public void setIdPagoMembresia(Integer idPagoMembresia) {
        this.idPagoMembresia = idPagoMembresia;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Double getMontoPago() {
        return montoPago;
    }

    public void setMontoPago(Double montoPago) {
        this.montoPago = montoPago;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Date getFechaAnulacion() {
        return fechaAnulacion;
    }

    public void setFechaAnulacion(Date fechaAnulacion) {
        this.fechaAnulacion = fechaAnulacion;
    }
}
