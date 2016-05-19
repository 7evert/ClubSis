package com.clubsis.controller.persona;

import com.clubsis.service.ServicioMembresias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Blitz on 18/05/2016.
 */
@RestController
@RequestMapping("/api/membresia")
public class MembresiaController {
    @Autowired
    private ServicioMembresias servicioMembresias;

}
