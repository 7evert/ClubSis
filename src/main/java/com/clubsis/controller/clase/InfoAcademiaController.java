package com.clubsis.controller.clase;

import com.clubsis.model.clase.Clase;
import com.clubsis.service.ServicioClases;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Vivian on 27/05/2016.
 */
@RestController
@RequestMapping("/api/infoAcademia")
public class InfoAcademiaController {
    @Autowired
    private ServicioClases servicioClases;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public List<Clase> get(@PathVariable Integer id) {
        //return servicioClases.buscarAcademia(id);
        return servicioClases.mostrarClasesCiclo(id);
    }

}
