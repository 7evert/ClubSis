package com.clubsis.controller.pago;

import com.clubsis.model.pago.Pago;
import com.clubsis.model.pago.TipoPago;
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
    ServicioPagos servicioPagos;

    @RequestMapping(method = RequestMethod.GET)
    public List<Pago> list() {return servicioPagos.mostrarPagos();}

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Pago get(@PathVariable Integer id) {
        return servicioPagos.buscarPago(id);
    }

    /*@RequestMapping(method = RequestMethod.POST)
    public Pago create(@RequestBody Pago pago){
        return servicioPagos.crearPago(1,1, TipoPago.INSTALACION,100.0);
        //SE USO PARA PROBAR EL SERVICIO
    }*/

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Pago update(@PathVariable Integer id, @RequestBody Pago pago){
        return servicioPagos.actualizarPago(id,pago);
    }

    @RequestMapping(value = "/{id}/anular", method = RequestMethod.POST)
    public Pago anularPago(@PathVariable Integer id){
        return servicioPagos.anularPago(id);
    }

    @RequestMapping(value = "/{id}/pagar", method = RequestMethod.POST)
    public Pago realizarPago(@PathVariable Integer id){
        return servicioPagos.realizarPago(id);
    }

    @RequestMapping(value ="/{id}/{valoracion}",method=RequestMethod.POST)
    public Pago calificarServicio(@PathVariable Integer id, @PathVariable Integer valoracion){
        return servicioPagos.agregarValoracion(id,valoracion);
    }
}
