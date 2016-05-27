package com.clubsis.controller.clase;

import com.clubsis.model.clase.Clase;
import com.clubsis.service.ServicioClases;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Vivian on 23/05/2016.
 */
@RestController
@RequestMapping("/api/clases")
public class ClaseController {
    @Autowired
    private ServicioClases servicioClases;

    @RequestMapping(method = RequestMethod.GET)
    public List<Clase> list() {
        return servicioClases.mostrarClases();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Clase get(@PathVariable Integer id) {
        return servicioClases.buscarClase(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Clase create(@RequestBody Clase clase) {
        return servicioClases.crearClase(clase);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Clase update(@PathVariable Integer id, @RequestBody Clase clase) {
        return servicioClases.actualizarClase(id, clase);
    }
}
