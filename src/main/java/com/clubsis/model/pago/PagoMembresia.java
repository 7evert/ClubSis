package com.clubsis.model.pago;

import com.clubsis.model.persona.Socio;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */
@Entity
public class PagoMembresia {
    @Id
    @GeneratedValue
    private Integer id;
    private Date fechaVencimiento;
    private Double montoPago;
    private String estado;
    private Date fechaPago;
    private Date fechaAnulacion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_socio")
    private Socio socio;

    protected PagoMembresia() {
    }

    public PagoMembresia(Date fechaVencimiento, Double montoPago, String estado, Date fechaPago, Date fechaAnulacion, Socio socio) {
        this.fechaVencimiento = fechaVencimiento;
        this.montoPago = montoPago;
        this.estado = estado;
        this.fechaPago = fechaPago;
        this.fechaAnulacion = fechaAnulacion;
        this.socio = socio;
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

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }
}
