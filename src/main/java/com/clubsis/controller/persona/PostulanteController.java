package com.clubsis.controller.persona;

import com.clubsis.model.persona.Postulante;
import com.clubsis.service.ServicioMembresias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Blitz on 20/05/2016.
 */
@RestController
@RequestMapping("/api/postulantes")
public class PostulanteController {
    @Autowired
    private ServicioMembresias servicioMembresias;

    @RequestMapping(method = RequestMethod.GET)
    public List<Postulante> list() {
        return servicioMembresias.mostrarPostulantes() ;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Postulante get(@PathVariable Integer id) {
        return servicioMembresias.buscarPostulante(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Postulante create(@RequestBody Postulante postulante) {
        return servicioMembresias.crearPostulante(postulante);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Postulante update(@PathVariable Integer id, @RequestBody Postulante postulante) {
        return servicioMembresias.actualizarPostulante(id,postulante);
    }
}
