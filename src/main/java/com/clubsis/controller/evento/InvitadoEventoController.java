package com.clubsis.controller.evento;

import com.clubsis.model.evento.Evento;
import com.clubsis.model.evento.InvitadoEvento;
import com.clubsis.model.persona.Invitado;
import com.clubsis.service.ServicioEventos;
import com.clubsis.service.ServicioInvitadoEvento;
import com.clubsis.service.ServicioInvitados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Juan Tenorio on 29/5/2016.
 */
@RestController
@RequestMapping("/api/invitadoeventos")
public class InvitadoEventoController {
    @Autowired
    private ServicioInvitadoEvento servicioInvitadoEvento;

    @Autowired
    private ServicioInvitados servicioInvitados;

    @Autowired
    private ServicioEventos servicioEventos;

    @RequestMapping(method= RequestMethod.GET)
    List<InvitadoEvento> list() { return servicioInvitadoEvento.mostrarInvitadoEventos();}

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public InvitadoEvento get(@PathVariable Integer id) {
        return servicioInvitadoEvento.buscarInvitadoEvento(id);
    }

    @RequestMapping(value="/{idInvitado}/{idEvento}/eventos",method=RequestMethod.POST)
    public InvitadoEvento create(@PathVariable Integer idInvitado, @PathVariable Integer idEvento,@RequestBody InvitadoEvento invitadoEvento){
        Invitado invitado = servicioInvitados.buscarInvitado(idInvitado);
        Evento evento = servicioEventos.buscarEvento(idEvento);
        InvitadoEvento invitadoEvento1 = new InvitadoEvento(evento,invitado,invitadoEvento.getTipo());
        return servicioInvitadoEvento.crearInvitadoEvento(invitadoEvento1);

    }

    @RequestMapping(value = "/{id}/eliminar", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id){
        servicioInvitadoEvento.eliminarInvitadoEvento(id);
    }

}
