package com.clubsis.service;

import com.clubsis.model.evento.InvitadoEvento;
import com.clubsis.repository.evento.InvitadoxEventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Juan Tenorio on 29/5/2016.
 */
@Service
public class ServicioInvitadoEvento {
    @Autowired
    private InvitadoxEventoRepository invitadoxEventoRepository;

    public List<InvitadoEvento> mostrarInvitadoEventos(){return invitadoxEventoRepository.findAll();}
    public InvitadoEvento crearInvitadoEvento(InvitadoEvento invitadoEvento){return invitadoxEventoRepository.saveAndFlush(invitadoEvento);}
    public InvitadoEvento buscarInvitadoEvento(Integer id){return invitadoxEventoRepository.findOne(id);}
    public void eliminarInvitadoEvento(Integer id){
         invitadoxEventoRepository.delete(id);
    }
}
