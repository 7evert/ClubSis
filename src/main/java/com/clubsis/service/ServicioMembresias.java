package com.clubsis.service;

import com.clubsis.model.club.Usuario;
import com.clubsis.model.persona.Persona;
import com.clubsis.model.persona.Postulante;
import com.clubsis.model.persona.Socio;
import com.clubsis.repository.club.UsuarioRepository;
import com.clubsis.repository.persona.PersonaRepository;
import com.clubsis.repository.persona.PostulanteRepository;
import com.clubsis.repository.persona.SocioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Blitz on 18/05/2016.
 */
@Service
public class ServicioMembresias {
    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private PostulanteRepository postulanteRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private SocioRepository socioRepository;

    //Persona
    public List<Persona> mostrarPersonas(){ return personaRepository.findAll(); }
    public Persona buscarPersona(Integer id) {return personaRepository.findOne(id);}
    public Persona crearPersona(Persona persona) {return personaRepository.saveAndFlush(persona);}

    public Persona actualizarPersona(Integer id, Persona persona){
        Persona personaExistente = personaRepository.findOne(id);
        BeanUtils.copyProperties(persona,personaExistente);
        return personaRepository.saveAndFlush(personaExistente);
    }

    //Postulante
    public List<Postulante> mostrarPostulantes(){ return postulanteRepository.findAll(); }
    public Postulante buscarPostulante(Integer id) {return postulanteRepository.findOne(id);}
    public Postulante crearPostulante(Postulante postulante) {return postulanteRepository.saveAndFlush(postulante);}

    public Postulante actualizarPostulante(Integer id, Postulante postulante){
        Postulante postulanteExistente = postulanteRepository.findOne(id);
        BeanUtils.copyProperties(postulante,postulanteExistente);
        return postulanteRepository.saveAndFlush(postulanteExistente);
    }

    //Usuario
    public List<Usuario> mostrarUsuarios(){ return usuarioRepository.findAll(); }
    public Usuario buscarUsuario(Integer id) {return usuarioRepository.findOne(id);}
    public Usuario crearUsuario(Usuario usuario) {return usuarioRepository.saveAndFlush(usuario);}

    public Usuario actualizarUsuario(Integer id, Usuario usuario){
        Usuario usuarioExistente =usuarioRepository.findOne(id);
        BeanUtils.copyProperties(usuario,usuarioExistente);
        return usuarioRepository.saveAndFlush(usuarioExistente);
    }


    //Socio
    public List<Socio> mostrarSocios(){return socioRepository.findAll();}
    public Socio buscarSocio(Integer id){return socioRepository.findOne(id);}
    public Socio crearSocio(Socio socio){return socioRepository.saveAndFlush(socio);}

    public Socio actualizarSocio(Integer id, Socio socio){
        Socio socioExistente= socioRepository.findOne(id);
        BeanUtils.copyProperties(socio,socioExistente);
        return socioRepository.saveAndFlush(socioExistente);
    }

}
