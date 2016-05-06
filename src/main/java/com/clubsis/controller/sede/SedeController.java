package com.clubsis.controller.sede;

import com.clubsis.model.sede.Sede;
import com.clubsis.service.ServicioReservas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Sebastian on 06-May-16.
 */

@RestController
@RequestMapping("/api/sedes")
public class SedeController {

    @Autowired
    private ServicioReservas servicioReservas;

    @RequestMapping(method = RequestMethod.GET)
    public List<Sede> list() {
        return servicioReservas.mostrarSedes();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Sede create(@RequestBody Sede sede) {
        return servicioReservas.crearSede(sede);
    }
}
