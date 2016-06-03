package com.clubsis.service;

import com.clubsis.model.privilegio.Permiso;
import com.clubsis.model.privilegio.Rol;
import com.clubsis.model.sede.Instalacion;
import com.clubsis.repository.privilegios.PermisoRepository;
import com.clubsis.repository.privilegios.RolRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lati on 24.05.2016.
 */

@Service
public class ServicioRol {
    @Autowired
    private RolRepository rolRepository;
    @Autowired
    private PermisoRepository permisoRepository;


    private Permiso perExistente;

    public Rol buscarRol(Integer id) {return rolRepository.findOne(id);}

    public Rol crearRol(Rol rol) {return rolRepository.saveAndFlush(rol);}

    public Rol actualizarRol(Integer id, Rol rol) {
        Rol rolExistente = rolRepository.findOne(id);
        BeanUtils.copyProperties(rol,rolExistente);
        return rolRepository.saveAndFlush(rolExistente);
    }

    public List<Rol> mostrarRols(){
        List<Rol> roles=rolRepository.findAll();
        List<Rol> rolesFiltrados = new ArrayList<Rol>();
        for(Rol rol : roles){
            if(rol.getEsActivo())
                rolesFiltrados.add(rol);
        }
        return rolesFiltrados;

    }


    //Permiso


    public Permiso buscarPermisio(Integer id) {return permisoRepository.findOne(id);}

    public Permiso creaerPermisio(Permiso per) {
        return permisoRepository.saveAndFlush(per);
    }

    public Permiso actualizarPermisio(Integer id, Permiso per) {
        perExistente = permisoRepository.findOne(id);
        BeanUtils.copyProperties(per,perExistente);
        return permisoRepository.saveAndFlush(per);
    }

    public List<Permiso> mostarPermisio(Rol r){
        List<Permiso> results = permisoRepository.findAll();

        for(Permiso pe : results){
            if (!pe.getRol().equals(r)){
                results.remove(pe);
            }
        }
        return results;
    }
}
