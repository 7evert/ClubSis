package com.clubsis.model.pago;

import com.clubsis.model.persona.Socio;

import javax.persistence.*;

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
        this.cuotas = cuotas;
    }

    public Double getMora() {
        return mora;
    }

    public void setMora(Double mora) {
        this.mora = mora;
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
