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
import java.util.stream.Collectors;

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
    public List<Rol> mostrarRoles(){
        return rolRepository.findAll().stream().filter(rol -> rol.getEsActivo()).collect(Collectors.toList());
    }
}
