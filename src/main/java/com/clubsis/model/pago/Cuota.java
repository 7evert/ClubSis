package com.clubsis.model.pago;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import javax.persistence.*;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */

@Entity
public class Cuota {
    @Id
    @GeneratedValue
    private Integer id;
    private EstadoCuota estado;
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private Date fechaVencimiento;
    private Integer numero;
    private Date fechaPago;
    private String tipo;
    private Double monto;
    @ManyToOne
    private Pago pago;

    protected Cuota() {
    }

    public Cuota(EstadoCuota estado, Date fechaVencimiento, Integer numero, Date fechaPago, Pago pago, Double monto, String tipo) {
        this.estado = estado;
        this.fechaVencimiento = fechaVencimiento;
        this.numero = numero;
        this.fechaPago = fechaPago;
        this.pago = pago;
        this.monto = monto;
        this.tipo = tipo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EstadoCuota getEstado() {
        return estado;
    }

    public void setEstado(EstadoCuota estado) {
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

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }
}
