package com.clubsis.service;

import com.clubsis.model.evento.TarifaEvento;
import com.clubsis.repository.evento.TarifaxEventoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Juan Tenorio on 22/5/2016.
 */
@Service
public class ServicioTarifaEventos {

    @Autowired
    TarifaxEventoRepository tarifaxEventoRepository;

    public List<TarifaEvento> mostrarTarifasEventos() {
        return tarifaxEventoRepository.findAll();
    }
    public TarifaEvento buscarTarifasEventos(Integer id){return tarifaxEventoRepository.findOne(id);}
    public TarifaEvento crearTarifaEventos(TarifaEvento tarifaEvento){
        System.out.println(" 2 ");
        return tarifaxEventoRepository.saveAndFlush(tarifaEvento);
    }
    public TarifaEvento actualizarTarifaEventos(Integer id, TarifaEvento tarifaEvento){
        TarifaEvento tarifaEventoexistente= tarifaxEventoRepository.findOne(id);
        BeanUtils.copyProperties(tarifaEvento,tarifaEventoexistente);
        return tarifaxEventoRepository.saveAndFlush(tarifaEventoexistente);
    }
}
