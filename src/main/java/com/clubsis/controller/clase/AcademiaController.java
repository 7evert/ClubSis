package com.clubsis.controller.clase;

import com.clubsis.model.clase.Academia;
import com.clubsis.service.ServicioClases;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Vivian on 23/05/2016.
 */

@RestController
@RequestMapping("/api/academias")
public class AcademiaController {

    @Autowired
    private ServicioClases servicioClases;

    @RequestMapping(method = RequestMethod.GET)
    public List<Academia> list() {
        return servicioClases.mostrarAcademias();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Academia get(@PathVariable Integer id) {
        return servicioClases.buscarAcademia(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Academia create(@RequestBody Academia academia) {
        return servicioClases.crearAcademia(academia);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Academia update(@PathVariable Integer id, @RequestBody Academia academia) {
        return servicioClases.actualizarAcademia(id, academia);
    }
}
