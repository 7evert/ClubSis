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

import javax.validation.Valid;
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


    /*@RequestMapping(value="/{idSede}/{id}/eventos",method = RequestMethod.POST)
    public Evento agregarEvento(@PathVariable Integer idSede, @PathVariable Integer id, @Valid @RequestBody Evento eventos, @RequestHeader(value="precio") String precioStr, @RequestHeader(value="vez") String vez){
        double precio= Double.parseDouble(precioStr);
        int controlador = Integer.parseInt(vez);
        //Tarifa tarifa= servicioTarifas.buscarTarifa(id);
        //Sede sede = servicioSede.buscarSede(idSede);
        //eventos.setSede(sede);
        //TarifaEvento tarifaxEventos = new TarifaEvento(precio,eventos,tarifa);
        //tarifaxEventos.setEventos(eventos);
        //tarifaxEventos.setTarifaeventos(tarifa);
        return servicioEvento.crearEvento(eventos);
        //if(controlador ==1) servicioEvento.crearEvento(eventos);
        //return servicioTarifaxEventos.crearTarifaEventos(tarifaxEventos);
    }*/
}
