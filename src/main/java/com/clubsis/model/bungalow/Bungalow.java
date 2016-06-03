package com.clubsis.model.bungalow;

import com.clubsis.model.club.Sorteo;
import com.clubsis.model.pago.Pago;
import com.clubsis.model.sede.Sede;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */
@Entity
public class Bungalow {

    @Id
    @GeneratedValue
    private Integer id;
    private EstadoBungalow estado; //libre, en mantenimiento, ocupado, no irá en el formulario
    private Double precio;
    private String caracteristicas;
    private Integer piso;
    private Integer valoracion;
    private String urlFoto;
    private String descripcion;

    @ManyToOne
    private TipoBungalow tipoBungalow; // necesario (composición)

    @ManyToOne
    private Sede sede; // necesaria (composición)

    @OneToMany(mappedBy = "bungalow")
    @JsonIgnore
    private Set<ReservaBungalow> reservaBungalowSet; // no es necesario al inicio (vacío)

    @OneToMany(mappedBy = "bungalow")
    @JsonIgnore
    private Set<Sorteo> sorteos;

    @OneToMany(mappedBy = "bungalow")
    @JsonIgnore
    private Set<Pago> pagos;

    protected Bungalow() {
    }

    public Bungalow(EstadoBungalow estado, Double precio, Integer piso, String caracteristicas, String urlFoto, Integer valoracion, String descripcion, Sede sede, Set<ReservaBungalow> reservaBungalowSet, Set<Sorteo> sorteos, Set<Pago> pagos, TipoBungalow tipoBungalow) {
        this.estado = estado;
        this.precio = precio;
        this.piso = piso;
        this.caracteristicas = caracteristicas;
        this.urlFoto = urlFoto;
        this.valoracion = valoracion;
        this.descripcion = descripcion;
        this.sede = sede;
        this.reservaBungalowSet = reservaBungalowSet;
        this.sorteos = sorteos;
        this.pagos = pagos;
        this.tipoBungalow = tipoBungalow;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EstadoBungalow getEstado() {
        return estado;
    }

    public void setEstado(EstadoBungalow estado) {
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

    public Integer getPiso() {
        return piso;
    }

    public void setPiso(Integer piso) {
        this.piso = piso;
    }

    public Integer getValoracion() {
        return valoracion;
    }

    public void setValoracion(Integer valoracion) {
        this.valoracion = valoracion;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoBungalow getTipoBungalow() {
        return tipoBungalow;
    }

    public void setTipoBungalow(TipoBungalow tipoBungalow) {
        this.tipoBungalow = tipoBungalow;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    public Set<ReservaBungalow> getReservaBungalowSet() {
        return reservaBungalowSet;
    }

    public void setReservaBungalowSet(Set<ReservaBungalow> reservaBungalowSet) {
        this.reservaBungalowSet = reservaBungalowSet;
    }

    public Set<Sorteo> getSorteos() {
        return sorteos;
    }

    public void setSorteos(Set<Sorteo> sorteos) {
        this.sorteos = sorteos;
    }
}
