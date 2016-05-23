package com.clubsis.controller.evento;

import com.clubsis.model.evento.Tarifa;
import com.clubsis.service.ServicioEventos;
import com.clubsis.service.ServicioSedes;
import com.clubsis.service.ServicioTarifas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Juan Tenorio on 17/5/2016.
 */
@RestController
@RequestMapping("/api/tarifas")
public class TarifaController {

    @Autowired
    private ServicioTarifas servicioTarifas;

    @RequestMapping(method=RequestMethod.GET)
    List<Tarifa> list() { return servicioTarifas.mostrarTarifas();}

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Tarifa get(@PathVariable Integer id) {return servicioTarifas.buscarTarifa(id);}

    @RequestMapping(method = RequestMethod.POST)
    public Tarifa create(@RequestBody Tarifa tarifa) { return servicioTarifas.crearTarifa(tarifa);}

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Tarifa update(@PathVariable Integer id, @RequestBody Tarifa tarifa) {
        return servicioTarifas.actualizarTarifa(id, tarifa);
    }
}
