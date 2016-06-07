package com.clubsis.service;


import com.clubsis.model.sede.EstadoInstalacion;
import com.clubsis.model.sede.Instalacion;
import com.clubsis.repository.sede.InstalacionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MAYRA on 22/05/2016.
 */
@Service
public class ServicioInstalacion {
    @Autowired
    private InstalacionRepository instalacionRepository;

    public List<Instalacion> mostrarInstalaciones(){
        List<Instalacion> instalaciones=instalacionRepository.findAll();
        List<Instalacion> instalacionesFiltradas = new ArrayList<Instalacion>();
        for(Instalacion instalacion : instalaciones){
            if(instalacion.getEsActivo())
                instalacionesFiltradas.add(instalacion);
        }
        return instalacionesFiltradas;
    }
    public Instalacion buscarInstalaciones(Integer id) {return instalacionRepository.findOne(id);}
    public Instalacion crearInstalacion(Instalacion instalacion) {return instalacionRepository.saveAndFlush(instalacion);}

    public Instalacion actualizarInstalacion(Integer id, Instalacion instalacion){
        Instalacion instalacionExistente = instalacionRepository.findOne(id);
        BeanUtils.copyProperties(instalacion,instalacionExistente);
        return instalacionRepository.saveAndFlush(instalacionExistente);

    }

    public EstadoInstalacion[] getEstadoInstalacion(){
        return EstadoInstalacion.values();
    }
}
