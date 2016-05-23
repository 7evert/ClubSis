package com.clubsis.model.club;

import java.util.Date;
import javax.persistence.*;
/**
 * Created by Juan Tenorio on 29/4/2016.
 */
@Entity
public class Oferta {
    @Id
    @GeneratedValue
    private Integer id;
    private String nombre;
    private String descripcion;
    private Double porcentajeDescueto;
    private String tipoPagoAplicable;
    private Date fechaInicio;
    private Date fechaFin;

    private EstadoOferta estado;

    @ManyToOne
    private Club club;

    protected Oferta() {
    }

    public Oferta(String nombre, String descripcion, Double porcentajeDescueto, String tipoPagoAplicable, Date fechaInicio, Date fechaFin, EstadoOferta estado, Club club) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.porcentajeDescueto = porcentajeDescueto;
        this.tipoPagoAplicable = tipoPagoAplicable;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
        this.club = club;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPorcentajeDescueto() {
        return porcentajeDescueto;
    }

    public void setPorcentajeDescueto(Double porcentajeDescueto) {
        this.porcentajeDescueto = porcentajeDescueto;
    }

    public String getTipoPagoAplicable() {
        return tipoPagoAplicable;
    }

    public void setTipoPagoAplicable(String tipoPagoAplicable) {
        this.tipoPagoAplicable = tipoPagoAplicable;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public EstadoOferta getEstado() {
        return estado;
    }

    public void setEstado(EstadoOferta estado) {
        this.estado = estado;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }
}
