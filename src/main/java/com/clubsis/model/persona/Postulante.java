package com.clubsis.model.persona;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */
@Entity
public class Postulante {
    @Id
    @GeneratedValue
    private Integer idPostulante;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String tipoDocumento;
    private Integer numeroDocumento;
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
    private String observaciones;
    private Date fechaPostulacion;
    @ManyToMany
    private Set<Socio> socios;

    protected Postulante() {
    }

    public Postulante(Integer idPostulante, String nombre, String apellidoPaterno, String tipoDocumento, Integer numeroDocumento, String apellidoMaterno, Date fechaNacimiento, String estadoCivil, String direccion, Integer numeroHijos, Integer telefonoCasa, Integer telefonoTrabajo, Integer celular, String profesion, Double ingresosMensuales, String nombreEmpresa, String correo, String observaciones, Date fechaPostulacion) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.estadoCivil = estadoCivil;
        this.direccion = direccion;
        this.numeroHijos = numeroHijos;
        this.telefonoCasa = telefonoCasa;
        this.telefonoTrabajo = telefonoTrabajo;
        this.celular = celular;
        this.profesion = profesion;
        this.ingresosMensuales = ingresosMensuales;
        this.nombreEmpresa = nombreEmpresa;
        this.correo = correo;
        this.observaciones = observaciones;
        this.fechaPostulacion = fechaPostulacion;
    }



    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Date getFechaPostulacion() {
        return fechaPostulacion;
    }

    public void setFechaPostulacion(Date fechaPostulacion) {
        this.fechaPostulacion = fechaPostulacion;
    }

    public Integer getIdPostulante() {
        return idPostulante;
    }

    public void setIdPostulante(Integer idPostulante) {
        this.idPostulante = idPostulante;
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
}
