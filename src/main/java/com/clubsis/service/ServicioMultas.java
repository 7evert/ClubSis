package com.clubsis.service;

import com.clubsis.model.club.Multa;
import com.clubsis.repository.club.MultaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Blitz on 02/06/2016.
 */
@Service
public class ServicioMultas {
    @Autowired
    private MultaRepository multaRepository;

    public List<Multa> mostrarMultas(){return multaRepository.findAll();}
    public Multa buscarMulta(Integer id){return multaRepository.findOne(id);}
    public Multa crearMulta(Multa multa){
        return multaRepository.saveAndFlush(multa);
    }
    public Multa actualizarMulta(Integer id, Multa multa){
        Multa multaExistente= multaRepository.findOne(id);
        BeanUtils.copyProperties(multa,multaExistente);
        return multaRepository.saveAndFlush(multaExistente);
    }

}
