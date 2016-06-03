package com.clubsis.service;

import com.clubsis.model.evento.PersonaEvento;
import com.clubsis.model.persona.Persona;
import com.clubsis.repository.evento.PersonaEventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Juan Tenorio on 31/5/2016.
 */
@Service
public class ServicioPersonaEvento {
    @Autowired
    private PersonaEventoRepository personaEventoRepository;

    public List<PersonaEvento> mostrarPersonaEventos(){return personaEventoRepository.findAll();}
    public PersonaEvento crearPersonaEvento(PersonaEvento personaEvento){return personaEventoRepository.saveAndFlush(personaEvento);}
    public PersonaEvento buscarPersonaEvento(Integer id){return personaEventoRepository.findOne(id);}
    public void eliminarPersonaEvento(Integer id){
        personaEventoRepository.delete(id);
    }

    public List<Persona> buscarAsistentesSocio(Integer idSocio, Integer idEvento){
        List<Persona> personas = new ArrayList<Persona>();
        List<PersonaEvento> personaEventos = personaEventoRepository.findAll();
        for(int i=0;i<personaEventos.size();i++){
            PersonaEvento temp = personaEventos.get(i);
            //si se encuentra el evento y la persona la cual es el socio
            if(temp.getEvento().getId() == idEvento){
                Persona persona = temp.getPersona();
                if(persona.getSocio().getId() == idSocio){
                    personas.add(persona);
                }
            }
        }
        return personas;
    }
}
