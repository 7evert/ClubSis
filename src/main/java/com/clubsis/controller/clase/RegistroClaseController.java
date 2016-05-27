package com.clubsis.controller.clase;

import com.clubsis.model.clase.RegistroClase;
import com.clubsis.service.ServicioClases;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Vivian on 23/05/2016.
 */
@RestController
@RequestMapping("/api/registrosClase")
public class RegistroClaseController {
    @Autowired
    private ServicioClases servicioClases;

    @RequestMapping(method = RequestMethod.GET)
    public List<RegistroClase> list() {
        return servicioClases.mostrarRegistrosClase();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public RegistroClase get(@PathVariable Integer id) {
        return servicioClases.buscarRegistroClase(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public RegistroClase create(@RequestBody RegistroClase registro) {
        return servicioClases.crearRegistroClase(registro);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public RegistroClase update(@PathVariable Integer id, @RequestBody RegistroClase registro) {
        return servicioClases.actualizarRegistroClase(id, registro);
    }
}
