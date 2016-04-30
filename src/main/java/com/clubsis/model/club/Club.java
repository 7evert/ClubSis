package com.clubsis.model.club;

import java.awt.*;
import java.util.List;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */
public class Club {
    private String nombreClub;
    private Image logo;
    private List<Sorteo> sorteos;
    private List<Sancion> sanciones;

    public String getNombreClub() {
        return nombreClub;
    }

    public void setNombreClub(String nombreClub) {
        this.nombreClub = nombreClub;
    }

    public Image getLogo() {
        return logo;
    }

    public void setLogo(Image logo) {
        this.logo = logo;
    }

    public List<Sorteo> getSorteos() {
        return sorteos;
    }

    public void setSorteos(List<Sorteo> sorteos) {
        this.sorteos = sorteos;
    }

    public List<Sancion> getSanciones() {
        return sanciones;
    }

    public void setSanciones(List<Sancion> sanciones) {
        this.sanciones = sanciones;
    }
}
