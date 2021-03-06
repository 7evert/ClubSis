package com.clubsis.model.club;

import com.clubsis.model.persona.Persona;
import com.clubsis.model.privilegio.Rol;
import com.clubsis.model.sede.Sede;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */
@Entity
public class Usuario {
    @Id
    @GeneratedValue
    private Integer id;
    private String contrasenha;
    private Integer dni;
    private Boolean esActivo;

    // Mayra quiere esto
    private String nombreUsuario;

    @OneToOne
    private Persona persona;

    @ManyToOne
    private Rol rol;

    @ManyToMany
    private Set<Sede> sedes =new HashSet<>();

    public Usuario() {
    }

    public Usuario(String contrasenha, Integer dni, Boolean esActivo, String nombreUsuario, Persona persona, Rol rol, Set<Sede> sedes) {
        this.setContrasenha(contrasenha);
        this.dni = dni;
        this.esActivo = esActivo;
        this.nombreUsuario = nombreUsuario;
        this.persona = persona;
        this.rol = rol;
        this.sedes = sedes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Set<Sede> getSedes() {
        return sedes;
    }

    public void setSedes(Set<Sede> sedes) {
        this.sedes = sedes;
    }

    public String getContrasenha() {
        return contrasenha;
    }

    public void setContrasenha(String contrasenha) {
        this.contrasenha = contrasenha;
    }
}
