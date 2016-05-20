package com.clubsis.controller.evento;

import com.clubsis.model.evento.Evento;
import com.clubsis.model.evento.TarifaEvento;
import com.clubsis.repository.evento.TarifaEventoRepository;
import com.clubsis.service.ServicioEventos;
import com.clubsis.service.ServicioTarifas;
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
    private ServicioTarifas servicioTarifas;
    @Autowired
    private ServicioEventos servicioEvento;

    @RequestMapping(method=RequestMethod.GET)
    List<TarifaEvento> list() { return servicioTarifas.mostrarTarifas();}

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public TarifaEvento get(@PathVariable Integer id) {return servicioTarifas.buscarTarifa(id);}

    @RequestMapping(method = RequestMethod.POST)
    public TarifaEvento create(@RequestBody TarifaEvento tarifa) { return servicioTarifas.crearTarifa(tarifa);}

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public TarifaEvento update(@PathVariable Integer id, @RequestBody TarifaEvento tarifa) {
        return servicioTarifas.actualizarTarifa(id, tarifa);
    }

    @RequestMapping(value="/{id}/eventos",method = RequestMethod.PUT)
    public Evento agregarEvento(@PathVariable Integer id, @RequestBody Evento evento){
        TarifaEvento tarifa= servicioTarifas.buscarTarifa(id);
        evento.setTarifa(tarifa);
        return servicioEvento.crearEvento(evento);
    }
}
