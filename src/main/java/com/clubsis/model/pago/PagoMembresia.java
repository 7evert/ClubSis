package com.clubsis.model.pago;

import com.clubsis.model.persona.Socio;

import javax.persistence.Entity;
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
    private Date fechaVencimiento;
    private Double montoPago;
    private EstadoPagoMembresia estado;
    private Date fechaPago;
    private Date fechaAnulacion;

    @ManyToOne
    private Socio socio;

    protected PagoMembresia() {
    }

    public PagoMembresia(Integer id, Date fechaVencimiento, Double montoPago, EstadoPagoMembresia estado, Date fechaPago, Date fechaAnulacion, Socio socio) {
        this.id = id;
        this.fechaVencimiento = fechaVencimiento;
        this.montoPago = montoPago;
        this.estado = estado;
        this.fechaPago = fechaPago;
        this.fechaAnulacion = fechaAnulacion;
        this.socio = socio;
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

    public EstadoPagoMembresia getEstado() {
        return estado;
    }

    public void setEstado(EstadoPagoMembresia estado) {
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
