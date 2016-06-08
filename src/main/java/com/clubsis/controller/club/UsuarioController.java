package com.clubsis.controller.club;

import com.clubsis.model.club.Usuario;
import com.clubsis.model.club.UsuarioDTO;
import com.clubsis.model.persona.Persona;
import com.clubsis.model.sede.Sede;
import com.clubsis.service.ServicioMembresias;
import com.clubsis.service.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Sebastian on 07-Jun-16.
 */

@RestController
@RequestMapping(value = "/api/usuarios")
public class UsuarioController {

    @Autowired
    private ServicioUsuario servicioUsuario;

    @Autowired
    private ServicioMembresias servicioMembresias;

    @RequestMapping(method = RequestMethod.GET)
    public List<Usuario> list() {
        return servicioUsuario.mostrarUsuarios();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void crearUsuarioDesdeDTO(@RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setContraseña(usuarioDTO.getContraseña());
        usuario.setNombreUsuario(usuarioDTO.getNombreUsuario());
        usuario.setEsActivo(usuarioDTO.getEsActivo());
        //usuario.setRol(usuarioDTO.getRol());
        Persona persona = new Persona();
        persona.setTipoDoc(usuarioDTO.getTipoDoc());
        persona.setNumDoc(usuarioDTO.getNumDoc());
        persona.setApellidoMaterno(usuarioDTO.getApellidoMaterno());
        persona.setApellidoPaterno(usuarioDTO.getApellidoPaterno());
        persona.setCorreo(usuarioDTO.getCorreo());
        persona.setDireccion(usuarioDTO.getDireccion());
        persona.setEsTitular(usuarioDTO.getEsTitular());
        persona.setFechaNacimiento(usuarioDTO.getFechaNacimiento());
        persona.setNombre(usuarioDTO.getNombre());
        persona.setTelefono(usuarioDTO.getTelefono());

        usuario.setPersona(persona);

        servicioMembresias.crearPersona(persona);
        servicioUsuario.crearUsuario(usuario);
    }

    @RequestMapping(value = "{idUsuario}/listaSedes", method = RequestMethod.POST)
    public void crearListaSedes(@PathVariable Integer idUsuario, @RequestBody Set<Sede> sedes) {
        Usuario usuario = servicioUsuario.buscarUsuario(idUsuario);
        usuario.getSedes().addAll(sedes);
        servicioUsuario.crearUsuario(usuario);
    }
}
