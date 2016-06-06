package com.clubsis.controller.persona;

import com.clubsis.model.persona.SocioPostulante;
import com.clubsis.service.ServicioSocioPostulante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Juan Tenorio on 5/6/2016.
 */
@RestController
@RequestMapping("/api/sociopostulantes")
public class SocioPostulanteController {
    @Autowired
    private ServicioSocioPostulante servicioMembresias;

    @RequestMapping(method = RequestMethod.GET)
    public List<SocioPostulante> list() {
        return servicioMembresias.mostrarSocioPostulantes();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public SocioPostulante get(@PathVariable Integer id) {
        return servicioMembresias.buscarSocioPostulante(id);
    }

    @RequestMapping(value="/{id}/crear",method = RequestMethod.POST)
    public SocioPostulante create(@PathVariable Integer id, @RequestBody SocioPostulante sociopostulante) {
        return servicioMembresias.crearSocioPostulante(sociopostulante);
    }

    /*ahora?*/
    @RequestMapping(value = "/{id}/actualizar", method = RequestMethod.PUT)
    public SocioPostulante update(@PathVariable Integer id,@RequestBody SocioPostulante socio) {
        return servicioMembresias.actualizarSocioPostulante(id, socio);
    }
}
