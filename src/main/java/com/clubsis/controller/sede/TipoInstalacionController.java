package com.clubsis.controller.sede;

import com.clubsis.model.sede.EstadoInstalacion;
import com.clubsis.model.sede.TipoInstalacion;
import com.clubsis.service.ServicioTipoInstalacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by MAYRA on 02/06/2016.
 */
@RestController
@RequestMapping("/api/tipoInstalaciones")
public class TipoInstalacionController {

    @Autowired
    private ServicioTipoInstalacion servicioTipoInstalacion;

    @RequestMapping(method = RequestMethod.GET)
    public List<TipoInstalacion> list() {
        return servicioTipoInstalacion.mostrarTipoInstalaciones() ;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public TipoInstalacion get(@PathVariable Integer id) {
        return servicioTipoInstalacion.buscarTipoInstalaciones(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public TipoInstalacion create(@RequestBody TipoInstalacion tipoInstalacion) {
        return servicioTipoInstalacion.crearTipoInstalacion(tipoInstalacion);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public TipoInstalacion update(@PathVariable Integer id, @RequestBody TipoInstalacion tipoInstalacion) {
        return servicioTipoInstalacion.actualizarTipoInstalacion(id, tipoInstalacion);
    }
    @RequestMapping(value = "/eliminar", method = RequestMethod.POST)
    public Integer eliminarTipoInstalacion(Model model, @RequestParam(value = "id") Integer idTipoInstalacion) {
        TipoInstalacion tipoInstalacion = servicioTipoInstalacion.buscarTipoInstalaciones(idTipoInstalacion);
        tipoInstalacion.setEstado(EstadoInstalacion.Inhabilitado);
        servicioTipoInstalacion.actualizarTipoInstalacion(idTipoInstalacion,tipoInstalacion);
        return 1;
    }
}
