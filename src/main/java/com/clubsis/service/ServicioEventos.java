package com.clubsis.service;

import com.clubsis.model.evento.Evento;
import com.clubsis.repository.evento.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * Created by Juan Tenorio on 17/5/2016.
 */
@Service
public class ServicioEventos {

    @Autowired
    private EventoRepository eventoRepository;

    //Evento
    public List<Evento> mostrarEventos() {
        return eventoRepository.findAll();
    }

    public Evento buscarEvento(Integer id){return eventoRepository.findOne(id);}

    public Evento crearEvento(Evento evento){ return eventoRepository.saveAndFlush(evento);}

    public Evento actualizarEvento(Integer id, Evento evento){
        Evento eventoExistente = eventoRepository.findOne(id);
        BeanUtils.copyProperties(evento, eventoExistente);
        return eventoRepository.saveAndFlush(eventoExistente);
    }


}
