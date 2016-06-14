package com.clubsis.service;

import com.clubsis.model.clase.*;
import com.clubsis.repository.clase.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Vivian on 23/05/2016.
 */

@Service
public class ServicioClases {

    @Autowired
    private AcademiaRepository academiaRepository;
    @Autowired
    private CicloRepository cicloRepository;
    @Autowired
    private ClaseRepository claseRepository;
    @Autowired
    private HorarioRepository horarioRepository;
    @Autowired
    private RegistroClaseRepository registroClaseRepository;

    //ACADEMIA
    public List<Academia> mostrarAcademias() {
        return academiaRepository.findAll();
    }

    public Academia crearAcademia(Academia academia) {
        return academiaRepository.saveAndFlush(academia);
    }

    public Academia buscarAcademia(Integer id) {
        return academiaRepository.findOne(id);
    }

    public Academia actualizarAcademia(Integer id, Academia academia) {
        Academia academiaExistente = academiaRepository.findOne(id);
        BeanUtils.copyProperties(academia, academiaExistente);
        return academiaRepository.saveAndFlush(academiaExistente);
    }

    //CICLO
    public List<Ciclo> mostrarCiclos() {
        return cicloRepository.findAll();
    }

    public Ciclo crearCiclo(Ciclo ciclo) {
        return cicloRepository.saveAndFlush(ciclo);
    }

    public Ciclo buscarCiclo(Integer id) {
        return cicloRepository.findOne(id);
    }

    public Ciclo actualizarCiclo(Integer id, Ciclo ciclo) {
        Ciclo cicloExistente = cicloRepository.findOne(id);
        BeanUtils.copyProperties(ciclo, cicloExistente);
        return cicloRepository.saveAndFlush(cicloExistente);
    }

    //CLASE
    public List<Clase> mostrarClases() {
        return claseRepository.findAll();
    }

    public Clase crearClase(Clase clase) {
        return claseRepository.saveAndFlush(clase);
    }

    public Clase buscarClase(Integer id) {
        return claseRepository.findOne(id);
    }

    public Clase actualizarClase(Integer id, Clase clase) {
        Clase claseExistente = claseRepository.findOne(id);
        BeanUtils.copyProperties(clase, claseExistente);
        return claseRepository.saveAndFlush(claseExistente);
    }

    //HORARIO
    public List<Horario> mostrarHorarios() {
        return horarioRepository.findAll();
    }

    public Horario crearHorario(Horario horario) {
        return horarioRepository.saveAndFlush(horario);
    }

    public Horario buscarHorario(Integer id) {
        return horarioRepository.findOne(id);
    }

    public Horario actualizarHorario(Integer id, Horario horario) {
        Horario horarioExistente = horarioRepository.findOne(id);
        BeanUtils.copyProperties(horario, horarioExistente);
        return horarioRepository.saveAndFlush(horarioExistente);
    }

    //RESGISTROCLASE
    public List<RegistroClase> mostrarRegistrosClase() {
        return registroClaseRepository.findAll();
    }

    public RegistroClase crearRegistroClase(RegistroClase registro) {
        return registroClaseRepository.saveAndFlush(registro);
    }

    public RegistroClase buscarRegistroClase(Integer id) {
        return registroClaseRepository.findOne(id);
    }

    public RegistroClase actualizarRegistroClase(Integer id, RegistroClase registroClase) {
        RegistroClase registroExistente = registroClaseRepository.findOne(id);
        BeanUtils.copyProperties(registroClase, registroExistente);
        return registroClaseRepository.saveAndFlush(registroExistente);
    }

    //MAS FUNCIONES
    public Ciclo obtenerCicloActual() {
        List<Ciclo> ciclos = cicloRepository.findAll();
        for (Ciclo item : ciclos) {
            if (item.getEstadoCiclo() == EstadoCiclo.HABILITADO) return item;
        }
        return null;
    }

    public List<Clase> mostrarClasesCiclo(Integer idAcademia) {
        Ciclo cicloAct = obtenerCicloActual();
        List<Clase> clases = claseRepository.findAll();
        List<Clase> respuesta = new ArrayList<Clase>();
        for (Clase item : clases) {
            if (item.getCiclo().getId() == cicloAct.getId() && item.getAcademia().getId() == idAcademia) {
                respuesta.add(item);
            }
        }
        return respuesta;
    }

    public List<Horario> mostrarHorariosClase(Integer idClase) {
        List<Horario> horarios = horarioRepository.findAll();
        List<Horario> respuesta = new ArrayList<Horario>();
        for (Horario item : horarios) {
            if (idClase == item.getClase().getId()) {
                respuesta.add(item);
            }
        }
        return respuesta;
    }

}
