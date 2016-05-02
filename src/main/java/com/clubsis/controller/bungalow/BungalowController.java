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
@RequestMapping("/api/bungalows/")
public class BungalowController {

    @Autowired
    private ServicioReservas servicioReservas;

    @RequestMapping(method = RequestMethod.GET)
    public List<Bungalow> list() {
        // TODO: retornar todos los bungalows (llamar a un solo método del servicio que haga esto)
        return null;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Bungalow get(@PathVariable Integer id) {
        // TODO: retornar un bungalow (llamar a un solo método del servicio que haga esto)
        return null;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Bungalow create(@RequestBody Bungalow bungalow) {
        // TODO: crear un bungalow (llamar a un solo método del servicio que haga esto)
        return null;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Bungalow update(@PathVariable Integer id, @RequestBody Bungalow bungalow) {
        // TODO: actualizar un bungalow (llamar a un solo método del servicio que haga esto)
        return null;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public Bungalow delete(@PathVariable Integer id) {
        // TODO: eliminar un bungalow (llamar a un solo método del servicio que haga esto)
        return null;
    }

}
