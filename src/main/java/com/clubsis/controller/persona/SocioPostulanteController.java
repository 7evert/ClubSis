package com.clubsis.controller.persona;

import com.clubsis.model.persona.Postulante;
import com.clubsis.model.persona.Socio;
import com.clubsis.model.persona.SocioPostulante;
import com.clubsis.service.ServicioMembresias;
import com.clubsis.service.ServicioPostulante;
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

    @Autowired
    private ServicioMembresias servicioMembresia;

    @Autowired
    private ServicioPostulante servicioPostulante;

    @RequestMapping(method = RequestMethod.GET)
    public List<SocioPostulante> list() {
        return servicioMembresias.mostrarSocioPostulantes();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public SocioPostulante get(@PathVariable Integer id) {
        return servicioMembresias.buscarSocioPostulante(id);
    }

    @RequestMapping(value="/{idSocio}/{idPostulante}//crear",method = RequestMethod.POST)
    public SocioPostulante create(@PathVariable Integer idSocio, @PathVariable Integer idPostulante,@RequestBody SocioPostulante sociopostulante) {
        Socio socio = servicioMembresia.buscarSocio(idSocio);
        Postulante postulante =servicioPostulante.buscarPostulante(idPostulante);
        String observacion = sociopostulante.getObservaciones();
        SocioPostulante tmp = new SocioPostulante(observacion,socio,postulante);
        return servicioMembresias.crearSocioPostulante(tmp);
    }

    /*ahora?*/
    @RequestMapping(value = "/{id}/actualizar", method = RequestMethod.PUT)
    public SocioPostulante update(@PathVariable Integer id,@RequestBody SocioPostulante socio) {
        return servicioMembresias.actualizarSocioPostulante(id, socio);
    }

    @RequestMapping(value ="/{idPostulante}/retornar",method= RequestMethod.GET)
    public List<String> getObservaciones(@PathVariable Integer idPostulante){
        return servicioMembresias.getObservaciones(idPostulante);
    }

    @RequestMapping(value ="/{idPostulante}/socios",method= RequestMethod.GET)
    public List<Socio> getSocios(@PathVariable Integer idPostulante){
        return servicioMembresias.getSocios(idPostulante);
    }

}
