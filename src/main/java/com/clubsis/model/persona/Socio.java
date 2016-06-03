package com.clubsis.model.persona;

import com.clubsis.model.club.Usuario;
import com.clubsis.model.pago.CuotaExtraordinaria;
import com.clubsis.model.pago.Pago;
import com.clubsis.model.pago.PagoMembresia;
import com.clubsis.model.sede.ReservaInstalacion;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import sun.util.PreHashedMap;

import java.util.Date;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */
@Entity
public class Socio {
    @Id
    @GeneratedValue
    private Integer id;
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private Date fechaInscripcion;
    private EstadoSocio estado;
    //@Column(columnDefinition = "integer auto_increment")
    private Integer codigoCarnet;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "socio")
    private Set<Invitado> invitados =new HashSet<Invitado>();

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "socio")
    @JsonIgnore
    private Set<Persona> personas =new HashSet<Persona>();

    @OneToMany(mappedBy="id.socio",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Socio_Postulante> postulantes=new HashSet<Socio_Postulante>();

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER)
    private Set<Pago> pagos =new HashSet<Pago>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "socio")
    @JsonIgnore
    private Set<CuotaExtraordinaria> cuotasExtraordinarias =new HashSet<CuotaExtraordinaria>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "socio")
    @JsonIgnore
    private Set<Suspension> suspensiones =new HashSet<Suspension>();

    @OneToMany(mappedBy = "socio")
    @JsonIgnore
    private Set<ReservaInstalacion> reservasInstalacion = new HashSet<>();

    @OneToMany(mappedBy = "socio")
    @JsonIgnore
    private Set<PagoMembresia> pagosMembresia = new HashSet<>();

    @OneToMany(mappedBy = "socio")
    @JsonIgnore
    private Set<PagoMembresia> reservaBungalow = new HashSet<>();

    @ManyToOne
    private TipoSocio tipo;

    protected Socio() {
    }

    public Socio(Date fechaInscripcion, EstadoSocio estado, Integer codigoCarnet, Set<Invitado> invitados, Set<Persona> personas, Set<Socio_Postulante> postulantes, Set<Pago> pagos, Set<CuotaExtraordinaria> cuotasExtraordinarias, Set<Suspension> suspensiones, Set<ReservaInstalacion> reservasInstalacion, Set<PagoMembresia> pagosMembresia, TipoSocio tipo) {
        this.fechaInscripcion = fechaInscripcion;
        this.estado = estado;
        this.codigoCarnet = codigoCarnet;
        this.invitados = invitados;
        this.personas = personas;
        this.postulantes = postulantes;
        this.pagos = pagos;
        this.cuotasExtraordinarias = cuotasExtraordinarias;
        this.suspensiones = suspensiones;
        this.reservasInstalacion = reservasInstalacion;
        this.pagosMembresia = pagosMembresia;
        this.tipo = tipo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(Date fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public EstadoSocio getEstado() {
        return estado;
    }

    public void setEstado(EstadoSocio estado) {
        this.estado = estado;
    }

    public Integer getCodigoCarnet() {
        return codigoCarnet;
    }

    public void setCodigoCarnet(Integer codigoCarnet) {
        this.codigoCarnet = codigoCarnet;
    }

    public Set<Invitado> getInvitados() {
        return invitados;
    }

    public void setInvitados(Set<Invitado> invitados) {
        this.invitados = invitados;
    }

    public Set<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(Set<Persona> personas) {
        this.personas = personas;
    }

    public Set<Socio_Postulante> getPostulantes() {
        return postulantes;
    }

    public void setPostulantes(Set<Socio_Postulante> postulantes) {
        this.postulantes = postulantes;
    }

    public Set<Pago> getPagos() {
        return pagos;
    }

    public void setPagos(Set<Pago> pagos) {
        this.pagos = pagos;
    }

    public Set<CuotaExtraordinaria> getCuotasExtraordinarias() {
        return cuotasExtraordinarias;
    }

    public void setCuotasExtraordinarias(Set<CuotaExtraordinaria> cuotasExtraordinarias) {
        this.cuotasExtraordinarias = cuotasExtraordinarias;
    }

    public Set<Suspension> getSuspensiones() {
        return suspensiones;
    }

    public void setSuspensiones(Set<Suspension> suspensiones) {
        this.suspensiones = suspensiones;
    }

    public Set<ReservaInstalacion> getReservasInstalacion() {
        return reservasInstalacion;
    }

    public void setReservasInstalacion(Set<ReservaInstalacion> reservasInstalacion) {
        this.reservasInstalacion = reservasInstalacion;
    }

    public Set<PagoMembresia> getPagosMembresia() {
        return pagosMembresia;
    }

    public void setPagosMembresia(Set<PagoMembresia> pagosMembresia) {
        this.pagosMembresia = pagosMembresia;
    }

    public TipoSocio getTipo() {
        return tipo;
    }

    public void setTipo(TipoSocio tipo) {
        this.tipo = tipo;
    }
}
