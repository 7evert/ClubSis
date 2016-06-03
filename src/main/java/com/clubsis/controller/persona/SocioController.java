package com.clubsis.controller.persona;

import com.clubsis.model.pago.Pago;
import com.clubsis.model.persona.*;
import com.clubsis.model.persona.Persona;
import com.clubsis.model.persona.Socio;
import com.clubsis.model.persona.Suspension;
import com.clubsis.service.ServicioMembresias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Blitz on 20/05/2016.
 */
@RestController
@RequestMapping("/api/socios")
public class SocioController {
    @Autowired
    private ServicioMembresias servicioMembresias;

    @RequestMapping(method = RequestMethod.GET)
    public List<Socio> list() {
        return servicioMembresias.mostrarSocios();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Socio get(@PathVariable Integer id) {
        return servicioMembresias.buscarSocio(id);
    }

    @RequestMapping(value="/{idTipo}/crear",method = RequestMethod.POST)
    public Socio create(@PathVariable Integer idTipo,@RequestBody Socio socio) {
        TipoSocio tipoSocio = servicioMembresias.buscarTipoSocio(idTipo);
        socio.setTipo(tipoSocio);
        return servicioMembresias.crearSocio(socio);
    }

    /*ahora?*/
    @RequestMapping(value = "/{id}/{idTipo}/actualizar", method = RequestMethod.POST)
    public Socio update(@PathVariable Integer id,@PathVariable Integer idTipo, @RequestBody Socio socio){
        return servicioMembresias.actualizarSocio(id,idTipo,socio);
    }

    @RequestMapping(value="/{id}/inhabilitar",method = RequestMethod.PUT)
    public Socio updateEstado(@PathVariable Integer id, @RequestBody Socio socio){
        Socio socioExistente = servicioMembresias.buscarSocio(id);
        socio.setTipo(socioExistente.getTipo());
        socio.setEstado(EstadoSocio.SUSPENDIDO);
        socio.setCodigoCarnet(socioExistente.getCodigoCarnet());
        socio.setInvitados(socioExistente.getInvitados());
        socio.setFechaInscripcion(socioExistente.getFechaInscripcion());
        return servicioMembresias.actualizarSocio(id,socio.getTipo().getId(),socio);
    }
    @RequestMapping(value = "/{id}/pagos", method = RequestMethod.GET)
    public List<Pago> mostrarPagos(@PathVariable Integer id) {
        return new ArrayList<>(servicioMembresias.buscarSocio(id).getPagos());
    }

    @RequestMapping(value = "/{id}/suspensiones", method = RequestMethod.GET)
    public List<Suspension> mostrarSuspensiones(@PathVariable Integer id) {
        return new ArrayList<>(servicioMembresias.buscarSocio(id).getSuspensiones());
    }

    @RequestMapping(value = "/{id}/persona", method = RequestMethod.GET)
    public Persona mostrarNombrePersona(@PathVariable Integer id) {
        List<Persona> personas = new ArrayList<>(servicioMembresias.buscarSocio(id).getPersonas());
        return personas.get(0);
    }

    @RequestMapping(value = "/{id}/socioPrincipal", method = RequestMethod.GET)
    public Persona mostrarSocioPrincipal(@PathVariable Integer id) {
        return servicioMembresias.obtenerSocioPrincipal(id);
    }

    @RequestMapping(value="/{idSocio}/personas",method = RequestMethod.GET)
    public List<Persona> mostrarPersonas(@PathVariable Integer idSocio){
        List<Persona> personas = new ArrayList<>(servicioMembresias.buscarSocio(idSocio).getPersonas());
        return personas;
    }

    @RequestMapping(value="/{idSocio}/personaasociada",method = RequestMethod.GET)
    public Persona mostrarPersonaAsociada(@PathVariable Integer idSocio){
        List<Persona> personas = new ArrayList<>(servicioMembresias.buscarSocio(idSocio).getPersonas());
        for (int i=0;i<personas.size();i++){
            if(personas.get(i).getEsTitular() == true){
                return personas.get(i);
            }
        }
        //por defecto va a mandar a la ultima persona, aunque nunca debería llegar aquí
        return personas.get(personas.size()-1);
    }


}
