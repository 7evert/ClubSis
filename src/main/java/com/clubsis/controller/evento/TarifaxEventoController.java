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

import java.io.*;
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

    @RequestMapping(method = RequestMethod.POST)
    public TarifaEvento agregarTarifaEventos(@Valid @RequestBody TarifaEvento tarifaxEventos){
        System.out.println(" 1 ");
        return servicioTarifaxEventos.crearTarifaEventos(tarifaxEventos);
    }


    @RequestMapping(value="/{id1}/{id2}/eventos",method = RequestMethod.POST)
    public TarifaEvento agregarTarifaEventos1(@PathVariable Integer id1, @PathVariable Integer id2,@Valid @RequestBody TarifaEvento tarifaxEventos){
        Tarifa tarifa= servicioTarifas.buscarTarifa(id1);
        Evento evento=servicioEvento.buscarEvento(id2);
        double precio=tarifaxEventos.getPrecio();
        TarifaEvento tarifaxEventos1 = new TarifaEvento(precio,evento,tarifa);
        return servicioTarifaxEventos.crearTarifaEventos(tarifaxEventos1);
    }

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
