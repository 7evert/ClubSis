package com.clubsis.service;

import com.clubsis.model.bungalow.Bungalow;
import com.clubsis.model.bungalow.EstadoBungalow;
import com.clubsis.model.bungalow.ReservaBungalow;
import com.clubsis.model.bungalow.TipoBungalow;
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
//        List<Bungalow> bungalows = bungalowRepository.findAll();
//        List<Bungalow> bungalowsFiltrados = new ArrayList<Bungalow>();
//        for(Bungalow item : bungalows){
//            if(item.getEstado().toString().contentEquals("DISPONIBLE"))
//                bungalowsFiltrados.add(item);
//        }
//        return bungalowsFiltrados;
        return bungalowRepository.findAll();
    }

    public Bungalow crearBungalow(Bungalow bungalow) {
        return bungalowRepository.saveAndFlush(bungalow);
    }

    public Bungalow buscarBungalow(Integer id) {
        return bungalowRepository.findOne(id);
    }

    public Bungalow actualizarBungalow(Integer id, Bungalow bungalow) {
        Bungalow bungalowExistente = bungalowRepository.findOne(id);
        BeanUtils.copyProperties(bungalow, bungalowExistente);
        return bungalowRepository.saveAndFlush(bungalowExistente);
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
}
