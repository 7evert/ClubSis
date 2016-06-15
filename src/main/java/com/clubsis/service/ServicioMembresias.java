package com.clubsis.service;

import com.clubsis.model.clase.RegistroClase;
import com.clubsis.model.club.Usuario;
import com.clubsis.model.pago.CuotaExtraordinaria;
import com.clubsis.model.pago.EstadoPago;
import com.clubsis.model.pago.Pago;
import com.clubsis.model.pago.TipoPago;
import com.clubsis.model.persona.*;
import com.clubsis.model.sede.ReservaInstalacion;
import com.clubsis.repository.club.UsuarioRepository;
import com.clubsis.repository.persona.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
                postulanteExistente.getTipoDoc(),postulanteExistente.getNumDoc(), postulanteExistente.getCelular(),Boolean.TRUE,null,null,null,
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
        List<Persona> personas = new ArrayList<>(socioRepository.findOne(idSocio).getPersonas());
        for(Persona item:personas){
            if(item.getEsTitular() ){
                return item;
            }
        }
        return null;
    }

    public void transferirMembresia(Integer idPrincipal , Integer idNuevo){
        Persona socioPrincipal = personaRepository.findOne(idPrincipal);
        Persona nuevoPrincipal = personaRepository.findOne(idNuevo);
        socioPrincipal.setEsTitular(false);
        nuevoPrincipal.setEsTitular(true);
        personaRepository.saveAndFlush(socioPrincipal);
        personaRepository.saveAndFlush(nuevoPrincipal);

    }

    //@Scheduled(cron="*/10 * * * * *")// cada 10 segundos
    //@Scheduled(cron="0 */10 * * * *")// cada 10 minutos
    @Scheduled(cron="0 0 0 * * ?")// cada dia
    public void membresiasDeudores(){
        List<Socio> socios=socioRepository.findAll();
        for(Socio item:socios){ //Se anulara la membresia si es que no esta al dia en sus pagos de membresia
            if(item.getEstado()==EstadoSocio.ACTIVO){
                List<Pago> pagos=new ArrayList<>(item.getPagos());
                for(Pago itemPago:pagos){
                    if(itemPago.getEstadoPago()== EstadoPago.VENCIDO && itemPago.getTipoPago()== TipoPago.MEMBRESIA){
                        item.setEstado(EstadoSocio.SUSPENDIDO);
                        socioRepository.saveAndFlush(item);
                    }
                }
            }
        }
    }

}
