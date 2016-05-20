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
    //private Set<String> observaciones; CAMBIAR LA RELACION MANY TO MANY Y PONERLO EN TABLA CRUZADA
    @ManyToMany(fetch = FetchType.EAGER, mappedBy ="postulantes")
    private Set<Socio> socios=new HashSet<Socio>();;

    protected Postulante() {
    }

    public Postulante(String nombre, String apellidoPaterno, String apellidoMaterno, Integer numeroDocumento, String tipoDocumento, Date fechaNacimiento, String estadoCivil, String direccion, Integer numeroHijos, Integer telefonoCasa, Integer telefonoTrabajo, Integer celular, String profesion, String nombreEmpresa, Double ingresosMensuales, Boolean esAprobado, String correo, Date fechaPostulacion, Boolean esActivo, Boolean esPeriodoObjeciones, Set<Socio> socios) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.numeroDocumento = numeroDocumento;
        this.tipoDocumento = tipoDocumento;
        this.fechaNacimiento = fechaNacimiento;
        this.estadoCivil = estadoCivil;
        this.direccion = direccion;
        this.numeroHijos = numeroHijos;
        this.telefonoCasa = telefonoCasa;
        this.telefonoTrabajo = telefonoTrabajo;
        this.celular = celular;
        this.profesion = profesion;
        this.nombreEmpresa = nombreEmpresa;
        this.ingresosMensuales = ingresosMensuales;
        this.esAprobado = esAprobado;
        this.correo = correo;
        this.fechaPostulacion = fechaPostulacion;
        this.esActivo = esActivo;
        this.esPeriodoObjeciones = esPeriodoObjeciones;
        this.socios = socios;
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

    public Set<Socio> getSocios() {
        return socios;
    }

    public void setSocios(Set<Socio> socios) {
        this.socios = socios;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
