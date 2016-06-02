package com.clubsis.service;

import com.clubsis.model.evento.Evento;
import com.clubsis.model.evento.InvitadoEvento;
import com.clubsis.model.evento.PersonaEvento;
import com.clubsis.model.evento.TarifaEvento;
import com.clubsis.model.persona.Invitado;
import com.clubsis.model.persona.Persona;
import com.clubsis.repository.evento.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Juan Tenorio on 17/5/2016.
 */
@Service
public class ServicioEventos {

    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private InvitadoxEventoRepository invitadoxEventoRepository;

    @Autowired
    private PersonaEventoRepository personaEventoRepository;

    @Autowired
    private TarifaxEventoRepository tarifaxEventoRepository;

    //Evento
    public List<Evento> mostrarEventos() {
        return eventoRepository.findAll();
    }

    public Evento buscarEvento(Integer id){return eventoRepository.findOne(id);}

    public Evento crearEvento(Evento evento){ return eventoRepository.save(evento);}

    public Evento actualizarEvento(Integer id, Evento evento){
        Evento eventoExistente = eventoRepository.findOne(id);
        if(evento.getFechaFin() == null ) evento.setFechaFin(eventoExistente.getFechaFin());
        if(evento.getFechaInicio() == null ) evento.setFechaInicio(eventoExistente.getFechaInicio());
        if(evento.getFechaInicioInscripcion() == null ) evento.setFechaInicioInscripcion(eventoExistente.getFechaInicioInscripcion());
        if(evento.getFechaFinInscripcion() == null ) evento.setFechaFinInscripcion(eventoExistente.getFechaFinInscripcion());
        BeanUtils.copyProperties(evento, eventoExistente);
        return eventoRepository.saveAndFlush(eventoExistente);
    }

    public double PagoEvento(Integer idEvento,Integer idSocio){
        double tot = 0.0;
        List<String> nombres = new ArrayList<String>();
        List<Double> precios = new ArrayList<Double>();
        List<TarifaEvento> tarifaEventos = tarifaxEventoRepository.findAll();
        for(int i=0;i<tarifaEventos.size();i++){
            TarifaEvento tmp = tarifaEventos.get(i);
            if(tmp.getEventos().getId() == idEvento){
                precios.add(tmp.getPrecio());
                nombres.add(tmp.getTarifaeventos().getNombre());
            }
        }
        //Calculo el costo total por invitar a gente que no es socio
        List<InvitadoEvento> invitadoEventos = invitadoxEventoRepository.findAll();
        for(int i=0;i<invitadoEventos.size();i++){
            InvitadoEvento tmp = invitadoEventos.get(i);
            if(tmp.getEvento().getId() == idEvento){
                Invitado invitado = tmp.getInvitado();
                if(invitado.getSocio().getId() == idSocio){
                    for(int j=0;j<nombres.size();j++){
                        if(nombres.get(j) == tmp.getTipo()){
                            tot += precios.get(j);
                        }
                    }
                }
            }
        }

        //Calculo el costo total por invitar a familiares
        List<PersonaEvento> personaEventos = personaEventoRepository.findAll();
        for(int i=0;i<personaEventos.size();i++){
            PersonaEvento tmp = personaEventos.get(i);
            if(tmp.getEvento().getId() == idEvento){
                Persona persona = tmp.getPersona();
                if(persona.getSocio().getId() == idSocio){
                    for(int j=0;j<nombres.size();j++){
                        if(nombres.get(j) == tmp.getTipo()){
                            tot+=(1-tmp.getEvento().getDescuento()/100)*precios.get(j);
                        }
                    }
                }
            }
        }
        return tot;
    }

}
