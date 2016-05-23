package com.clubsis.model.pago;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */
@Entity
public class Pago {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer numeroCuotas;
    private Double mora;
    private Double montoTotal;
    private Date fechaAnulacion;

    @OneToMany(mappedBy = "pago")
    private Set<Cuota> cuotas;

    protected Pago() {
    }

    public Pago(Integer numeroCuotas, Double mora, Double montoTotal, Date fechaAnulacion, Set<Cuota> cuotas) {
        this.numeroCuotas = numeroCuotas;
        this.mora = mora;
        this.montoTotal = montoTotal;
        this.fechaAnulacion = fechaAnulacion;
        this.cuotas = cuotas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumeroCuotas() {
        return numeroCuotas;
    }

    public void setNumeroCuotas(Integer numeroCuotas) {
        this.numeroCuotas = numeroCuotas;
    }

    public Double getMora() {
        return mora;
    }

    public void setMora(Double mora) {
        this.mora = mora;
    }

    public Double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public Date getFechaAnulacion() {
        return fechaAnulacion;
    }

    public void setFechaAnulacion(Date fechaAnulacion) {
        this.fechaAnulacion = fechaAnulacion;
    }

    public Set<Cuota> getCuotas() {
        return cuotas;
    }

    public void setCuotas(Set<Cuota> cuotas) {
        this.cuotas = cuotas;
    }
}
