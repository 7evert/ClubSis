package com.clubsis.service;

import com.clubsis.model.clase.RegistroClase;
import com.clubsis.model.club.Usuario;
import com.clubsis.model.pago.CuotaExtraordinaria;
import com.clubsis.model.pago.Pago;
import com.clubsis.model.persona.*;
import com.clubsis.model.sede.ReservaInstalacion;
import com.clubsis.repository.club.UsuarioRepository;
import com.clubsis.repository.persona.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.UUID;

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

    @Autowired
    private TipoSocioRepository tipoSocioRepository ;

    //Persona
    public List<Persona> mostrarPersonas(){ return personaRepository.findAll(); }
    public Persona buscarPersona(Integer id) {return personaRepository.findOne(id);}
    public Persona crearPersona(Persona persona) {return personaRepository.saveAndFlush(persona);}

    public Persona actualizarPersona(Integer id, Persona persona){
        Persona personaExistente = personaRepository.findOne(id);
        persona.setSocio(personaExistente.getSocio());
        BeanUtils.copyProperties(persona,personaExistente);

        return personaRepository.saveAndFlush(personaExistente);
    }
    public void eliminarPersona(Integer id){
        personaRepository.delete(id);
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
    public Socio crearSocio(Socio socio){
        return socioRepository.saveAndFlush(socio);
    }

    /*comitea*/
    public Socio actualizarSocio(Integer id, Integer idTipo, Socio socio){
        Socio socioExistente= socioRepository.findOne(id);
        TipoSocio tipo = tipoSocioRepository.findOne(idTipo);
        socioExistente.setTipo(tipo);
        socioExistente.setFechaInscripcion(socio.getFechaInscripcion());
        socioExistente.setCodigoCarnet(socio.getCodigoCarnet());
        socioExistente.setEstado(socio.getEstado());
        return socioRepository.saveAndFlush(socioExistente);
    }


    //Tipo Socio
    public List<TipoSocio> mostrarTiposSocios(){return tipoSocioRepository.findAll();}
    public TipoSocio buscarTipoSocio(Integer id) {return  tipoSocioRepository.findOne(id);}
    public TipoSocio crearTipoSocio(TipoSocio tipoSocio) {return  tipoSocioRepository.saveAndFlush(tipoSocio);}
    public TipoSocio actualizarTipoSocio(Integer id, TipoSocio tipoSocio){
        TipoSocio tipoSocioExistente= tipoSocioRepository.findOne(id);
        BeanUtils.copyProperties(tipoSocio,tipoSocioExistente);
        return tipoSocioRepository.saveAndFlush(tipoSocioExistente);
    }

    //Suspension

    public List<Suspension> mostrarSuspensiones(){return suspensionRepository.findAll();}
    public Suspension buscarSuspension(Integer id) {return suspensionRepository.findOne(id);}
    public Suspension crearSuspension(Suspension suspension){
        return suspensionRepository.saveAndFlush(suspension);
    }

    public Suspension actualizarSuspension(Integer id, Suspension suspension){
        Suspension suspensionExistente=suspensionRepository.findOne(id);
        BeanUtils.copyProperties(suspension,suspensionExistente);
        return suspensionRepository.saveAndFlush(suspensionExistente);
    }

    //MEMBRESIA

    public TipoSocio seleccionarTipoSocio(){
        List<TipoSocio> tiposSocio = tipoSocioRepository.findAll();
        TipoSocio resultado=null;
        for(TipoSocio item: tiposSocio){
            System.out.print(item.getNombre());
            if(item.getNombre().equals("NORMAL")) resultado=item; //Tipo membresia por defecto
        }
        return resultado;
    }


    public Persona personaMembresia(Postulante postulanteExistente){
        Persona nuevaPersona = new Persona(
                postulanteExistente.getNombre(),postulanteExistente.getApellidoPaterno(),postulanteExistente.getApellidoMaterno(),
                postulanteExistente.getFechaNacimiento(),postulanteExistente.getDireccion(),postulanteExistente.getCorreo(),
                postulanteExistente.getNumeroDocumento(), "",Boolean.TRUE,null,null,null,
                new HashSet<RegistroClase>());
        return nuevaPersona;
    }

    public Socio socioMembresia(Postulante postulanteExistente){
        TipoSocio tipo = seleccionarTipoSocio();
        String codigoCarnet= UUID.randomUUID().toString().replaceAll("-", "");
        Socio nuevoSocio = new Socio(
                postulanteExistente.getFechaPostulacion(),EstadoSocio.ACTIVO, codigoCarnet.substring(0,12),new HashSet<Invitado>()
                ,new HashSet<Persona>(),new HashSet<SocioPostulante>(),new HashSet<Pago>()
                ,new HashSet<CuotaExtraordinaria>(),new HashSet<Suspension>(),
                new HashSet<ReservaInstalacion>(),tipo);
        return nuevoSocio;
    }


    public Socio crearMembresia(Integer idPostulante){
        Postulante postulanteExistente = postulanteRepository.findOne(idPostulante);
        postulanteExistente.setEsAprobado(EstadoPostulante.APROBADO);
        postulanteExistente.setEsActivo(Boolean.FALSE);
        Persona nuevaPersona= personaMembresia(postulanteExistente);
        Socio nuevoSocio = socioMembresia(postulanteExistente);
        nuevaPersona.setSocio(socioRepository.saveAndFlush(nuevoSocio));
        personaRepository.saveAndFlush(nuevaPersona);
        postulanteRepository.saveAndFlush(postulanteExistente);
        return nuevoSocio;
    }

    public Persona obtenerSocioPrincipal(Integer idSocio){
        List<Persona> personas = personaRepository.findAll();
        for(Persona item:personas){
            if(item.getSocio().getId()== idSocio && item.getEsTitular() ){
                return item;
            }
        }
        return null;
    }

}
