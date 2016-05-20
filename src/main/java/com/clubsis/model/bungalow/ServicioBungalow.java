package com.clubsis.model.bungalow;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */

/**
 * Slsvcn: esta clase NO es un servicio en el sentido de arquitectura de software.
 */

@Entity
public class ServicioBungalow {
    @Id
    @GeneratedValue
    private Integer id;
    private String descripcion;
    private Double precio;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "serviciosBungalows")
    private Set<ReservaBungalow> reservasBungalows;

    protected ServicioBungalow(){
    }

    public ServicioBungalow(String descripcion, Double precio, Set<ReservaBungalow> reservasBungalows) {
        this.descripcion = descripcion;
        this.precio = precio;
        this.reservasBungalows = reservasBungalows;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Set<ReservaBungalow> getReservasBungalows() {
        return reservasBungalows;
    }

    public void setReservasBungalows(Set<ReservaBungalow> reservasBungalows) {
        this.reservasBungalows = reservasBungalows;
    }
}
