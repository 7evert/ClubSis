package com.clubsis.service;

import com.clubsis.model.evento.Evento;
import com.clubsis.model.persona.Invitado;
import com.clubsis.model.persona.Socio;
import com.clubsis.repository.evento.EventoRepository;
import com.clubsis.repository.persona.InvitadoRepository;
import com.clubsis.repository.persona.SocioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Juan Tenorio on 24/5/2016.
 */
@Service
public class ServicioInvitados {
    @Autowired
    private InvitadoRepository invitadoRepository;
    @Autowired
    private SocioRepository socioRepository;
    @Autowired
    private EventoRepository eventoRepository;

    public List<Invitado> mostrarInvitados() {return invitadoRepository.findAll();}
    public Invitado buscarInvitado(Integer id){return invitadoRepository.findOne(id);}
    public Invitado crearInvitado(Invitado invitado){
        return invitadoRepository.saveAndFlush(invitado);
    }
    public Invitado actualizarInvitado(Integer id, Invitado invitado){
        Invitado invitadoExistente = invitadoRepository.findOne(id);
        if(invitado.getIngresoInvitado() != invitadoExistente.getIngresoInvitado()) invitadoExistente.setIngresoInvitado(invitado.getIngresoInvitado());
        if(invitado.getApellidoMaterno() != invitadoExistente.getApellidoMaterno()) invitadoExistente.setApellidoMaterno(invitado.getApellidoMaterno());
        if(invitado.getApellidoPaterno() != invitadoExistente.getApellidoPaterno()) invitadoExistente.setApellidoPaterno(invitado.getApellidoPaterno());
        if(invitado.getNombres() != invitadoExistente.getNombres()) invitadoExistente.setNombres(invitado.getNombres());
        if(invitado.getTipoDocumento() != invitadoExistente.getTipoDocumento()) invitadoExistente.setTipoDocumento(invitado.getTipoDocumento());
        if(invitado.getNumeroDocumento() != invitadoExistente.getNumeroDocumento()) invitadoExistente.setNumeroDocumento(invitado.getNumeroDocumento());
        //BeanUtils.copyProperties(invitado, invitadoExistente);
        return invitadoRepository.saveAndFlush(invitadoExistente);
        //asdasdas
    }
}
