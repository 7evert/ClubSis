package com.clubsis.model.clase;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */
public class Clase {
    private Integer idClase;
    private Integer nivel;
    private String rangoEdad;
    private Double precioCiclo;
    private Double precioMes;
    private Integer capacidad;
    private String profesor;

    protected Clase() {
    }

    public Clase(Integer idClase, Integer nivel, String rangoEdad, Double precioCiclo, Double precioMes, Integer capacidad, String profesor) {
        this.idClase = idClase;
        this.nivel = nivel;
        this.rangoEdad = rangoEdad;
        this.precioCiclo = precioCiclo;
        this.precioMes = precioMes;
        this.capacidad = capacidad;
        this.profesor = profesor;
    }

    public Integer getIdClase() {
        return idClase;
    }

    public void setIdClase(Integer idClase) {
        this.idClase = idClase;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public String getRangoEdad() {
        return rangoEdad;
    }

    public void setRangoEdad(String rangoEdad) {
        this.rangoEdad = rangoEdad;
    }

    public Double getPrecioCiclo() {
        return precioCiclo;
    }

    public void setPrecioCiclo(Double precioCiclo) {
        this.precioCiclo = precioCiclo;
    }

    public Double getPrecioMes() {
        return precioMes;
    }

    public void setPrecioMes(Double precioMes) {
        this.precioMes = precioMes;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }
}
