package com.clubsis.service;

/**
 * Created by MAYRA on 05/06/2016.
 */
import com.clubsis.model.club.Usuario;
import com.clubsis.repository.club.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicioUsuario {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> mostrarUsuarios(){
        List<Usuario> usuarios=usuarioRepository.findAll();
        List<Usuario> usuariosFiltrados = new ArrayList<Usuario>();
        for(Usuario usuario : usuarios){
            if(usuario.getEsActivo())
                usuariosFiltrados.add(usuario);
        }
        return usuariosFiltrados;
    }
    public Usuario buscarUsuarios(Integer id) {return usuarioRepository.findOne(id);}
    public Usuario crearUsuario(Usuario usuario) {return usuarioRepository.saveAndFlush(usuario);}

    public Usuario actualizarUsuario(Integer id, Usuario usuario){
        Usuario usuarioExistente = usuarioRepository.findOne(id);
        BeanUtils.copyProperties(usuario,usuarioExistente);
        return usuarioRepository.saveAndFlush(usuarioExistente);

    }
}
