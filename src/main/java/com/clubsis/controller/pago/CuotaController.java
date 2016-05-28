package com.clubsis.controller.pago;

import com.clubsis.model.pago.Cuota;
import com.clubsis.service.ServicioPagos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Blitz on 25/05/2016.
 */
@RestController
@RequestMapping("/api/cuotas")
public class CuotaController {
    @Autowired
    private ServicioPagos servicioPagos;

    @RequestMapping(method = RequestMethod.GET)
    public List<Cuota> list() {return servicioPagos.mostrarCuotas();}

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Cuota get(@PathVariable Integer id) {
        return servicioPagos.buscarCuota(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Cuota create(@RequestBody Cuota cuota){
        return servicioPagos.crearCuota(cuota);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Cuota update(@PathVariable Integer id, @RequestBody Cuota cuota){
        return servicioPagos.actualizarCuota(id,cuota);
    }

}
