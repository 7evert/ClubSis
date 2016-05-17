package com.clubsis.controller.evento;

import com.clubsis.service.ServicioEventos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
/**
 * Created by Juan Tenorio on 17/5/2016.
 */
@RestController
@RequestMapping("/api/tarifaevento")
public class TarifaEventoController {

    @Autowired
    private ServicioEventos servicioEvento;
}
