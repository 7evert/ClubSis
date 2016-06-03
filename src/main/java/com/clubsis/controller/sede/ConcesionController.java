package com.clubsis.controller.sede;

import com.clubsis.model.sede.Concesion;
import com.clubsis.service.ServicioConcesion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Vivian on 02/06/2016.
 */

@RestController
@RequestMapping("/api/concesiones")
public class ConcesionController {
    @Autowired
    private ServicioConcesion servicioConcesion;

    @RequestMapping(method = RequestMethod.GET)
    public List<Concesion> list() {
        return servicioConcesion.mostrarConcesiones();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Concesion get(@PathVariable Integer id) {
        return servicioConcesion.buscarConcesion(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Concesion create(@RequestBody Concesion concesion) {
        return servicioConcesion.crearConcesion(concesion);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Concesion update(@PathVariable Integer id, @RequestBody Concesion concesion) {
        return servicioConcesion.actualizarConcesion(id, concesion);
    }
}
