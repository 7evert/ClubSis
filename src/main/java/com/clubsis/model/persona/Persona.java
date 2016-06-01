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
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private Date fechaNacimiento;
    private String direccion;
    private String correo;
    private Integer dni;
    private Integer telefono;
    private Boolean esTitular;
    private TipoInvitado tipo;

    @JsonIgnore
    @OneToMany(fetch= FetchType.EAGER,mappedBy = "persona")
    private Set<PersonaEvento> personaEventos;

    @ManyToOne(fetch = FetchType.EAGER)
    private Socio socio;

    @ManyToOne(fetch = FetchType.EAGER)
    private Usuario usuario;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy ="personas")
    private Set<RegistroClase> registroClases = new HashSet<RegistroClase>();

    protected Persona() {
    }

    public Persona(String nombre, String apellidoPaterno, String apellidoMaterno, Date fechaNacimiento, String direccion, String correo, Integer dni, Integer telefono, Boolean esTitular, TipoInvitado tipo, Set<PersonaEvento> personaEventos, Socio socio, Usuario usuario, Set<RegistroClase> registroClases) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.correo = correo;
        this.dni = dni;
        this.telefono = telefono;
        this.esTitular = esTitular;
        this.tipo = tipo;
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

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public Boolean getEsTitular() {
        return esTitular;
    }

    public void setEsTitular(Boolean esTitular) {
        this.esTitular = esTitular;
    }

    public TipoInvitado getTipo() {
        return tipo;
    }

    public void setTipo(TipoInvitado tipo) {
        this.tipo = tipo;
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
}
