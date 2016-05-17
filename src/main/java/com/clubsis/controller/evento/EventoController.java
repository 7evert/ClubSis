package com.clubsis.controller.evento;

import com.clubsis.model.evento.Evento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.clubsis.service.ServicioEventos;

import java.util.List;

/**
 * Created by Juan Tenorio on 17/5/2016.
 */
@RestController
@RequestMapping("/api/evento")
public class EventoController {

    @Autowired
    private ServicioEventos servicioEvento;

    @RequestMapping(method=RequestMethod.GET)
    List<Evento>  list() {
        return servicioEvento.mostrarEventos();
    }
}
