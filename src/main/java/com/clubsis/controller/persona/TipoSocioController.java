package com.clubsis.controller.persona;

import com.clubsis.model.persona.TipoSocio;
import com.clubsis.service.ServicioMembresias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Juan Tenorio on 31/5/2016.
 */
@RestController
@RequestMapping("/api/tiposocios")
public class TipoSocioController {
    @Autowired
    private ServicioMembresias servicioMembresias;

    @RequestMapping(method = RequestMethod.GET)
    public List<TipoSocio> list(){return servicioMembresias.mostrarTiposSocios();}

    @RequestMapping(method = RequestMethod.POST)
    public TipoSocio create(@RequestBody TipoSocio tipoSocio){return servicioMembresias.crearTipoSocio(tipoSocio);}

    @RequestMapping(value="/{id}",method=RequestMethod.GET)
    public TipoSocio find(@PathVariable Integer id){return servicioMembresias.buscarTipoSocio(id);}


    @RequestMapping(value="/{id}",method = RequestMethod.PUT)
    public TipoSocio update(@PathVariable  Integer id,@RequestBody  TipoSocio tipoSocio){return servicioMembresias.actualizarTipoSocio(id,tipoSocio);}
}
