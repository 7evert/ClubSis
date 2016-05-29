package com.clubsis.controller.evento;

import com.clubsis.model.evento.Evento;
import com.clubsis.model.evento.Tarifa;
import com.clubsis.model.evento.TarifaEvento;
import com.clubsis.model.sede.Sede;
import com.clubsis.service.ServicioEventos;
import com.clubsis.service.ServicioSedes;
import com.clubsis.service.ServicioTarifas;
import com.clubsis.service.ServicioTarifaEventos;
import org.omg.CORBA.Request;
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
        return servicioTarifaxEventos.crearTarifaEventos(tarifaxEventos);
    }

    // id1: tarifa, id2: evento
    @RequestMapping(value="/{id1}/{id2}/eventos",method = RequestMethod.POST)
    public TarifaEvento agregarTarifaEventos1(@PathVariable Integer id1, @PathVariable Integer id2,@Valid @RequestBody TarifaEvento tarifaxEventos){
        Tarifa tarifa= servicioTarifas.buscarTarifa(id1);
        Evento evento=servicioEvento.buscarEvento(id2);
        double precio=tarifaxEventos.getPrecio();
        TarifaEvento tarifaxEventos1 = new TarifaEvento(precio,evento,tarifa);
        return servicioTarifaxEventos.crearTarifaEventos(tarifaxEventos1);
    }

    @RequestMapping(value="/{id}/actualizar",method = RequestMethod.PUT)
    public TarifaEvento update(@PathVariable Integer id, @RequestBody TarifaEvento tarifaevento) {
        return servicioTarifaxEventos.actualizarTarifaEventos(id, tarifaevento);
    }

    @RequestMapping(value="/{id}/eliminar",method= RequestMethod.DELETE)
    public void delete(@PathVariable Integer id){
       servicioTarifaxEventos.eliminarTarifaEvento(id);
    }

}
