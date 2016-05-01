package com.clubsis.model.clase;

/**
 * Created by Juan Tenorio on 29/4/2016.
 */
public class Horario {
    private Integer idHorario;
    private String dia;
    private Integer hora;

    protected Horario() {
    }

    public Horario(Integer idHorario, Integer hora, String dia) {
        this.idHorario = idHorario;
        this.hora = hora;
        this.dia = dia;
    }

    public Integer getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(Integer idHorario) {
        this.idHorario = idHorario;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public Integer getHora() {
        return hora;
    }

    public void setHora(Integer hora) {
        this.hora = hora;
    }
}
