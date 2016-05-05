package com.clubsis.model.bungalow;

import com.clubsis.model.sede.Sede;

import javax.persistence.*;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */
@Entity
public class Bungalow {

    @Id
    @GeneratedValue
    @Column(name="id_bungalow")
    private Integer idBungalow;
    private Integer capacidad;
    private Integer estado; //libre, en mantenimiento, ocupado, no irá en el formulario
    private Double precio;
    private String caracteristicas;

    // El cascade sirve para que se pueda pasar por JSON un objeto de tipo TipoBungalow
    // y que se cree también adicionalmente al Bungalow en la base de datos.
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private TipoBungalow tipoBungalow; // necesario (composición)

    @ManyToOne
    private Sede sede; // necesaria (composición)
    private String ubicacionEnSede;
    private Integer piso;

    @OneToOne
    private ReservaBungalow reservaBungalow; // EN EL FUTURO CAMBIAR DE UNO A MUCHOS PORQUE SE NECESITARÁ PARA LA SANCIÓN
    // no necesaria (se puede crear Bungalow con ReservaBungalow = null)

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    public String getUbicacionEnSede() {
        return ubicacionEnSede;
    }

    public void setUbicacionEnSede(String ubicacionEnSede) {
        this.ubicacionEnSede = ubicacionEnSede;
    }

    public Integer getPiso() {
        return piso;
    }

    public void setPiso(Integer piso) {
        this.piso = piso;
    }

    public Bungalow(Integer capacidad, Integer estado, Double precio, String caracteristicas, TipoBungalow tipoBungalow, Sede sede, String ubicacionEnSede, Integer piso) {
        this.capacidad = capacidad;
        this.estado = estado;
        this.precio = precio;
        this.caracteristicas = caracteristicas;
        this.tipoBungalow = tipoBungalow;
        this.sede = sede;
        this.ubicacionEnSede = ubicacionEnSede;
        this.piso = piso;
    }

    protected Bungalow() {
    }

    public Integer getIdBungalow() {
        return idBungalow;
    }

    public void setIdBungalow(Integer idBungalow) {
        this.idBungalow = idBungalow;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public TipoBungalow getTipoBungalow() {
        return tipoBungalow;
    }

    public void setTipoBungalow(TipoBungalow tipoBungalow) {
        this.tipoBungalow = tipoBungalow;
    }
}
