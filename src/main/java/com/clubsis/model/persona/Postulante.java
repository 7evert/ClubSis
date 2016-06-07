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
    @JsonFormat(pattern="yyyy-MM-dd")
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
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date fechaPostulacion;
    private EstadoPostulante esAprobado;
    private Boolean esActivo;
    private Boolean esPeriodoObjeciones;

    @OneToMany(mappedBy="postulante",fetch = FetchType.EAGER)
    private Set<SocioPostulante> socios=new HashSet<SocioPostulante>();

    protected Postulante(){

    }
    public Postulante(String nombre, String apellidoPaterno, String apellidoMaterno, String tipoDocumento, Integer numeroDocumento, Date fechaNacimiento, String estadoCivil, Integer numeroHijos, String direccion, Integer telefonoCasa, Integer celular, Integer telefonoTrabajo, String profesion, Double ingresosMensuales, String nombreEmpresa, String correo, Date fechaPostulacion, EstadoPostulante esAprobado, Boolean esActivo, Boolean esPeriodoObjeciones, Set<SocioPostulante> socios) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.fechaNacimiento = fechaNacimiento;
        this.estadoCivil = estadoCivil;
        this.numeroHijos = numeroHijos;
        this.direccion = direccion;
        this.telefonoCasa = telefonoCasa;
        this.celular = celular;
        this.telefonoTrabajo = telefonoTrabajo;
        this.profesion = profesion;
        this.ingresosMensuales = ingresosMensuales;
        this.nombreEmpresa = nombreEmpresa;
        this.correo = correo;
        this.fechaPostulacion = fechaPostulacion;
        this.esAprobado = esAprobado;
        this.esActivo = esActivo;
        this.esPeriodoObjeciones = esPeriodoObjeciones;
        this.socios = socios;
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

    public EstadoPostulante getEsAprobado() {
        return esAprobado;
    }

    public void setEsAprobado(EstadoPostulante esAprobado) {
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

    public Set<SocioPostulante> getSocios() {
        return socios;
    }

    public void setSocios(Set<SocioPostulante> socios) {
        this.socios = socios;
    }
}
