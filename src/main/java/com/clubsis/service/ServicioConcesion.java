package com.clubsis.service;

import com.clubsis.model.sede.Concesion;
import com.clubsis.repository.sede.ConcesionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
/**
 * Created by Vivian on 02/06/2016.
 */

@Service
public class ServicioConcesion {
    @Autowired
    private ConcesionRepository concesionRepository;

    //CONCESION
    public List<Concesion> mostrarConcesiones() {
        return concesionRepository.findAll();
    }

    public Concesion crearConcesion(Concesion concesion) {
        return concesionRepository.saveAndFlush(concesion);
    }

    public Concesion buscarConcesion(Integer id) {
        return concesionRepository.findOne(id);
    }

    public Concesion actualizarConcesion(Integer id, Concesion concesion) {
        Concesion concesionExistente = concesionRepository.findOne(id);
        BeanUtils.copyProperties(concesion, concesionExistente);
        return concesionRepository.saveAndFlush(concesionExistente);
    }

}
