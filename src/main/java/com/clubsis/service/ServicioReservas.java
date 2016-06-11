package com.clubsis.service;

import com.clubsis.model.bungalow.*;
import com.clubsis.model.sede.Sede;
import com.clubsis.repository.bungalow.BungalowRepository;
import com.clubsis.repository.bungalow.ReservaBungalowRepository;
import com.clubsis.repository.bungalow.TipoBungalowRepository;
import com.clubsis.repository.sede.SedeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Juan Tenorio on 1/5/2016.
 */

@Service
public class ServicioReservas {

    @Autowired
    private BungalowRepository bungalowRepository;

    @Autowired
    private TipoBungalowRepository tipoBungalowRepository;

    @Autowired
    private ReservaBungalowRepository reservaBungalowRepository;

    // Bungalow

    public List<Bungalow> mostrarBungalows() {
        return bungalowRepository.findAll();
    }

    public Bungalow crearBungalow(Bungalow bungalow) {
        return bungalowRepository.saveAndFlush(bungalow);
    }

    public Bungalow buscarBungalow(Integer id) {
        return bungalowRepository.findOne(id);
    }

    public ReservaBungalow buscarReservaBungalow(Integer id) {
        return reservaBungalowRepository.findOne(id);
    }

    public Bungalow actualizarBungalow(Integer id, Bungalow bungalow) {
        Bungalow bungalowExistente = bungalowRepository.findOne(id);
        BeanUtils.copyProperties(bungalow, bungalowExistente);
        return bungalowRepository.saveAndFlush(bungalowExistente);
    }

    public ReservaBungalow actualizarReservaBungalow(Integer id, ReservaBungalow reservaBungalow) {
        ReservaBungalow reservaBungalowExistente = reservaBungalowRepository.findOne(id);
        BeanUtils.copyProperties(reservaBungalow, reservaBungalowExistente);
        return reservaBungalowRepository.saveAndFlush(reservaBungalowExistente);
    }

    // TipoBungalow

    public List<TipoBungalow> mostrarTiposBungalow() {
        return tipoBungalowRepository.findAll();
    }

    public TipoBungalow crearTipoBungalow(TipoBungalow tipoBungalow) {
        return tipoBungalowRepository.saveAndFlush(tipoBungalow);
    }

    public TipoBungalow actualizarTipoBungalow(Integer id, TipoBungalow tipoBungalow) {
        TipoBungalow bungalowExistente = tipoBungalowRepository.findOne(id);
        tipoBungalow.setId(id);
        BeanUtils.copyProperties(tipoBungalow, bungalowExistente);
        return tipoBungalowRepository.saveAndFlush(bungalowExistente);
    }
    // ReservaBungalow

    public List<ReservaBungalow> mostrarReservasBungalow() {
        return reservaBungalowRepository.findAll();
    }

    public ReservaBungalow crearReservaBungalow(ReservaBungalow reservaBungalow) {
        return reservaBungalowRepository.saveAndFlush(reservaBungalow);
    }

    public TipoBungalow obtenerBungalow(Integer id){
        return tipoBungalowRepository.findOne(id);
    }

    public EstadoReservaBungalow[] getEstadoReservaBungalow(){
        return EstadoReservaBungalow.values();
    }
}
