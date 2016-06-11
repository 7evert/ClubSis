package com.clubsis.service;

/**
 * Created by MAYRA on 05/06/2016.
 */
import com.clubsis.model.club.Usuario;
import com.clubsis.model.club.UsuarioDTO;
import com.clubsis.model.persona.Persona;
import com.clubsis.repository.club.UsuarioRepository;
import com.clubsis.repository.persona.PersonaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicioUsuario {

    private static Logger logger = LoggerFactory.getLogger(ServicioUsuario.class);

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PersonaRepository personaRepository;

    public List<Usuario> mostrarUsuarios(){
        return usuarioRepository.findAll().stream().filter(usuario -> usuario.getEsActivo()).collect(Collectors.toList());
    }
    public Usuario buscarUsuario(Integer id) {return usuarioRepository.findOne(id);}
    public Usuario crearUsuario(Usuario usuario) {return usuarioRepository.saveAndFlush(usuario);}
    public Usuario persistirUsuario(Usuario usuario) {return usuarioRepository.saveAndFlush(usuario);}

    public Usuario actualizarUsuario(Integer id, Usuario usuario){
        Usuario usuarioExistente = usuarioRepository.findOne(id);
        BeanUtils.copyProperties(usuario,usuarioExistente);
        return usuarioRepository.saveAndFlush(usuarioExistente);
    }

    public void crearUsuarioDesdeDTO(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setContrasenha(usuarioDTO.getContrasenha());
        usuario.setNombreUsuario(usuarioDTO.getNombreUsuario());
        usuario.setEsActivo(usuarioDTO.getEsActivo());
        usuario.setRol(usuarioDTO.getRol());
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
        persona.setNombreContactoEmergencia(usuarioDTO.getNombreContactoEmergencia());
        persona.setTelefonoContactoEmergencia(usuarioDTO.getTelefonoContactoEmergencia());

        usuario.setPersona(persona);

        personaRepository.saveAndFlush(persona);
        crearUsuario(usuario);

    }

    public void actualizarUsuarioDesdeDTO(Integer id,UsuarioDTO usuarioDTO){
        Usuario usuarioExistente=buscarUsuario(id);
        usuarioExistente.setContrasenha(usuarioDTO.getContrasenha());
        usuarioExistente.setNombreUsuario(usuarioDTO.getNombreUsuario());
        usuarioExistente.setEsActivo(usuarioDTO.getEsActivo());
        usuarioExistente.setRol(usuarioDTO.getRol());

        Persona personaExistente=usuarioExistente.getPersona();
        personaExistente.setTipoDoc(usuarioDTO.getTipoDoc());
        personaExistente.setNumDoc(usuarioDTO.getNumDoc());
        personaExistente.setApellidoMaterno(usuarioDTO.getApellidoMaterno());
        personaExistente.setApellidoPaterno(usuarioDTO.getApellidoPaterno());
        personaExistente.setCorreo(usuarioDTO.getCorreo());
        personaExistente.setDireccion(usuarioDTO.getDireccion());
        personaExistente.setEsTitular(usuarioDTO.getEsTitular());
        personaExistente.setFechaNacimiento(usuarioDTO.getFechaNacimiento());
        personaExistente.setNombre(usuarioDTO.getNombre());
        personaExistente.setTelefono(usuarioDTO.getTelefono());
        personaExistente.setNombreContactoEmergencia(usuarioDTO.getNombreContactoEmergencia());
        personaExistente.setTelefonoContactoEmergencia(usuarioDTO.getTelefonoContactoEmergencia());

        personaRepository.saveAndFlush(personaExistente);
        usuarioRepository.saveAndFlush(usuarioExistente);

    }
}
