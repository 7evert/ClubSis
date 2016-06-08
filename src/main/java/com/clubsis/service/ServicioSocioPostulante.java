package com.clubsis.service;

import com.clubsis.model.persona.Socio;
import com.clubsis.model.persona.SocioPostulante;
import com.clubsis.repository.evento.InvitadoxEventoRepository;
import com.clubsis.repository.persona.SocioPostulanteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Juan Tenorio on 5/6/2016.
 */
@Service
public class ServicioSocioPostulante {
    @Autowired
    private SocioPostulanteRepository socioPostulanteRepository;

    public List<SocioPostulante> mostrarSocioPostulantes(){return socioPostulanteRepository.findAll();}
    public SocioPostulante crearSocioPostulante(SocioPostulante invitadoEvento){return socioPostulanteRepository.saveAndFlush(invitadoEvento);}
    public SocioPostulante buscarSocioPostulante(Integer id){return socioPostulanteRepository.findOne(id);}
    public void eliminarSocioPostulante(Integer id){
        socioPostulanteRepository.delete(id);

    }
    public SocioPostulante actualizarSocioPostulante(Integer id, SocioPostulante socioPostulante){
        SocioPostulante socioPostulante1Existente =socioPostulanteRepository.findOne(id);
        BeanUtils.copyProperties(socioPostulante,socioPostulante1Existente);
        return socioPostulanteRepository.saveAndFlush(socioPostulante1Existente);
    }

    public List<String> getObservaciones(Integer id){
        List<String> observaciones = new ArrayList<String>(0);
        List<SocioPostulante> socioPostulantes = socioPostulanteRepository.findAll();
        for(int i=0;i<socioPostulantes.size();i++){
            SocioPostulante socioPostulante = socioPostulantes.get(i);
            if(socioPostulante.getPostulante().getId() == id){
                observaciones.add(socioPostulante.getObservaciones());
            }
        }
        return observaciones;
    }

    public List<Socio> getSocios(Integer id){
        List<Socio> socios = new ArrayList<Socio>();
        List<SocioPostulante> socioPostulantes = socioPostulanteRepository.findAll();
        for(int i=0;i<socioPostulantes.size();i++){
            SocioPostulante socioPostulante = socioPostulantes.get(i);
            if(socioPostulante.getPostulante().getId() == id){
                socios.add(socioPostulante.getSocio());
            }
        }
        return socios;
    }
}
