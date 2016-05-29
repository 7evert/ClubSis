package com.clubsis.model.pago;

import com.clubsis.model.evento.Evento;
import com.clubsis.model.persona.Socio;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
    //TODO:Agregar fechaRegistro , fechaCancelacion , y estado
    private TipoPago tipoPago;

    private String valoracion;

    @ManyToOne(fetch = FetchType.EAGER)
    private Socio socio;

    @OneToMany(mappedBy = "pago")
    @JsonIgnore
    private Set<Cuota> cuotas;

    public Pago(Integer numeroCuotas, Double mora, Double montoTotal, Date fechaAnulacion, TipoPago tipoPago, String valoracion, Socio socio, Set<Cuota> cuotas) {
        this.numeroCuotas = numeroCuotas;
        this.mora = mora;
        this.montoTotal = montoTotal;
        this.fechaAnulacion = fechaAnulacion;
        this.tipoPago = tipoPago;
        this.valoracion = valoracion;
        this.socio = socio;
        this.cuotas = cuotas;
    }

//    @ManyToOne(fetch = FetchType.EAGER)
//    private Evento evento;

    protected Pago() {
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

    public TipoPago getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(TipoPago tipoPago) {
        this.tipoPago = tipoPago;
    }

    public String getValoracion() {
        return valoracion;
    }

    public void setValoracion(String valoracion) {
        this.valoracion = valoracion;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public Set<Cuota> getCuotas() {
        return cuotas;
    }

    public void setCuotas(Set<Cuota> cuotas) {
        this.cuotas = cuotas;
    }
}
