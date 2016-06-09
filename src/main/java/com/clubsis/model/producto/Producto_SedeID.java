package com.clubsis.model.producto;

import com.clubsis.model.sede.Sede;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by Vivian on 7/06/2016.
 */
@Embeddable
public class Producto_SedeID implements Serializable {
    @ManyToOne(cascade = CascadeType.ALL)
    private Producto producto;
    @ManyToOne(cascade = CascadeType.ALL)
    private Sede sede;

    protected Producto_SedeID() {
    }

    public Producto_SedeID(Producto producto, Sede sede) {
        this.producto = producto;
        this.sede = sede;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Producto_SedeID that = (Producto_SedeID) o;

        if (producto != null ? !producto.equals(that.producto) : that.producto != null) return false;
        if (sede != null ? !sede.equals(that.sede) : that.sede != null)
            return false;

        return true;
    }

    public int hashCode() {
        int result;
        result = (producto != null ? producto.hashCode() : 0);
        result = 31 * result + (sede != null ? sede.hashCode() : 0);
        return result;
    }
}
