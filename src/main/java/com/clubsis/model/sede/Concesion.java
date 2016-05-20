package com.clubsis.model.sede;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */
public class Concesion {
    private Integer id;
    private String razonSocial;
    private String ruc;

    protected Concesion() {
    }

    public Concesion(Integer id, String razonSocial, String ruc) {
        this.setId(id);
        this.razonSocial = razonSocial;
        this.ruc = ruc;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
