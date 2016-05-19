package com.clubsis.model.club;

import com.clubsis.model.persona.Persona;
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
    @Column(name="id_usuario")
    private Integer idUsuario;
    private String contraseña;
    private Integer dni;
    @OneToMany(fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Persona> personas; // no se que nombre ponerle

    protected Usuario() {
    }

    public Usuario(Integer dni, String contraseña, Set<Persona> personas) {
        this.dni = dni;
        this.contraseña = contraseña;
        this.personas = personas;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
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
}
