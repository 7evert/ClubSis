package com.clubsis.controller.sede;


import com.clubsis.model.sede.Instalacion;
import com.clubsis.service.ServicioInstalacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by MAYRA on 22/05/2016.
 */
@RestController
@RequestMapping("/api/instalaciones")
public class InstalacionController {

    @Autowired
    private ServicioInstalacion servicioInstalacion;

    @RequestMapping(method = RequestMethod.GET)
        public List<Instalacion> list() {
            return servicioInstalacion.mostrarInstalaciones() ;
        }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Instalacion get(@PathVariable Integer id) {
        return servicioInstalacion.buscarInstalaciones(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Instalacion create(@RequestBody Instalacion instalacion) {
        return servicioInstalacion.crearInstalacion(instalacion);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Instalacion update(@PathVariable Integer id, @RequestBody Instalacion instalacion) {
        return servicioInstalacion.actualizarInstalacion(id, instalacion);
    }


}
