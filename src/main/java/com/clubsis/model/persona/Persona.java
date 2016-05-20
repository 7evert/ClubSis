package com.clubsis.model.persona;

import java.util.Date;
import javax.persistence.*;

import com.clubsis.model.club.Usuario;
import com.clubsis.model.evento.Evento;
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
    private Date fechaNacimiento;
    private String direccion;
    private String correoElectronico;
    private Integer dni;
    private Integer telefono;
    private Boolean esTitular;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_socio")
    private Socio socio;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_usuario")
    private Usuario usuario;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy ="personas")
    private Set<Evento> eventos;

    protected Persona() {
    }

    public Persona( String nombre, String apellidoPaterno, String apellidoMaterno, Date fechaNacimiento, String direccion, String correoElectronico, Integer dni, Integer telefono, Boolean esTitular) {
    this.nombre = nombre;
    this.apellidoPaterno = apellidoPaterno;
    this.apellidoMaterno = apellidoMaterno;
    this.fechaNacimiento = fechaNacimiento;
    this.direccion = direccion;
    this.correoElectronico = correoElectronico;
    this.dni = dni;
    this.telefono = telefono;
    this.esTitular = esTitular;
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

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
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

    public Socio getSocio() { return socio; }

    public void setSocio(Socio socio) { this.socio = socio; }

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
}
