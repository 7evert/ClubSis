package com.clubsis.controller.clase;

import com.clubsis.model.clase.Horario;
import com.clubsis.service.ServicioClases;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Vivian on 23/05/2016.
 */
@RestController
@RequestMapping("/api/horarios")
public class HorarioController {
    @Autowired
    private ServicioClases servicioClases;

    @RequestMapping(method = RequestMethod.GET)
    public List<Horario> list() {
        return servicioClases.mostrarHorarios();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Horario get(@PathVariable Integer id) {
        return servicioClases.buscarHorario(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Horario create(@RequestBody Horario horario) {
        return servicioClases.crearHorario(horario);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Horario update(@PathVariable Integer id, @RequestBody Horario horario) {
        return servicioClases.actualizarHorario(id, horario);
    }
}
