package com.clubsis.controller.clase;

import com.clubsis.model.clase.Horario;
import com.clubsis.service.ServicioClases;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Vivian on 31/05/2016.
 */
@RestController
@RequestMapping("/api/infoClase")
public class InfoClaseController {
    @Autowired
    private ServicioClases servicioClases;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public List<Horario> get(@PathVariable Integer id) {
        return servicioClases.mostrarHorariosClase(id);
    }
}
