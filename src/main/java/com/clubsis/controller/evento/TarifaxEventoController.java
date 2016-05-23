package com.clubsis.controller.evento;

import com.clubsis.model.evento.Evento;
import com.clubsis.model.evento.Tarifa;
import com.clubsis.model.evento.TarifaEvento;
import com.clubsis.model.sede.Sede;
import com.clubsis.service.ServicioEventos;
import com.clubsis.service.ServicioSedes;
import com.clubsis.service.ServicioTarifas;
import com.clubsis.service.ServicioTarifaEventos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Juan Tenorio on 22/5/2016.
 */
@RestController
@RequestMapping("/api/tarifaeventos")
public class TarifaxEventoController {

    @Autowired
    private ServicioTarifas servicioTarifas;
    @Autowired
    private ServicioEventos servicioEvento;
    @Autowired
    private ServicioSedes servicioSede;
    @Autowired
    private ServicioTarifaEventos servicioTarifaxEventos;

    @RequestMapping(method = RequestMethod.GET)
    List<TarifaEvento> list() { return servicioTarifaxEventos.mostrarTarifasEventos();}

    @RequestMapping(method = RequestMethod.POST)
    public TarifaEvento create(@RequestBody TarifaEvento tarifa) { return servicioTarifaxEventos.crearTarifaEventos(tarifa);}

    @RequestMapping(value="/{idSede}/{id}/eventos",method = RequestMethod.POST)
    public TarifaEvento agregarEvento(@PathVariable Integer idSede, @PathVariable Integer id, @RequestBody Evento evento, @RequestHeader(value="precio") String precioStr){
        double precio= Double.parseDouble(precioStr);
        Tarifa tarifa= servicioTarifas.buscarTarifa(id);
        Sede sede = servicioSede.buscarSede(idSede);
        evento.setSede(sede);
        TarifaEvento tarifaxEventos = new TarifaEvento(precio,evento,tarifa);
        tarifaxEventos.setEventos(evento);
        tarifaxEventos.setTarifaeventos(tarifa);
        servicioEvento.crearEvento(evento);
        return servicioTarifaxEventos.crearTarifaEventos(tarifaxEventos);
    }
}
