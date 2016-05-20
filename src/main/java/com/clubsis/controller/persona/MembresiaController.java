package com.clubsis.controller.persona;

import com.clubsis.service.ServicioMembresias;
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

    @RequestMapping(value = "{id}",method = RequestMethod.POST)
    public void create(@PathVariable Integer id){
        servicioMembresias.crearMembresia(id);
    }

    @RequestMapping(value = "{id}",method = RequestMethod.PUT)
    public void update(@PathVariable Integer id){
        // TODO: reincorporar o suspender a un socio
    }

}
