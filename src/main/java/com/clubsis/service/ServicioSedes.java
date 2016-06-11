package com.clubsis.service;

import com.clubsis.model.producto.Producto;
import com.clubsis.model.producto.Producto_Sede;
import com.clubsis.model.producto.Producto_SedeID;
import com.clubsis.model.sede.Sede;
import com.clubsis.repository.producto.ProductoRepository;
import com.clubsis.repository.producto.Producto_SedeRepository;
import com.clubsis.repository.sede.SedeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Juan Tenorio on 19/5/2016.
 */
@Service
public class ServicioSedes {
    // Sede
    @Autowired
    private SedeRepository sedeRepository;
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private Producto_SedeRepository producto_sedeRepository;

    public List<Sede> mostrarSedes() {
        return sedeRepository.findAll();
    }

    public Sede crearSede(Sede sede) {
        Sede nuevaSede=sedeRepository.saveAndFlush(sede);
        List<Producto> productos = productoRepository.findAll();
        for (Producto item : productos) {
            Producto_SedeID id = new Producto_SedeID(productoRepository.findOne(item.getId()),nuevaSede);
            Producto_Sede stock = new Producto_Sede(id,0);
            producto_sedeRepository.saveAndFlush(stock);
        }
        return nuevaSede;
    }
    public Sede buscarSede(Integer id){  return sedeRepository.findOne(id);}

    public Sede actualizarSede(Integer id, Sede sede){
        Sede sedeExistente =  sedeRepository.findOne(id);
        BeanUtils.copyProperties(sede,sedeExistente);
        return sedeRepository.saveAndFlush(sedeExistente);
    }
}
