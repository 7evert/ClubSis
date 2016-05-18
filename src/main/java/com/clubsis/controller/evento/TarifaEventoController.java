package com.clubsis.controller.evento;

import com.clubsis.model.evento.TarifaEvento;
import com.clubsis.service.ServicioEventos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Juan Tenorio on 17/5/2016.
 */
@RestController
@RequestMapping("/api/tarifaeventos")
public class TarifaEventoController {

    @Autowired
    private ServicioEventos servicioEvento;

    @RequestMapping(method=RequestMethod.GET)
    List<TarifaEvento> list() { return servicioEvento.mostrarTarifas();}

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public TarifaEvento get(@PathVariable Integer id) {return servicioEvento.buscarTarifa(id);}

    @RequestMapping(method = RequestMethod.POST)
    public TarifaEvento create(@RequestBody TarifaEvento tarifa) {
        return servicioEvento.crearTarifa(tarifa);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public TarifaEvento update(@PathVariable Integer id, @RequestBody TarifaEvento tarifa) {
        return servicioEvento.actualizarTarifa(id, tarifa);
    }
}
