package com.clubsis.model.producto;

import com.clubsis.model.sede.Sede;

import javax.persistence.*;

/**
 * Created by Vivian on 7/06/2016.
 */
@Entity
@AssociationOverrides({
        @AssociationOverride(
                name = "id.producto", joinColumns = @JoinColumn(name="producto_id")),
        @AssociationOverride(
                name ="id.sede",joinColumns=@JoinColumn(name="sede_id")
        ),
})
public class Producto_Sede {
    @EmbeddedId
    private Producto_SedeID id = new Producto_SedeID();

    private Integer stock ;

    public Producto_Sede() {
    }

    public Producto_Sede(Producto_SedeID id, Integer stock) {
        this.id = id;
        this.stock = stock;
    }

    public Producto_SedeID getId() {
        return id;
    }

    public void setId(Producto_SedeID id) {
        this.id = id;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Transient
    public Producto getProducto() { return getId().getProducto(); }

    public void setProducto(Producto producto) {
        getId().setProducto(producto);
    }

    @Transient
    public Sede getSede() {
        return getId().getSede();
    }

    public void setSede(Sede sede) {
        getId().setSede(sede);
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Producto_Sede that = (Producto_Sede) o;

        if (getId() != null ? !getId().equals(that.getId())
                : that.getId() != null)
            return false;

        return true;
    }

    public int hashCode() {
        return (getId() != null ? getId().hashCode() : 0);
    }
}
