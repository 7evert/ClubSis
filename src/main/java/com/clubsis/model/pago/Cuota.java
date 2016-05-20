package com.clubsis.model.pago;

import java.util.Date;
import javax.persistence.*;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */

@Entity
public class Cuota {
    @Id
    @GeneratedValue
    private Integer idCuota;
    private String estado;
    private Date fechaVencimiento;
    private Integer numero;
    private Date fechaPago;
    private String tipo;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_pago")
    private Pago pago;
    protected Cuota() {
    }

    public Cuota(Integer idCuota, Date fechaVencimiento, String estado, Integer numero, Date fechaPago, String tipo) {
        this.idCuota = idCuota;
        this.fechaVencimiento = fechaVencimiento;
        this.estado = estado;
        this.numero = numero;
        this.fechaPago = fechaPago;
        this.tipo = tipo;
    }

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

    public Pago getPago() { return pago; }

    public void setPago(Pago pago) { this.pago = pago; }
}
