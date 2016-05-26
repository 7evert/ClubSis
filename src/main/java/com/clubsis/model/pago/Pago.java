package com.clubsis.model.pago;

import com.clubsis.model.persona.Socio;

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
    private Integer cuotas;
    private Double mora;
    private String valoracion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_socio")
    private Socio socio;

    private TipoPago tipoPago;


    private Double montoTotal;
    private Date fechaAnulacion;

    @OneToMany(mappedBy = "pago")
    private Set<Cuota> cuotas;

    protected Pago() {
    }

    public Pago(Integer cuotas, String valoracion, Double mora, Socio socio, TipoPago tipoPago) {
        this.cuotas = cuotas;
        this.valoracion = valoracion;
        this.mora = mora;
        this.socio = socio;
        this.tipoPago = tipoPago;
    }


    public Integer getCuotas() {
        return cuotas;
    }

    public void setCuotas(Integer cuotas) {
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

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipoPago getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(TipoPago tipoPago) {
        this.tipoPago = tipoPago;
    }
}
