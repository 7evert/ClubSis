package com.clubsis.controller.persona;

import com.clubsis.service.ServicioMembresias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Juan Tenorio on 17/5/2016.
 */
@RestController
@RequestMapping("/api/personas")
public class PersonaController {
    @Autowired
    private ServicioMembresias servicioMembresias;
}
