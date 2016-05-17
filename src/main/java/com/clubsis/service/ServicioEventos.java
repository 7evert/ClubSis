package com.clubsis.service;

import com.clubsis.model.evento.Evento;
import com.clubsis.repository.evento.EventoRepository;
import com.clubsis.repository.evento.TarifaEventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Juan Tenorio on 17/5/2016.
 */
@Service
public class ServicioEventos {

    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private TarifaEventoRepository tarifaEventoRepository;

    //Evento
    public List<Evento> mostrarEventos() {
        return eventoRepository.findAll();
    }
}
