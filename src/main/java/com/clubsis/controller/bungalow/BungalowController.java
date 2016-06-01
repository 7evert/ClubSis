package com.clubsis.controller.bungalow;

import com.clubsis.model.bungalow.Bungalow;
import com.clubsis.model.bungalow.EstadoBungalow;
import com.clubsis.model.bungalow.TipoBungalow;
import com.clubsis.model.sede.Sede;
import com.clubsis.service.ServicioReservas;
import com.clubsis.service.ServicioSedes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
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

    @Autowired
    private ServicioSedes servicioSedes;

    @RequestMapping(method = RequestMethod.GET)
    public List<Bungalow> list() {
        return servicioReservas.mostrarBungalows();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Bungalow get(@PathVariable Integer id) {
        return servicioReservas.buscarBungalow(id);
    }

    @RequestMapping(value = "/{idTipoBungalow}/{idSede}", method = RequestMethod.POST)
    public Bungalow create(@PathVariable Integer idTipoBungalow, @PathVariable Integer idSede, @RequestBody Bungalow bungalow) {
        TipoBungalow tipoBungalow =  servicioReservas.obtenerBungalow(idTipoBungalow);
        Sede sede = servicioSedes.buscarSede(idSede);
        bungalow.setTipoBungalow(tipoBungalow);
        bungalow.setSede(sede);
        return servicioReservas.crearBungalow(bungalow);
    }

    @RequestMapping(value = "/{id}/{idTipoBungalow}/{idSede}", method = RequestMethod.PUT)
    public Bungalow update(@PathVariable Integer id, @PathVariable Integer idTipoBungalow, @PathVariable Integer idSede, @RequestBody Bungalow bungalow) {
        TipoBungalow tipoBungalow =  servicioReservas.obtenerBungalow(idTipoBungalow);
        Sede sede = servicioSedes.buscarSede(idSede);
        bungalow.setTipoBungalow(tipoBungalow);
        bungalow.setSede(sede);
        return servicioReservas.actualizarBungalow(id, bungalow);
    }

    @RequestMapping(value = "/eliminar", method = RequestMethod.POST)
    public Integer editarPostulante(Model model, @RequestParam(value = "idBungalow") Integer idBungalow) {
        Bungalow bungalow = servicioReservas.buscarBungalow(idBungalow);
        bungalow.setEstado(EstadoBungalow.DESHABILITADO); //Lo deshabilitamos de la base de datos
        servicioReservas.actualizarBungalow(idBungalow,bungalow);
        return 1;
    }
    //PPRUEBAS THE BLITZ
    //The blitz es mi pastor
    // TODO: crear un método (o controlador entero?) para las reservas de un bungalow
}
