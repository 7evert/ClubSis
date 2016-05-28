package com.clubsis.controller.pago;

import com.clubsis.model.pago.Pago;
import com.clubsis.service.ServicioPagos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Blitz on 25/05/2016.
 */
@RestController
@RequestMapping("/api/pagos")
public class PagoController {
    @Autowired
    private ServicioPagos servicioPagos;

    @RequestMapping(method = RequestMethod.GET)
    public List<Pago> list() {return servicioPagos.mostrarPagos();}

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Pago get(@PathVariable Integer id) {
        return servicioPagos.buscarPago(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Pago create(@RequestBody Pago pago){
        return servicioPagos.crearPago(pago);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Pago update(@PathVariable Integer id, @RequestBody Pago pago){
        return servicioPagos.actualizarPago(id,pago);
    }

}
