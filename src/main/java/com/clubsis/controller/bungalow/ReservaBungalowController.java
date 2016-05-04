package com.clubsis.controller.bungalow;

import com.clubsis.model.bungalow.ReservaBungalow;
import com.clubsis.service.ServicioReservas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Sebastian on 02-May-16.
 */

@RestController
@RequestMapping("/api/reservasbungalow")
public class ReservaBungalowController {
    @Autowired
    private ServicioReservas servicioReservas;

    @RequestMapping(method = RequestMethod.GET)
    public List<ReservaBungalow> list() {
        // TODO: retornar todos los bungalows (llamar a un solo método del servicio que haga esto)
        return null;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ReservaBungalow get(@PathVariable Integer id) {
        // TODO: retornar un bungalow (llamar a un solo método del servicio que haga esto)
        return null;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ReservaBungalow create(@RequestBody ReservaBungalow bungalow) {
        // TODO: crear un bungalow (llamar a un solo método del servicio que haga esto)
        return null;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ReservaBungalow update(@PathVariable Integer id, @RequestBody ReservaBungalow bungalow) {
        // TODO: actualizar un bungalow (llamar a un solo método del servicio que haga esto)
        return null;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ReservaBungalow delete(@PathVariable Integer id) {
        // TODO: eliminar un bungalow (llamar a un solo método del servicio que haga esto)
        return null;
    }
}
