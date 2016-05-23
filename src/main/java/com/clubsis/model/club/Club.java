package com.clubsis.model.club;


import com.clubsis.model.pago.CuotaExtraordinaria;
import com.clubsis.model.privilegio.Permiso;
import com.clubsis.model.privilegio.Rol;

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

    @OneToMany(mappedBy = "club")
    private Set<Oferta> ofertas;

    @OneToMany(mappedBy = "club")
    private Set<Sancion> sanciones;

    @OneToMany(mappedBy = "club")
    private Set<Sorteo> sorteos;

    @OneToMany(mappedBy = "club")
    private Set<CuotaExtraordinaria> cuotasExtraordinarias;

    @OneToMany(mappedBy = "club")
    private Set<Permiso> permisos;

    @OneToMany(mappedBy = "club")
    private Set<Rol> roles;


    protected Club() {
    }

    public Club(String nombre, String vision, String mision, String historia, String urlFoto, Set<Oferta> ofertas) {
        this.nombre = nombre;
        this.vision = vision;
        this.mision = mision;
        this.historia = historia;
        this.urlFoto = urlFoto;
        this.ofertas = ofertas;
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
}
