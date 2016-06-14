package com.clubsis.service;

import com.clubsis.model.sede.TipoInstalacion;
import com.clubsis.repository.sede.TipoInstalacionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MAYRA on 02/06/2016.
 */
@Service
public class ServicioTipoInstalacion {
    @Autowired
    private TipoInstalacionRepository tipoinstalacionRepository;

    public List<TipoInstalacion> mostrarTipoInstalaciones(){
        List<TipoInstalacion> tipoInstalaciones=tipoinstalacionRepository.findAll();
        List<TipoInstalacion> tipoInstalacionesFiltradas = new ArrayList<TipoInstalacion>();
        for(TipoInstalacion tipo : tipoInstalaciones){
            if(tipo.getEsActivo())
                tipoInstalacionesFiltradas.add(tipo);
        }
        return tipoInstalacionesFiltradas;
    }
    public TipoInstalacion buscarTipoInstalaciones(Integer id) {return tipoinstalacionRepository.findOne(id);}
    public TipoInstalacion crearTipoInstalacion(TipoInstalacion tipoInstalacion) {return tipoinstalacionRepository.saveAndFlush(tipoInstalacion);}

    public TipoInstalacion actualizarTipoInstalacion(Integer id, TipoInstalacion tipoInstalacion){
        TipoInstalacion tipoExistente = tipoinstalacionRepository.findOne(id);
        BeanUtils.copyProperties(tipoInstalacion,tipoExistente);
        return tipoinstalacionRepository.saveAndFlush(tipoExistente);

    }
}
