package com.clubsis.service;

import com.clubsis.model.pago.*;
import com.clubsis.model.persona.Socio;
import com.clubsis.repository.pago.CuotaExtraordinariaRepository;
import com.clubsis.repository.pago.PagoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Blitz on 25/05/2016.
 */
@Service
public class ServicioPagos {
    @Autowired
    private CuotaExtraordinariaRepository cuotaExtraordinariaRepository;
    @Autowired
    private PagoRepository pagoRepository;


    //CuotaExtraordinaria
    public List<CuotaExtraordinaria> mostrarCuotasExtraordinarias(){ return cuotaExtraordinariaRepository.findAll(); }
    public CuotaExtraordinaria buscarCuotaExtraordinaria(Integer id) {return cuotaExtraordinariaRepository.findOne(id);}
    public CuotaExtraordinaria crearCuotaExtraordinaria(CuotaExtraordinaria cuotaExtraordinaria) {
        return cuotaExtraordinariaRepository.saveAndFlush(cuotaExtraordinaria);}

    public CuotaExtraordinaria actualizarCuotaExtraordinaria(Integer id, CuotaExtraordinaria cuotaExtraordinaria){
        CuotaExtraordinaria cuotaExistente = cuotaExtraordinariaRepository.findOne(id);
        BeanUtils.copyProperties(cuotaExtraordinaria,cuotaExistente);
        return cuotaExtraordinariaRepository.saveAndFlush(cuotaExistente);
    }


    //Pago
    public List<Pago> mostrarPagos(){ return pagoRepository.findAll(); }
    public Pago buscarPago(Integer id) {return pagoRepository.findOne(id);}
    public Pago crearPago(Pago pago) {
        return pagoRepository.saveAndFlush(pago);
    }

    public Pago actualizarPago(Integer id, Pago pago){
        Pago pagoExistente = pagoRepository.findOne(id);
        BeanUtils.copyProperties(pago,pagoExistente);
        return pagoRepository.saveAndFlush(pagoExistente);
    }


    //ADICIONALES

    public Pago primerPago(Socio socio) {
        Date fechaInicial = new Date();
        Date fechaFinal = new Date();
        fechaFinal.setTime(fechaInicial.getTime() + 7 * 24 * 60 * 60 * 1000);
        Double pago= socio.getTipo().getCostoInicial()+socio.getTipo().getCostoMembresia();
        Pago nuevoPago = new Pago(null,pago,fechaFinal,null,null,fechaInicial, EstadoPago.REGISTRADO,null,TipoPago.MEMBRESIA,socio);
        pagoRepository.saveAndFlush(nuevoPago);
        return nuevoPago;
    }

    public List<CuotaExtraordinaria> crearCuotasExtraordinarias(){
        return null;
    }

}
