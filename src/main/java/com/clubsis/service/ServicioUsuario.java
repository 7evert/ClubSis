package com.clubsis.service;

/**
 * Created by MAYRA on 05/06/2016.
 */
import com.clubsis.model.club.Usuario;
import com.clubsis.model.sede.Sede;
import com.clubsis.repository.club.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ServicioUsuario {

    private static Logger logger = LoggerFactory.getLogger(ServicioUsuario.class);

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> mostrarUsuarios(){
        return usuarioRepository.findAll().stream().filter(usuario -> usuario.getEsActivo()).collect(Collectors.toList());
    }
    public Usuario buscarUsuario(Integer id) {return usuarioRepository.findOne(id);}
    public Usuario crearUsuario(Usuario usuario) {return usuarioRepository.saveAndFlush(usuario);}

    public Usuario actualizarUsuario(Integer id, Usuario usuario){
        Usuario usuarioExistente = usuarioRepository.findOne(id);
        BeanUtils.copyProperties(usuario,usuarioExistente);
        return usuarioRepository.saveAndFlush(usuarioExistente);
    }

    public void crearListaSedes(@PathVariable Integer idUsuario, @RequestBody Set<Sede> sedes) {
        Usuario usuario = usuarioRepository.findOne(idUsuario);
        usuario.getSedes().addAll(sedes);
        usuarioRepository.saveAndFlush(usuario);
    }
}
