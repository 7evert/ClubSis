package com.clubsis.controller.bungalow;

import com.clubsis.model.bungalow.Bungalow;
import com.clubsis.service.ServicioReservas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Sebastian on 01-May-16.
 */

@RestController
@RequestMapping("/api/bungalows")
public class BungalowController {

    @Autowired
    private ServicioReservas servicioReservas;

    @RequestMapping(method = RequestMethod.GET)
    public List<Bungalow> list() {
        return servicioReservas.mostrarBungalows();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Bungalow get(@PathVariable Integer id) {
        return servicioReservas.buscarBungalow(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Bungalow create(@RequestBody Bungalow bungalow) {
        return servicioReservas.crearBungalow(bungalow);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Bungalow update(@PathVariable Integer id, @RequestBody Bungalow bungalow) {
        return servicioReservas.actualizarBungalow(id, bungalow);
    }
    //PPRUEBAS THE BLITZ
    // TODO: crear un método (o controlador entero?) para las reservas de un bungalow
}
