package com.clubsis.model.persona;

import java.util.Date;
import javax.persistence.*;

import com.clubsis.model.clase.RegistroClase;
import com.clubsis.model.club.Usuario;
import com.clubsis.model.evento.Evento;
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
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date fechaNacimiento;
    private String direccion;
    private String correo;
    private Integer dni;
    private Integer telefono;
    private Boolean esTitular;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_socio")
    private Socio socio;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "personas")
    private Set<Evento> eventos = new HashSet<Evento>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "persona")
    @JsonIgnore
    private Set<RegistroClase> registrosClase = new HashSet<>();

    protected Persona() {
    }

    public Persona(String nombre, String apellidoPaterno, String apellidoMaterno, String direccion, Date fechaNacimiento, String correo, Integer dni, Integer telefono, Boolean esTitular, Socio socio, Set<Evento> eventos, Usuario usuario) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.correo = correo;
        this.dni = dni;
        this.telefono = telefono;
        this.esTitular = esTitular;
        this.socio = socio;
        this.usuario = usuario;
        this.eventos = eventos;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(Set<Evento> eventos) {
        this.eventos = eventos;
    }

    public Set<RegistroClase> getRegistrosClase() {
        return registrosClase;
    }

    public void setRegistrosClase(Set<RegistroClase> registrosClase) {
        this.registrosClase = registrosClase;
    }
}
