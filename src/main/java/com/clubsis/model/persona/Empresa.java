package com.clubsis.model.persona;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */
public class Empresa {
    private Integer idEmpresa;
    private String razonSocial;
    private String ruc;
    private String representante;
    private String telefono;
    private String celularContacto;
    private String correoElectronico;

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRepresentante() {
        return representante;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelularContacto() {
        return celularContacto;
    }

    public void setCelularContacto(String celularContacto) {
        this.celularContacto = celularContacto;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
}
