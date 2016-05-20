package com.clubsis.service;

import com.clubsis.model.evento.TarifaEvento;
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

    //TarifaEvento
    public List<TarifaEvento> mostrarTarifas() {return tarifaEventoRepository.findAll();}

    public TarifaEvento buscarTarifa (Integer id){return tarifaEventoRepository.findOne(id);}

    public TarifaEvento crearTarifa(TarifaEvento tarifa){return tarifaEventoRepository.saveAndFlush(tarifa);}

    public TarifaEvento actualizarTarifa(Integer id, TarifaEvento tarifa){
        TarifaEvento tarifaExistente = tarifaEventoRepository.findOne(id);
        BeanUtils.copyProperties(tarifa,tarifaExistente);
        return tarifaEventoRepository.saveAndFlush(tarifaExistente);
    }
}
