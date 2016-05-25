package com.clubsis.model.persona;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */
@Entity
public class Invitado {
    @Id
    @GeneratedValue
    private Integer id;
    private String apellidoPaterno;
    private String apellidoMaterno;
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private Date fechaVisita;
    private Boolean esExoneradoPago;
    private String tipoDocumento;
    private Integer numeroDocumento;
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private Date fechaSalida;
    private String nombres;


    @ManyToOne(fetch = FetchType.EAGER)
    private Socio socio;

    protected Invitado() {
    }

    public Invitado(String apellidoPaterno, String apellidoMaterno, Date fechaVisita, String tipoDocumento, Boolean esExoneradoPago, Date fechaSalida, Integer numeroDocumento, Socio socio, String nombres) {
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaVisita = fechaVisita;
        this.tipoDocumento = tipoDocumento;
        this.esExoneradoPago = esExoneradoPago;
        this.fechaSalida = fechaSalida;
        this.numeroDocumento = numeroDocumento;
        this.socio = socio;
        this.nombres = nombres;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public Date getFechaVisita() {
        return fechaVisita;
    }

    public void setFechaVisita(Date fechaVisita) {
        this.fechaVisita = fechaVisita;
    }

    public Boolean getEsExoneradoPago() {
        return esExoneradoPago;
    }

    public void setEsExoneradoPago(Boolean esExoneradoPago) {
        this.esExoneradoPago = esExoneradoPago;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Integer getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(Integer numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }
}
