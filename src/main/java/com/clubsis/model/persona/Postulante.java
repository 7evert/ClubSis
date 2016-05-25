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
public class Postulante {
    @Id
    @GeneratedValue
    private Integer id;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String tipoDocumento;
    private Integer numeroDocumento;
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private Date fechaNacimiento;
    private String estadoCivil;
    private Integer numeroHijos;
    private String direccion;
    private Integer telefonoCasa;
    private Integer celular;
    private Integer telefonoTrabajo;
    private String profesion;
    private Double ingresosMensuales;
    private String nombreEmpresa;
    private String correo;
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private Date fechaPostulacion;
    private Boolean esAprobado;
    private Boolean esActivo;
    private Boolean esPeriodoObjeciones;

    protected Postulante() {
    }

    public Postulante(String nombre, String apellidoPaterno, String tipoDocumento, String apellidoMaterno, String estadoCivil, Integer numeroDocumento, Date fechaNacimiento, Integer numeroHijos, Integer telefonoCasa, String direccion, Integer telefonoTrabajo, Integer celular, Double ingresosMensuales, String profesion, String correo, String nombreEmpresa, Boolean esAprobado, Date fechaPostulacion, Boolean esActivo, Boolean esPeriodoObjeciones) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.tipoDocumento = tipoDocumento;
        this.apellidoMaterno = apellidoMaterno;
        this.estadoCivil = estadoCivil;
        this.numeroDocumento = numeroDocumento;
        this.fechaNacimiento = fechaNacimiento;
        this.numeroHijos = numeroHijos;
        this.telefonoCasa = telefonoCasa;
        this.direccion = direccion;
        this.telefonoTrabajo = telefonoTrabajo;
        this.celular = celular;
        this.ingresosMensuales = ingresosMensuales;
        this.profesion = profesion;
        this.correo = correo;
        this.nombreEmpresa = nombreEmpresa;
        this.esAprobado = esAprobado;
        this.fechaPostulacion = fechaPostulacion;
        this.esActivo = esActivo;
        this.esPeriodoObjeciones = esPeriodoObjeciones;
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

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Integer getNumeroHijos() {
        return numeroHijos;
    }

    public void setNumeroHijos(Integer numeroHijos) {
        this.numeroHijos = numeroHijos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getTelefonoCasa() {
        return telefonoCasa;
    }

    public void setTelefonoCasa(Integer telefonoCasa) {
        this.telefonoCasa = telefonoCasa;
    }

    public Integer getCelular() {
        return celular;
    }

    public void setCelular(Integer celular) {
        this.celular = celular;
    }

    public Integer getTelefonoTrabajo() {
        return telefonoTrabajo;
    }

    public void setTelefonoTrabajo(Integer telefonoTrabajo) {
        this.telefonoTrabajo = telefonoTrabajo;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public Double getIngresosMensuales() {
        return ingresosMensuales;
    }

    public void setIngresosMensuales(Double ingresosMensuales) {
        this.ingresosMensuales = ingresosMensuales;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Date getFechaPostulacion() {
        return fechaPostulacion;
    }

    public void setFechaPostulacion(Date fechaPostulacion) {
        this.fechaPostulacion = fechaPostulacion;
    }

    public Boolean getEsAprobado() {
        return esAprobado;
    }

    public void setEsAprobado(Boolean esAprobado) {
        this.esAprobado = esAprobado;
    }

    public Boolean getEsActivo() {
        return esActivo;
    }

    public void setEsActivo(Boolean esActivo) {
        this.esActivo = esActivo;
    }

    public Boolean getEsPeriodoObjeciones() {
        return esPeriodoObjeciones;
    }

    public void setEsPeriodoObjeciones(Boolean esPeriodoObjeciones) {
        this.esPeriodoObjeciones = esPeriodoObjeciones;
    }
}
