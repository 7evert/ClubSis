package com.clubsis.model.club;

import com.clubsis.model.persona.Persona;
import com.clubsis.model.privilegio.Rol;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */
@Entity
public class Usuario {
    @Id
    @GeneratedValue
    private Integer id;
    private String contraseña;
    private Integer dni;
    private Boolean esActivo;

    // Mayra quiere esto
    private String nombreUsuario;

    @OneToOne
    private Persona persona;

    @ManyToOne
    private Rol rol;

    public Usuario() {
    }

    public Usuario(String contraseña, Integer dni, Boolean esActivo, String nombreUsuario, Persona persona) {

        this.contraseña = contraseña;
        this.dni = dni;
        this.esActivo = esActivo;
        this.nombreUsuario = nombreUsuario;
        this.persona = persona;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public Boolean getEsActivo() {
        return esActivo;
    }

    public void setEsActivo(Boolean esActivo) {
        this.esActivo = esActivo;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

}
