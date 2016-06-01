package com.clubsis.controller.evento;

import com.clubsis.model.evento.Evento;
import com.clubsis.model.evento.PersonaEvento;
import com.clubsis.model.persona.Persona;
import com.clubsis.service.ServicioEventos;
import com.clubsis.service.ServicioMembresias;
import com.clubsis.service.ServicioPersonaEvento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Juan Tenorio on 31/5/2016.
 */
@RestController
@RequestMapping("/api/personaeventos")
public class PersonaEventoController {
    @Autowired
    private ServicioPersonaEvento servicioPersonaEvento;
    @Autowired
    private ServicioMembresias servicioMembresias;
    @Autowired
    private ServicioEventos servicioEventos;

    @RequestMapping(method= RequestMethod.GET)
    List<PersonaEvento> list() { return servicioPersonaEvento.mostrarPersonaEventos();}
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public PersonaEvento get(@PathVariable Integer id) {
        return servicioPersonaEvento.buscarPersonaEvento(id);
    }

    @RequestMapping(value="/{idPersona}/{idEvento}/eventos",method=RequestMethod.POST)
    public PersonaEvento create(@PathVariable Integer idPersona, @PathVariable Integer idEvento){
        Persona invitado = servicioMembresias.buscarPersona(idPersona);
        Evento evento = servicioEventos.buscarEvento(idEvento);
        PersonaEvento personaEvento1 = new PersonaEvento(evento,invitado);
        return servicioPersonaEvento.crearPersonaEvento(personaEvento1);

    }

    @RequestMapping(value = "/{id}/eliminar", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id){
        servicioPersonaEvento.eliminarPersonaEvento(id);
    }

}
