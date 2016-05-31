package com.clubsis.service;

import com.clubsis.model.pago.*;
import com.clubsis.model.persona.Socio;
import com.clubsis.repository.pago.CuotaExtraordinariaRepository;
import com.clubsis.repository.pago.PagoMembresiaRepository;
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
    private PagoMembresiaRepository pagoMembresiaRepository;
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

    //PagoMembresia
    public List<PagoMembresia> mostrarPagosMembresia(){ return pagoMembresiaRepository.findAll(); }
    public PagoMembresia buscarPagoMembresia(Integer id) {return pagoMembresiaRepository.findOne(id);}
    public PagoMembresia crearPagoMembresia(PagoMembresia pagoMembresia) {
        return pagoMembresiaRepository.saveAndFlush(pagoMembresia);
    }

    public PagoMembresia actualizarPagoMembresia(Integer id, PagoMembresia pagoMembresia){
        PagoMembresia pagoMembresiaExistente = pagoMembresiaRepository.findOne(id);
        BeanUtils.copyProperties(pagoMembresia,pagoMembresiaExistente);
        return pagoMembresiaRepository.saveAndFlush(pagoMembresiaExistente);
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

    public PagoMembresia primerPago(Socio socio) {
        Date fechaInicial = new Date();
        Date fechaFinal = new Date();
        fechaFinal.setTime(fechaInicial.getTime() + 7 * 24 * 60 * 60 * 1000);
        Double pago= socio.getTipo().getCostoInicial()+socio.getTipo().getCostoMembresia();
        PagoMembresia nuevoPago = new PagoMembresia(fechaFinal, EstadoPago.REGISTRADO,pago,fechaInicial,socio,null);
        pagoMembresiaRepository.saveAndFlush(nuevoPago);
        return nuevoPago;
    }

}
