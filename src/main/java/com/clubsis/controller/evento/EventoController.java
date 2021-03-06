package com.clubsis.controller.evento;

import com.clubsis.model.evento.EstadoEvento;
import com.clubsis.model.evento.Evento;
import com.clubsis.model.pago.TipoPago;
import com.clubsis.model.sede.Sede;
import com.clubsis.service.ServicioPagos;
import com.clubsis.service.ServicioSedes;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.*;
        import com.clubsis.model.sede.Sede;
        import com.clubsis.service.ServicioSedes;
        import com.clubsis.service.ServicioEventos;
        import java.util.List;

/**
 * Created by Juan Tenorio on 17/5/2016.
 */
@RestController
@RequestMapping("/api/eventos")
public class EventoController {

    @Autowired
    private ServicioEventos servicioEvento;
    @Autowired
    private ServicioSedes servicioSede;
    @Autowired
    private ServicioPagos servicioPagos;
    @RequestMapping(method=RequestMethod.GET)
    List<Evento>  list() { return servicioEvento.mostrarEventos();}

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Evento get(@PathVariable Integer id) {
        return servicioEvento.buscarEvento(id);
    }

    @RequestMapping(value = "/{idSede}", method = RequestMethod.POST)
    public Evento create(@PathVariable Integer idSede,@RequestBody Evento evento) {
        Sede sede = servicioSede.buscarSede(idSede);
        evento.setSede(sede);
        return servicioEvento.crearEvento(evento);
    }

    @RequestMapping(value="/{idEvento}/actualizar",method=RequestMethod.POST)
    public Evento actualizarEstado(@PathVariable Integer idEvento){
        Evento evento= servicioEvento.buscarEvento(idEvento);
        evento.setEstado(EstadoEvento.INHABILITADO);
        return servicioEvento.actualizarEvento(idEvento,evento);
    }
/*
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public Evento agregarEvento(@PathVariable Integer id, @RequestBody Evento evento){
        Sede sede = servicioSede.buscarSede(id);
        evento.setSede(sede);
        return servicioEvento.crearEvento(evento);//return null;
    }*/
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Evento update(@PathVariable Integer id, @RequestBody Evento evento) {
        return servicioEvento.actualizarEvento(id, evento);
    }

    @RequestMapping(value="/{idSocio}/{idEvento}/costo",method = RequestMethod.POST)
    public Double costo(@PathVariable Integer idSocio,@PathVariable Integer idEvento){
        Double monto = servicioEvento.PagoEvento(idEvento,idSocio);
        servicioPagos.crearPago(idSocio,idEvento, TipoPago.EVENTO,monto);
        return monto;
    }

}
