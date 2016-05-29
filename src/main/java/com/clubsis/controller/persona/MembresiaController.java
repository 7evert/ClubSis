package com.clubsis.controller.persona;

import com.clubsis.model.persona.EstadoPostulante;
import com.clubsis.model.persona.Postulante;
import com.clubsis.model.persona.Socio;
import com.clubsis.service.ServicioMembresias;
import com.clubsis.service.ServicioPagos;
import com.clubsis.service.ServicioPostulante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Blitz on 18/05/2016.
 */
@RestController
@RequestMapping("/api/membresias")
public class MembresiaController {
    @Autowired
    private ServicioMembresias servicioMembresias;

    @Autowired
    private ServicioPagos servicioPagos;

    @Autowired
    private ServicioPostulante servicioPostulante;

    //esto recibe el id del postulante
    @RequestMapping(value = "/{id}/{respuesta}",method = RequestMethod.POST)
    public void responderMembresia(@PathVariable Integer id,@PathVariable Boolean respuesta){
        if(respuesta){//Aprobado
            Socio nuevoSocio = servicioMembresias.crearMembresia(id);
            servicioPagos.primerPago(nuevoSocio);
        }
        else{
            Postulante postulanteActualizado=servicioPostulante.buscarPostulante(id);
            postulanteActualizado.setEsAprobado(EstadoPostulante.RECHAZADO);
            servicioPostulante.actualizarPostulante(id,postulanteActualizado);
        }

    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public void update(@PathVariable Integer id){
        // TODO: reincorporar o suspender a un socio
    }

}
