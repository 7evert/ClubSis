package com.clubsis.controller.pago;

import com.clubsis.model.pago.PagoMembresia;
import com.clubsis.service.ServicioPagos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Blitz on 25/05/2016.
 */
@RestController
@RequestMapping("/api/pagosMembresias")
public class PagoMembresiaController {
    @Autowired
    private ServicioPagos servicioPagos;

    @RequestMapping(method = RequestMethod.GET)
    public List<PagoMembresia> list() {return servicioPagos.mostrarPagosMembresia();}

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public PagoMembresia get(@PathVariable Integer id) {
        return servicioPagos.buscarPagoMembresia(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public PagoMembresia create(@RequestBody PagoMembresia pago){
        return servicioPagos.crearPagoMembresia(pago);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public PagoMembresia update(@PathVariable Integer id, @RequestBody PagoMembresia pago){
        return servicioPagos.actualizarPagoMembresia(id,pago);
    }

}
