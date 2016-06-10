package com.clubsis.controller.club;

import com.clubsis.model.club.Usuario;
import com.clubsis.model.club.UsuarioDTO;
import com.clubsis.model.persona.Persona;
import com.clubsis.model.sede.Sede;
import com.clubsis.service.ServicioMembresias;
import com.clubsis.service.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
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

    @RequestMapping(method = RequestMethod.GET)
    public List<Usuario> list() {
        return servicioUsuario.mostrarUsuarios();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Usuario get(@PathVariable Integer id){
        return servicioUsuario.buscarUsuario(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void crearUsuarioDesdeDTO(@RequestBody UsuarioDTO usuarioDTO) {
        servicioUsuario.crearUsuarioDesdeDTO(usuarioDTO);
    }

    @RequestMapping(value = "{idUsuario}/listaSedes", method = RequestMethod.POST)
    public void crearListaSedes(@PathVariable Integer idUsuario, @RequestBody Set<Sede> sedes) {
        Usuario usuario = servicioUsuario.buscarUsuario(idUsuario);
        usuario.getSedes().addAll(sedes);
        servicioUsuario.persistirUsuario(usuario);
    }

    @RequestMapping(value = "/{idUsuario}/eliminarLogico", method = RequestMethod.POST)
    public void eliminarUsuario(@PathVariable Integer idUsuario) {
        Usuario usuario = servicioUsuario.buscarUsuario(idUsuario);
        usuario.setEsActivo(false);
        servicioUsuario.persistirUsuario(usuario);
    }
}
