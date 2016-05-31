package com.clubsis.controller.persona;

import com.clubsis.model.persona.Persona;
import com.clubsis.service.ServicioMembresias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Blitz on 20/05/2016.
 */
@RestController
@RequestMapping("/api/personas")
public class PersonaController {
    @Autowired
    private ServicioMembresias servicioMembresias;

    @RequestMapping(method = RequestMethod.GET)
    public List<Persona> list() {return servicioMembresias.mostrarPersonas();}

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Persona get(@PathVariable Integer id) {
        return servicioMembresias.buscarPersona(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Persona create(@RequestBody Persona persona){
        return servicioMembresias.crearPersona(persona);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)

    public Persona update(@PathVariable Integer id, @RequestBody Persona persona){
        return servicioMembresias.actualizarPersona(id,persona);
    }
}

