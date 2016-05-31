package com.clubsis.controller.clase;

import com.clubsis.model.clase.Ciclo;
import com.clubsis.service.ServicioClases;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Vivian on 23/05/2016.
 */

@RestController
@RequestMapping("/api/ciclos")
public class CicloController {
    @Autowired
    private ServicioClases servicioClases;

    @RequestMapping(method = RequestMethod.GET)
    public List<Ciclo> list() {
        return servicioClases.mostrarCiclos();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Ciclo get(@PathVariable Integer id) {
        if(id==0) return servicioClases.obtenerCicloActual();
        else return servicioClases.buscarCiclo(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Ciclo create(@RequestBody Ciclo ciclo) {
        return servicioClases.crearCiclo(ciclo);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Ciclo update(@PathVariable Integer id, @RequestBody Ciclo ciclo) {
        return servicioClases.actualizarCiclo(id, ciclo);
    }
}
