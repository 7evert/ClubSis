package com.clubsis.model.club;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */
public class Usuario {
    private Integer idUsuario;
    private String contraseña;

    protected Usuario() {
    }

    public Usuario(Integer idUsuario, String contraseña) {
        this.idUsuario = idUsuario;
        this.contraseña = contraseña;
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
}
