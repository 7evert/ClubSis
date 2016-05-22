package com.clubsis.controller.persona;

import com.clubsis.model.persona.Postulante;
import com.clubsis.service.ServicioMembresias;
import com.clubsis.service.ServicioPostulante;
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
    private ServicioPostulante servicioPostulante;

    @RequestMapping(method = RequestMethod.GET)
    public List<Postulante> list() {
        return servicioPostulante.mostrarPostulantes() ;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Postulante get(@PathVariable Integer id) {
        return servicioPostulante.buscarPostulante(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Postulante create(@RequestBody Postulante postulante) {
        return servicioPostulante.crearPostulante(postulante);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Postulante update(@PathVariable Integer id, @RequestBody Postulante postulante) {
        return servicioPostulante.actualizarPostulante(id,postulante);
    }
}
