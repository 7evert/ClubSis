package com.clubsis.model.pago;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */
public class Pago {
    private Integer idPago;
    private Integer cuotas;
    private Double mora;
    private String valoracion;

    protected Pago() {
    }

    public Pago(Integer idPago, Integer cuotas, Double mora, String valoracion) {
        this.idPago = idPago;
        this.cuotas = cuotas;
        this.mora = mora;
        this.valoracion = valoracion;
    }

    public Integer getIdPago() {
        return idPago;
    }

    public void setIdPago(Integer idPago) {
        this.idPago = idPago;
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
}
