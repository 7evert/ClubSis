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
@RequestMapping("/api/eventos")
public class EventoController {

    @Autowired
    private ServicioEventos servicioEvento;

    @RequestMapping(method=RequestMethod.GET)
    List<Evento>  list() { return servicioEvento.mostrarEventos();}

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Evento get(@PathVariable Integer id) {
        return servicioEvento.buscarEvento(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Evento create(@RequestBody Evento evento) {
        return servicioEvento.crearEvento(evento);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Evento update(@PathVariable Integer id, @RequestBody Evento evento) {
        return servicioEvento.actualizarEvento(id, evento);
    }
}
