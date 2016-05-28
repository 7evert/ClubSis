package com.clubsis.service;

import com.clubsis.model.evento.Tarifa;
import com.clubsis.repository.evento.TarifaEventoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Juan Tenorio on 18/5/2016.
 */
@Service
public class ServicioTarifas {

    @Autowired
    TarifaEventoRepository tarifaEventoRepository;

    //Tarifa
    public List<Tarifa> mostrarTarifas() {return tarifaEventoRepository.findAll();}

    public Tarifa buscarTarifa (Integer id){return tarifaEventoRepository.findOne(id);}

    public Tarifa crearTarifa(Tarifa tarifa){return tarifaEventoRepository.saveAndFlush(tarifa);}

    public Tarifa actualizarTarifa(Integer id, Tarifa tarifa){
        Tarifa tarifaExistente = tarifaEventoRepository.findOne(id);
        BeanUtils.copyProperties(tarifa,tarifaExistente);
        return tarifaEventoRepository.saveAndFlush(tarifaExistente);
    }
}
