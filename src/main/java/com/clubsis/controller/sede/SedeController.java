package com.clubsis.controller.sede;

import com.clubsis.model.evento.Evento;
import com.clubsis.model.sede.Sede;
import com.clubsis.repository.sede.SedeRepository;
import com.clubsis.service.ServicioEventos;
import com.clubsis.service.ServicioReservas;
import com.clubsis.service.ServicioSedes;
import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Sebastian on 06-May-16.
 */

@RestController
@RequestMapping("/api/sedes")
public class SedeController {

    @Autowired
    private ServicioSedes servicioSedes;

    @Autowired
    private ServicioEventos servicioEventos;

    @RequestMapping(method = RequestMethod.GET)
    public List<Sede> list() {
        List<Sede> lstSedes = servicioSedes.mostrarSedes();
        return servicioSedes.mostrarSedes();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Sede create(@RequestBody Sede sede) { return servicioSedes.crearSede(sede); }

 /*   @RequestMapping(value="/{id}/eventos/",method = RequestMethod.PUT)
    public Evento agregarEventoNuevo(@PathVariable int id, @RequestBody Evento evento){
        Sede sede = servicioSedes.buscarSede(id);
        evento.setSede(sede);
        return evento;
    }*/
}
