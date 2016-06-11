package com.clubsis.controller.club;

import com.clubsis.model.club.Multa;
import com.clubsis.model.pago.Pago;
import com.clubsis.model.pago.TipoCliente;
import com.clubsis.model.pago.TipoPago;
import com.clubsis.service.ServicioMultas;
import com.clubsis.service.ServicioPagos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Blitz on 02/06/2016.
 */
@RestController
@RequestMapping("/api/multas")
public class MultaController{
    @Autowired
    ServicioMultas servicioMultas;
    @Autowired
    ServicioPagos servicioPagos;


    @RequestMapping(method = RequestMethod.GET)
    public List<Multa> list() {return servicioMultas.mostrarMultas();}

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Multa get(@PathVariable Integer id) {
        return servicioMultas.buscarMulta(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Multa create(@RequestBody Multa multa){
        return servicioMultas.crearMulta(multa);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Multa update(@PathVariable Integer id, @RequestBody Multa multa){
        return servicioMultas.actualizarMulta(id,multa);
    }

    @RequestMapping(value="/{idSocio}/{idMulta}" ,method = RequestMethod.POST)
    public Pago crearPago(@PathVariable Integer idSocio, @PathVariable Integer idMulta){
        Multa multa =servicioMultas.buscarMulta(idMulta);
        return servicioPagos.crearPago(idSocio, TipoCliente.SOCIO,idMulta, TipoPago.MULTA,multa.getCosto());
    }

}
