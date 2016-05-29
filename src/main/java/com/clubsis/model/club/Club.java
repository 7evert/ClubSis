package com.clubsis.model.club;


import com.clubsis.model.pago.CuotaExtraordinaria;
import com.clubsis.model.privilegio.Permiso;
import com.clubsis.model.privilegio.Rol;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */
@Entity
public class Club {
    @Id
    @GeneratedValue
    private Integer id;
    private String nombre;
    private String vision;
    private String mision;
    private String historia;
    private String urlFoto;
    @JsonIgnore
    @OneToMany(mappedBy = "club")
    private Set<Oferta> ofertas;
    @JsonIgnore
    @OneToMany(mappedBy = "club")
    private Set<Sancion> sanciones;
    @JsonIgnore
    @OneToMany(mappedBy = "club")
    private Set<Sorteo> sorteos;
    @JsonIgnore
    @OneToMany(mappedBy = "club")
    private Set<CuotaExtraordinaria> cuotasExtraordinarias;
    @JsonIgnore
    @OneToMany(mappedBy = "club")
    private Set<Permiso> permisos;
    @JsonIgnore
    @OneToMany(mappedBy = "club")
    private Set<Rol> roles;


    protected Club() {
    }

    public Club(String nombre, String vision, String mision, String historia, String urlFoto, Set<Oferta> ofertas, Set<Sancion> sanciones, Set<Sorteo> sorteos, Set<CuotaExtraordinaria> cuotasExtraordinarias, Set<Permiso> permisos, Set<Rol> roles) {
        this.nombre = nombre;
        this.vision = vision;
        this.mision = mision;
        this.historia = historia;
        this.urlFoto = urlFoto;
        this.ofertas = ofertas;
        this.sanciones = sanciones;
        this.sorteos = sorteos;
        this.cuotasExtraordinarias = cuotasExtraordinarias;
        this.permisos = permisos;
        this.roles = roles;
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

    public String getVision() {
        return vision;
    }

    public void setVision(String vision) {
        this.vision = vision;
    }

    public String getMision() {
        return mision;
    }

    public void setMision(String mision) {
        this.mision = mision;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public Set<Oferta> getOfertas() {
        return ofertas;
    }

    public void setOfertas(Set<Oferta> ofertas) {
        this.ofertas = ofertas;
    }

    public Set<Sancion> getSanciones() {
        return sanciones;
    }

    public void setSanciones(Set<Sancion> sanciones) {
        this.sanciones = sanciones;
    }

    public Set<Sorteo> getSorteos() {
        return sorteos;
    }

    public void setSorteos(Set<Sorteo> sorteos) {
        this.sorteos = sorteos;
    }

    public Set<CuotaExtraordinaria> getCuotasExtraordinarias() {
        return cuotasExtraordinarias;
    }

    public void setCuotasExtraordinarias(Set<CuotaExtraordinaria> cuotasExtraordinarias) {
        this.cuotasExtraordinarias = cuotasExtraordinarias;
    }

    public Set<Permiso> getPermisos() {
        return permisos;
    }

    public void setPermisos(Set<Permiso> permisos) {
        this.permisos = permisos;
    }

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }
}
