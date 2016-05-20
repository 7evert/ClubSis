package com.clubsis.service;

import com.clubsis.model.sede.Sede;
import com.clubsis.repository.sede.SedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Juan Tenorio on 19/5/2016.
 */
@Service
public class ServicioSedes {
    // Sede
    @Autowired
    private SedeRepository sedeRepository;
    public List<Sede> mostrarSedes() {
        return sedeRepository.findAll();
    }

    public Sede crearSede(Sede sede) {
        return sedeRepository.saveAndFlush(sede);
    }
    public Sede buscarSede(Integer id){  return sedeRepository.findOne(id);}
}
