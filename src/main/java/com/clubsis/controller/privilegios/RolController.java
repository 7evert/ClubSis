package com.clubsis.controller.privilegios;

import com.clubsis.model.persona.Socio;
import com.clubsis.model.privilegio.Permiso;
import com.clubsis.model.privilegio.Rol;
import com.clubsis.service.ServicioRol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Lati on 24.05.2016.
 */

@RestController
@RequestMapping("api/rols")
public class RolController {
    @Autowired
    ServicioRol servicioRol;



    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Rol get(@PathVariable Integer id){
        return servicioRol.buscarRol(id);
    }


    @RequestMapping(method = RequestMethod.POST)
    public Rol create(@RequestBody Rol rol) {

        //validating that there is no duplicate course
        //if(servicioRol.buscarRol(rol.getIdRol()) == null)
             return servicioRol.crearRol(rol);
       // else
       //     return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Rol update(@PathVariable Integer id, @RequestBody Rol rol){
        return servicioRol.actualizarRol(id,rol);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Rol> list() {
        return servicioRol.mostrarRols();
    }

    @RequestMapping(value = "/{rolId}/crearPerm", method = RequestMethod.POST)
    public Permiso createPermision(@PathVariable Integer rolId, @RequestBody Permiso permiso){
        permiso.setRol(servicioRol.buscarRol(rolId));
        return servicioRol.creaerPermisio(permiso);
    }

    @RequestMapping(value = "/getPerm/{permId}", method = RequestMethod.GET)
    public Permiso getPermisionByID(@PathVariable Integer permId){
        return servicioRol.buscarPermisio(permId);
    }


    @RequestMapping(value = "/updatePerm/{id}", method = RequestMethod.PUT)
    public Permiso update(@PathVariable Integer id, @RequestBody Permiso permiso){
        return servicioRol.actualizarPermisio(id,permiso);
    }

    //Getting all Permissions of a Role by Rol ID
    @RequestMapping(value = "/getPerm/{rolId}", method = RequestMethod.GET)
    public List<Permiso> permisionList(@PathVariable Integer rolId) {
        return servicioRol.mostarPermisio(servicioRol.buscarRol(rolId));
    }
}
