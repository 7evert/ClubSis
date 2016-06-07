package com.clubsis.controller.club;

import com.clubsis.model.club.Usuario;
import com.clubsis.model.club.UsuarioDTO;
import com.clubsis.model.persona.Persona;
import com.clubsis.service.ServicioMembresias;
import com.clubsis.service.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
        usuario.setDni(usuarioDTO.getDni());
        usuario.setContraseña(usuarioDTO.getContraseña());
        usuario.setNombreUsuario(usuarioDTO.getNombreUsuario());
        Persona persona = new Persona();
        persona.setDni(usuarioDTO.getDni());
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
}
