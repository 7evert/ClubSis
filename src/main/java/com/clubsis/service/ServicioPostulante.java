package com.clubsis.service;

import com.clubsis.model.persona.Postulante;
import com.clubsis.repository.persona.PostulanteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by gerson on 21/05/2016.
 */
@Service
public class ServicioPostulante {
    @Autowired
    private PostulanteRepository postulanteRepository;

    //Postulante
    public List<Postulante> mostrarPostulantes(){ return postulanteRepository.findAll(); }
    public Postulante buscarPostulante(Integer id) {return postulanteRepository.findOne(id);}
    public Postulante crearPostulante(Postulante postulante) {return postulanteRepository.saveAndFlush(postulante);}

    public Postulante actualizarPostulante(Integer id, Postulante postulante){
        Postulante postulanteExistente = postulanteRepository.findOne(id);
        BeanUtils.copyProperties(postulante,postulanteExistente);
        return postulanteRepository.saveAndFlush(postulanteExistente);
    }
}
