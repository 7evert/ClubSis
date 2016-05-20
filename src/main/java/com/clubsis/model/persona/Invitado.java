package com.clubsis.model.persona;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */
@Entity
public class Invitado {
    @Id
    @GeneratedValue
    private Integer idInvitado;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Date fechaVisita;
    private Boolean esExoneradoPago;
    private String tipoDocumento;
    private Integer numeroDocumento;
    private Date fechaSalida;
    private String nombres;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_socio")
    private Socio socio;
    protected Invitado() {
    }

    public Invitado(Integer idInvitado, String apellidoPaterno, String apellidoMaterno, Boolean esExoneradoPago, Date fechaVisita, String tipoDocumento, Integer numeroDocumento, Date fechaSalida, String nombres) {
        this.idInvitado = idInvitado;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.esExoneradoPago = esExoneradoPago;
        this.fechaVisita = fechaVisita;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.fechaSalida = fechaSalida;
        this.nombres = nombres;
    }

    public Integer getIdInvitado() {
        return idInvitado;
    }

    public void setIdInvitado(Integer idInvitado) {
        this.idInvitado = idInvitado;
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
}
