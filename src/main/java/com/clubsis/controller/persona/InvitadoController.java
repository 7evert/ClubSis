package com.clubsis.controller.persona;

import com.clubsis.model.evento.Evento;
import com.clubsis.model.persona.Invitado;
import com.clubsis.model.persona.Socio;
import com.clubsis.service.ServicioEventos;
import com.clubsis.service.ServicioInvitados;
import com.clubsis.service.ServicioMembresias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by User on 20/05/2016.
 */
@RestController
@RequestMapping("/api/invitados")
public class InvitadoController {
    @Autowired
    private ServicioInvitados servicioInvitados;
    @Autowired
    private ServicioEventos servicioEventos;
    @Autowired
    private ServicioMembresias servicioSocio;
    @RequestMapping(method = RequestMethod.GET)
    public List<Invitado> list() {return servicioInvitados.mostrarInvitados();}

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Invitado get(@PathVariable Integer id) {
        return servicioInvitados.buscarInvitado(id);
    }

    @RequestMapping(value="/{idSocio}/eventos",method = RequestMethod.POST)
    public Invitado create(@PathVariable Integer idSocio,@RequestBody Invitado invitado){
        Socio socio = servicioSocio.buscarSocio(idSocio);
        invitado.setSocio(socio);
        return servicioInvitados.crearInvitado(invitado);
    }

    @RequestMapping(value = "/{id}/actualizar", method = RequestMethod.PUT)
    public Invitado update(@PathVariable Integer id, @RequestBody Invitado invitado){
        return servicioInvitados.actualizarInvitado(id,invitado);
    }

}

