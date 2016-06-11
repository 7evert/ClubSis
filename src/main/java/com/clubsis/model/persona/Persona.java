package com.clubsis.model.persona;

import java.util.Date;
import javax.persistence.*;

import com.clubsis.model.clase.RegistroClase;
import com.clubsis.model.club.Usuario;
import com.clubsis.model.evento.Evento;
import com.clubsis.model.evento.PersonaEvento;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */
@Entity
public class Persona {
    @Id
    @GeneratedValue
    private Integer id;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date fechaNacimiento;
    private String direccion;
    private String correo;
    private TipoDocumento tipoDoc;
    private String numDoc;
    private String telefono;
    private Boolean esTitular;
    private String nombreContactoEmergencia;
    private String telefonoContactoEmergencia;

    @JsonIgnore
    @OneToMany(fetch= FetchType.EAGER,mappedBy = "persona")
    private Set<PersonaEvento> personaEventos;

    @ManyToOne(fetch = FetchType.EAGER)
    private Socio socio;

    @OneToOne(mappedBy = "persona")
    @JsonIgnore
    private Usuario usuario;

    @OneToMany(fetch = FetchType.EAGER, mappedBy ="persona")
    @JsonIgnore
    private Set<RegistroClase> registroClases = new HashSet<RegistroClase>();

    public Persona() {
    }

    public Persona(String nombre, String apellidoPaterno, String apellidoMaterno, Date fechaNacimiento, String direccion, String correo, TipoDocumento tipoDoc, String numDoc, String telefono, Boolean esTitular, Set<PersonaEvento> personaEventos, Socio socio, Usuario usuario, Set<RegistroClase> registroClases) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.correo = correo;
        this.tipoDoc = tipoDoc;
        this.numDoc = numDoc;
        this.telefono = telefono;
        this.esTitular = esTitular;
        this.personaEventos = personaEventos;
        this.socio = socio;
        this.usuario = usuario;
        this.registroClases = registroClases;
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

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public TipoDocumento getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(TipoDocumento tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public String getNumDoc() {
        return numDoc;
    }

    public void setNumDoc(String numDoc) {
        this.numDoc = numDoc;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Boolean getEsTitular() {
        return esTitular;
    }

    public void setEsTitular(Boolean esTitular) {
        this.esTitular = esTitular;
    }

    public Set<PersonaEvento> getPersonaEventos() {
        return personaEventos;
    }

    public void setPersonaEventos(Set<PersonaEvento> personaEventos) {
        this.personaEventos = personaEventos;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Set<RegistroClase> getRegistroClases() {
        return registroClases;
    }

    public void setRegistroClases(Set<RegistroClase> registroClases) {
        this.registroClases = registroClases;
    }

    public String getNombreContactoEmergencia() {
        return nombreContactoEmergencia;
    }

    public void setNombreContactoEmergencia(String nombreContactoEmergencia) {
        this.nombreContactoEmergencia = nombreContactoEmergencia;
    }

    public String getTelefonoContactoEmergencia() {
        return telefonoContactoEmergencia;
    }

    public void setTelefonoContactoEmergencia(String telefonoContactoEmergencia) {
        this.telefonoContactoEmergencia = telefonoContactoEmergencia;
    }
}
