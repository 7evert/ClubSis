package com.clubsis.model.pago;

import com.clubsis.model.bungalow.Bungalow;
import com.clubsis.model.clase.Clase;
import com.clubsis.model.club.Multa;
import com.clubsis.model.evento.Evento;
import com.clubsis.model.persona.Socio;
import com.clubsis.model.sede.Instalacion;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */
@Entity
public class Pago {
    @Id
    @GeneratedValue
    private Integer id;
    private String descripcion;
    private Double mora;
    private Double montoTotal;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date fechaVencimiento;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date fechaAnulacion;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date fechaRegistro;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date fechaPago;
    private EstadoPago estadoPago;
    private TipoPago tipoPago;

    private String valoracion;

    @ManyToOne(fetch = FetchType.EAGER)
    private Socio socio;

    @ManyToOne(fetch = FetchType.EAGER)
    private Evento evento;

    @ManyToOne(fetch = FetchType.EAGER)
    private Bungalow bungalow;

    @ManyToOne(fetch = FetchType.EAGER)
    private Clase clase;

    @ManyToOne(fetch = FetchType.EAGER)
    private Instalacion instalacion;

    @ManyToOne(fetch = FetchType.EAGER)
    private Multa multa;

    protected Pago() {
    }

    public Pago(String descripcion,Double mora, Double montoTotal, Date fechaVencimiento, Date fechaAnulacion, Date fechaPago, Date fechaRegistro, EstadoPago estadoPago, TipoPago tipoPago, String valoracion, Socio socio, Evento evento, Bungalow bungalow, Clase clase, Instalacion instalacion) {
        this.descripcion=descripcion;
        this.mora = mora;
        this.montoTotal = montoTotal;
        this.fechaVencimiento = fechaVencimiento;
        this.fechaAnulacion = fechaAnulacion;
        this.fechaPago = fechaPago;
        this.fechaRegistro = fechaRegistro;
        this.estadoPago = estadoPago;
        this.tipoPago = tipoPago;
        this.valoracion = valoracion;
        this.socio = socio;
        this.evento = evento;
        this.bungalow = bungalow;
        this.clase = clase;
        this.instalacion = instalacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public EstadoPago getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(EstadoPago estadoPago) {
        this.estadoPago = estadoPago;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Bungalow getBungalow() {
        return bungalow;
    }

    public void setBungalow(Bungalow bungalow) {
        this.bungalow = bungalow;
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    public Instalacion getInstalacion() {
        return instalacion;
    }

    public void setInstalacion(Instalacion instalacion) {
        this.instalacion = instalacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
