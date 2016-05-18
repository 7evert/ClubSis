package com.clubsis.controller.persona;

import com.clubsis.service.ServicioPersonas;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Juan Tenorio on 17/5/2016.
 */
@RestController
@RequestMapping("/api/persona")
public class PersonaController {
    private ServicioPersonas servicioPersona;
}
