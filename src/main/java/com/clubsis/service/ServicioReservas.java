package com.clubsis.service;

import com.clubsis.model.bungalow.Bungalow;
import com.clubsis.repository.bungalow.BungalowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Juan Tenorio on 1/5/2016.
 */

@Service
public class ServicioReservas {

    @Autowired
    private BungalowRepository bungalowRepository;

    public List<Bungalow> mostrarBungalows() {
        return bungalowRepository.findAll();
    }

    public Bungalow crearBungalow(Bungalow bungalow) {
        return bungalowRepository.saveAndFlush(bungalow);
    }

}
