package com.clubsis.controller.persona;

import com.clubsis.model.persona.EstadoSuspension;
import com.clubsis.model.persona.Suspension;
import com.clubsis.service.ServicioMembresias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by Juan Tenorio on 17/5/2016.
 */
@RestController
@RequestMapping("/api/suspensiones")
public class SuspensionController {
    @Autowired
    private ServicioMembresias servicioMembresias;

    @RequestMapping(method = RequestMethod.GET)
    public List<Suspension> list(){return servicioMembresias.mostrarSuspensiones();}

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Suspension get(@PathVariable Integer id){
        return servicioMembresias.buscarSuspension(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Suspension create(@RequestBody Suspension suspension){
        suspension.setEstado(EstadoSuspension.REGISTRADA);
        suspension.setFechaSolicitud(new Date());
        /*suspension.setFechaRespuesta(null);
        suspension.setFechaAnulacion(null);*/
        return servicioMembresias.crearSuspension(suspension);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Suspension update(@PathVariable Integer id, @RequestBody Suspension suspension){
        return servicioMembresias.actualizarSuspension(id,suspension);
    }


}
