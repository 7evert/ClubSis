package com.clubsis.controller.persona;

import com.clubsis.model.persona.Invitado;
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
    private ServicioMembresias servicioMembresias;

    @RequestMapping(method = RequestMethod.GET)
    public List<Invitado> list() {return servicioMembresias.mostrarInvitados();}

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Invitado get(@PathVariable Integer id) {
        return servicioMembresias.buscarInvitado(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Invitado create(@RequestBody Invitado invitado){
        return servicioMembresias.crearInvitado(invitado);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Invitado update(@PathVariable Integer id, @RequestBody Invitado invitado){
        return servicioMembresias.actualizarInvitado(id,invitado);
    }

}
