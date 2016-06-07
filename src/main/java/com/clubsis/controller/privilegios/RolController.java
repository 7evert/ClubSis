package com.clubsis.controller.privilegios;

import com.clubsis.model.privilegio.Permiso;
import com.clubsis.model.privilegio.Rol;
import com.clubsis.service.ServicioRol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Lati on 24.05.2016.
 */

@RestController
@RequestMapping("/api/roles")
public class RolController {
    @Autowired
    private ServicioRol servicioRol;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Rol get(@PathVariable Integer id){
        return servicioRol.buscarRol(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Rol create(@RequestBody Rol rol) {
        return servicioRol.crearRol(rol);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Rol update(@PathVariable Integer id, @RequestBody Rol rol) {
        return servicioRol.actualizarRol(id, rol);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Rol> list() {
        return servicioRol.mostrarRols();
    }


}
