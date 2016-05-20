package com.clubsis.model.sede;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */
public class Concesion {
    private Integer idConcesion;
    private String razonSocial;
    private String ruc;

    protected Concesion() {
    }

    public Concesion(Integer idConcesion, String razonSocial, String ruc) {
        this.idConcesion = idConcesion;
        this.razonSocial = razonSocial;
        this.ruc = ruc;
    }

    public Integer getIdConcesion() {
        return idConcesion;
    }

    public void setIdConcesion(Integer idConcesion) {
        this.idConcesion = idConcesion;
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
}
