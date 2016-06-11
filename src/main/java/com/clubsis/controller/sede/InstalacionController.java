package com.clubsis.controller.sede;


import com.clubsis.model.sede.EstadoInstalacion;
import com.clubsis.model.sede.Instalacion;
import com.clubsis.service.ServicioInstalacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
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

    @RequestMapping(value="/getHabilitados",method = RequestMethod.GET)
    public List<Instalacion> listFiltrados() {
        return servicioInstalacion.mostrarInstalacionesHabilitadas();
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
    @RequestMapping(value = "/eliminar", method = RequestMethod.POST)
    public Integer eliminarInstalacion(Model model, @RequestParam(value = "id") Integer idInstalacion) {
        Instalacion instalacion = servicioInstalacion.buscarInstalaciones(idInstalacion);
        instalacion.setEstado(EstadoInstalacion.Inhabilitado);
        servicioInstalacion.actualizarInstalacion(idInstalacion,instalacion);
        return 1;
    }
    @RequestMapping(value = "/habilitar", method = RequestMethod.POST)
    public Integer habilitarInstalacion(Model model, @RequestParam(value = "id") Integer idInstalacion) {
        Instalacion instalacion = servicioInstalacion.buscarInstalaciones(idInstalacion);
        instalacion.setEstado(EstadoInstalacion.Habilitado);
        servicioInstalacion.actualizarInstalacion(idInstalacion,instalacion);
        return 1;
    }
    @RequestMapping(value = "/inhabilitar", method = RequestMethod.POST)
    public Integer inhabilitarInstalacion(Model model, @RequestParam(value = "id") Integer idInstalacion) {
        Instalacion instalacion = servicioInstalacion.buscarInstalaciones(idInstalacion);
        instalacion.setEstado(EstadoInstalacion.Inhabilitado);
        servicioInstalacion.actualizarInstalacion(idInstalacion,instalacion);
        return 1;
    }

    @RequestMapping(value = "/getEstadoInstalacion", method = RequestMethod.GET)
    public EstadoInstalacion[] getEstadoInstalacion() {
        return servicioInstalacion.getEstadoInstalacion();
    }


}
