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
    private Integer idOferta;
    private String nombreOferta;
    private String descripcion;
    private Double porcentajeDescueto;
    private String tipoPagoAplicable;
    private Date fechaInicio;
    private Date fechaFin;
    private String estado;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_club")
    private Club club;
    protected Oferta() {
    }

    public Oferta(Integer idOferta, String nombreOferta, String descripcion, String tipoPagoAplicable, Double porcentajeDescueto, Date fechaInicio, Date fechaFin, String estado) {
        this.idOferta = idOferta;
        this.nombreOferta = nombreOferta;
        this.descripcion = descripcion;
        this.tipoPagoAplicable = tipoPagoAplicable;
        this.porcentajeDescueto = porcentajeDescueto;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
    }

    public Integer getIdOferta() {
        return idOferta;
    }

    public void setIdOferta(Integer idOferta) {
        this.idOferta = idOferta;
    }

    public String getNombreOferta() {
        return nombreOferta;
    }

    public void setNombreOferta(String nombreOferta) {
        this.nombreOferta = nombreOferta;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Club getClub() { return club; }

    public void setClub(Club club) { this.club = club; }
}
