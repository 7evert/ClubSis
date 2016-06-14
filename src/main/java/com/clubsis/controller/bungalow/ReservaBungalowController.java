package com.clubsis.controller.bungalow;

import com.clubsis.model.bungalow.Bungalow;
import com.clubsis.model.bungalow.EstadoBungalow;
import com.clubsis.model.bungalow.EstadoReservaBungalow;
import com.clubsis.model.bungalow.ReservaBungalow;
import com.clubsis.model.pago.TipoPago;
import com.clubsis.model.persona.Postulante;
import com.clubsis.service.ServicioBungalow;
import com.clubsis.service.ServicioPagos;
import com.clubsis.service.ServicioReservas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Sebastian on 02-May-16.
 */

@RestController
@RequestMapping("/api/reservasbungalow")
public class ReservaBungalowController {
    @Autowired
    private ServicioReservas servicioReservas;

    @Autowired
    private ServicioPagos servicioPagos;

    @RequestMapping(method = RequestMethod.GET)
    public List<ReservaBungalow> list() {
        return servicioReservas.mostrarReservasBungalow();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ReservaBungalow get(@PathVariable Integer id) {
        // TODO: retornar un bungalow (llamar a un solo método del servicio que haga esto)
        return null;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ReservaBungalow create(@RequestBody ReservaBungalow reservaBungalow) {
        ReservaBungalow reservaBungalowData = servicioReservas.crearReservaBungalow(reservaBungalow);
        servicioPagos.crearPago(reservaBungalowData.getSocio().getId(), reservaBungalowData.getId(), TipoPago.BUNGALOW,reservaBungalowData.getBungalow().getPrecio());
        return reservaBungalowData;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ReservaBungalow update(@PathVariable Integer id, @RequestBody ReservaBungalow bungalow) {
        // TODO: actualizar un bungalow (llamar a un solo método del servicio que haga esto)
        return null;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ReservaBungalow delete(@PathVariable Integer id) {
        // TODO: eliminar un bungalow (llamar a un solo método del servicio que haga esto)
        return null;
    }

    @RequestMapping(value = "/eliminar", method = RequestMethod.POST)
    public Integer editarReservaBungalow(Model model, @RequestParam(value = "idReservaBungalow") Integer idReservaBungalow) {
        ReservaBungalow reservaBungalow = servicioReservas.buscarReservaBungalow(idReservaBungalow);
        reservaBungalow.setEstado(EstadoReservaBungalow.CANCELADA);
        Bungalow bungalow = reservaBungalow.getBungalow();
        bungalow.setEstado(EstadoBungalow.HABILITADO);
        servicioReservas.actualizarBungalow(bungalow.getId(),bungalow);
        servicioReservas.actualizarReservaBungalow(idReservaBungalow,reservaBungalow);
        return 1;
    }

    @RequestMapping(value = "/facturar", method = RequestMethod.POST)
    public Integer registrarIngresoReservaBungalow(Model model, @RequestParam(value = "idReservaBungalow") Integer idReservaBungalow) {
        ReservaBungalow reservaBungalow = servicioReservas.buscarReservaBungalow(idReservaBungalow);
        reservaBungalow.setEstado(EstadoReservaBungalow.FACTURADA);
        Bungalow bungalow = reservaBungalow.getBungalow();
        bungalow.setEstado(EstadoBungalow.INHABILITADO);
        servicioReservas.actualizarBungalow(bungalow.getId(),bungalow);
        servicioReservas.actualizarReservaBungalow(idReservaBungalow,reservaBungalow);
        return 1;
    }

    @RequestMapping(value = "/getEstadoReservaBungalow",method = RequestMethod.GET)
    public EstadoReservaBungalow[] getEstadoBungalow(){
        return servicioReservas.getEstadoReservaBungalow();
    }
}
