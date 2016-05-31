package com.clubsis.controller.pago;

import com.clubsis.model.pago.CuotaExtraordinaria;
import com.clubsis.service.ServicioPagos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Blitz on 25/05/2016.
 */
@RestController
@RequestMapping("/api/cuotasExtraordinarias")
public class CuotaExtraordinariaController {
    @Autowired
    private ServicioPagos servicioPagos;

    @RequestMapping(method = RequestMethod.GET)
    public List<CuotaExtraordinaria> list() {return servicioPagos.mostrarCuotasExtraordinarias();}

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public CuotaExtraordinaria get(@PathVariable Integer id) {
        return servicioPagos.buscarCuotaExtraordinaria(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public List<CuotaExtraordinaria> create(@RequestBody CuotaExtraordinaria cuota){
        return servicioPagos.crearCuotasExtraordinarias(cuota);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public CuotaExtraordinaria update(@PathVariable Integer id, @RequestBody CuotaExtraordinaria cuota){
        return servicioPagos.actualizarCuotaExtraordinaria(id,cuota);
    }

}
