package com.clubsis.controller.bungalow;

import com.clubsis.model.bungalow.*;
import com.clubsis.service.*;
import com.clubsis.service.ServicioBungalow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Sebastian on 05-May-16.
 */

@RestController
@RequestMapping("/api/tiposbungalow")
public class TipoBungalowController {
    @Autowired
    private ServicioReservas servicioReservas;
    @Autowired
    private ServicioBungalow servicioBungalow;

    @RequestMapping(method = RequestMethod.GET)
    public List<TipoBungalow> list() {
        return servicioReservas.mostrarTiposBungalow();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public TipoBungalow get(@PathVariable Integer id) {
        // TODO: retornar un tipo de bungalow (llamar a un solo método del servicio que haga esto)
        TipoBungalow tipoBungalow = servicioReservas.obtenerBungalow(id);
        return tipoBungalow;
    }

    @RequestMapping(method = RequestMethod.POST)
    public TipoBungalow create(@RequestBody TipoBungalow tipoBungalow) {
        return servicioReservas.crearTipoBungalow(tipoBungalow);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public TipoBungalow update(@PathVariable Integer id, @RequestBody TipoBungalow tipoBungalow) {
        // TODO: actualizar un tipo de bungalow (llamar a un solo método del servicio que haga esto)
        return servicioReservas.actualizarTipoBungalow(id,tipoBungalow);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public TipoBungalow delete(@PathVariable Integer id) {
        // TODO: eliminar un tipo de bungalow (llamar a un solo método del servicio que haga esto)
        return null;
    }

    @RequestMapping(value = "/eliminar", method = RequestMethod.POST)
    public Integer editarPostulante(Model model, @RequestParam(value = "idTipoBungalow") Integer idTipoBungalow) {
        TipoBungalow tipoBungalow = servicioReservas.obtenerBungalow(idTipoBungalow);
        tipoBungalow.setEstado(EstadoTipoBungalow.INHABILITADO); //Lo deshabilitamos de la base de datos
        servicioReservas.actualizarTipoBungalow(idTipoBungalow,tipoBungalow);
        return 1;
    }

    @RequestMapping(value = "/getEstadoTipoBungalow",method = RequestMethod.GET)
    public EstadoTipoBungalow[] getEstadoBungalow(){
        return servicioBungalow.getEstadoTipoBungalow();
    }
}
