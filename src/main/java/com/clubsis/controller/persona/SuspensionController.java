package com.clubsis.controller.persona;

import com.clubsis.model.persona.Suspension;
import com.clubsis.service.ServicioMembresias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Juan Tenorio on 17/5/2016.
 */
@RestController
@RequestMapping("/api/suspension")
public class SuspensionController {
    @Autowired
    private ServicioMembresias servicioMembresias;

    @RequestMapping(method = RequestMethod.POST)
    public Suspension create(@RequestBody Suspension suspension){
        return null;
    }

}
