package com.clubsis.controller.persona;

import com.clubsis.model.pago.Pago;
import com.clubsis.model.persona.Socio;
import com.clubsis.service.ServicioMembresias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Blitz on 20/05/2016.
 */
@RestController
@RequestMapping("/api/socios")
public class SocioController {
    @Autowired
    private ServicioMembresias servicioMembresias;

    @RequestMapping(method = RequestMethod.GET)
    public List<Socio> list() {
        return servicioMembresias.mostrarSocios();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Socio get(@PathVariable Integer id) {
        return servicioMembresias.buscarSocio(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Socio create(@RequestBody Socio socio) {
        return servicioMembresias.crearSocio(socio);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Socio update(@PathVariable Integer id, @RequestBody Socio socio){
        return servicioMembresias.actualizarSocio(id,socio);
    }
    @RequestMapping(value = "/{id}/pagos", method = RequestMethod.GET)
    public List<Pago> mostrarPagos(@PathVariable Integer id) {
        return new ArrayList<>(servicioMembresias.buscarSocio(id).getPagos());
    }
}
