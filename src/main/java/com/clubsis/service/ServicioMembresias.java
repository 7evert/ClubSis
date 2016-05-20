package com.clubsis.service;

import com.clubsis.model.club.Usuario;
import com.clubsis.model.persona.Persona;
import com.clubsis.model.persona.Postulante;
import com.clubsis.model.persona.Socio;
import com.clubsis.model.persona.Suspension;
import com.clubsis.repository.club.UsuarioRepository;
import com.clubsis.repository.persona.PersonaRepository;
import com.clubsis.repository.persona.PostulanteRepository;
import com.clubsis.repository.persona.SocioRepository;
import com.clubsis.repository.persona.SuspensionRepository;
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

    @Autowired
    private SuspensionRepository suspensionRepository;

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

    //Suspension

    public List<Suspension> mostrarSuspensiones(){return suspensionRepository.findAll();}
    public Suspension buscarSuspension(Integer id) {return suspensionRepository.findOne(id);}
    public Suspension crearSuspension(Suspension suspension){return suspensionRepository.saveAndFlush(suspension);}

    public Suspension actualizarSuspension(Integer id, Suspension suspension){
        Suspension suspensionExistente=suspensionRepository.findOne(id);
        BeanUtils.copyProperties(suspension,suspensionExistente);
        return suspensionRepository.saveAndFlush(suspensionExistente);
    }

    //MEMBRESIA

    public Persona personaMembresia(Postulante postulanteExistente){
        Persona nuevaPersona = new Persona(
                postulanteExistente.getNombre(),postulanteExistente.getApellidoPaterno(),postulanteExistente.getApellidoMaterno(),
                postulanteExistente.getFechaNacimiento(),postulanteExistente.getDireccion(),postulanteExistente.getCorreo(),
                postulanteExistente.getNumeroDocumento(), postulanteExistente.getCelular(),true);
        return nuevaPersona;
    }

    public Socio socioMembresia(Postulante postulanteExistente){
        Socio nuevoSocio = new Socio(
                postulanteExistente.getFechaPostulacion(),1,postulanteExistente.getId());
        return nuevoSocio;
    }


    public void crearMembresia(Integer idPostulante){
        Postulante postulanteExistente = postulanteRepository.findOne(idPostulante);
        postulanteExistente.setEsAprobado(true);
        personaMembresia(postulanteExistente);
        socioMembresia(postulanteExistente);
        actualizarPostulante(idPostulante,postulanteExistente);
    }



}
