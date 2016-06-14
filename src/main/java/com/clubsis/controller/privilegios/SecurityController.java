package com.clubsis.controller.privilegios;

import com.clubsis.service.ServicioRol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by goldfenrir on 6/13/2016.
 */
@RestController
@RequestMapping("/api/security")
public class SecurityController {
    @Autowired
    ServicioRol servicioRol;

    @RequestMapping(method = RequestMethod.POST)
    public List<Integer> obtenerRol(@RequestBody String cadena){
        return servicioRol.obtenerValores(cadena);
    }
    
}
