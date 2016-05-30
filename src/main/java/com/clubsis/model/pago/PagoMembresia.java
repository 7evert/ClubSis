package com.clubsis.model.pago;

import com.clubsis.model.persona.Socio;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */

@Entity
public class PagoMembresia {
    @Id
    @GeneratedValue
    private Integer id;
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private Date fechaVencimiento;
    private Double montoPago;
    private EstadoPago estado;
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private Date fechaPago;
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private Date fechaAnulacion;

    @ManyToOne
    private Socio socio;

    protected PagoMembresia() {
    }

    public PagoMembresia(Date fechaVencimiento, EstadoPago estado, Double montoPago, Date fechaPago, Socio socio, Date fechaAnulacion) {
        this.fechaVencimiento = fechaVencimiento;
        this.estado = estado;
        this.montoPago = montoPago;
        this.fechaPago = fechaPago;
        this.socio = socio;
        this.fechaAnulacion = fechaAnulacion;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public EstadoPago getEstado() {
        return estado;
    }

    public void setEstado(EstadoPago estado) {
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
