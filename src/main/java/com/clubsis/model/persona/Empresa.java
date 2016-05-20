package com.clubsis.model.persona;

import com.clubsis.model.evento.Evento;
import com.clubsis.model.sede.ReservaInstalacion;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */
@Entity
public class Empresa {

    @Id
    @GeneratedValue
    private Integer id;
    private String razonSocial;
    private String ruc;
    private String representante;
    private String telefono;
    private String celularContacto;
    private String correoElectronico;

    @ManyToMany(mappedBy ="empresas")
    private Set<Evento> eventos;

    @OneToMany(fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<ReservaInstalacion> reservasInstalacion = new HashSet<>();

    protected Empresa() {
    }

    public Empresa(String razonSocial, String ruc, String representante, String celularContacto, String telefono, String correoElectronico, Set<Evento> eventos, Set<ReservaInstalacion> reservasInstalacion) {
        this.razonSocial = razonSocial;
        this.ruc = ruc;
        this.representante = representante;
        this.celularContacto = celularContacto;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.eventos = eventos;
        this.reservasInstalacion = reservasInstalacion;
    }
}
