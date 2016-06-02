package com.clubsis.service;

import com.clubsis.model.bungalow.Bungalow;
import com.clubsis.model.bungalow.ReservaBungalow;
import com.clubsis.model.clase.RegistroClase;
import com.clubsis.model.club.Multa;
import com.clubsis.model.evento.Evento;
import com.clubsis.model.pago.*;
import com.clubsis.model.persona.Socio;
import com.clubsis.model.sede.ReservaInstalacion;
import com.clubsis.repository.bungalow.BungalowRepository;
import com.clubsis.repository.bungalow.ReservaBungalowRepository;
import com.clubsis.repository.clase.ClaseRepository;
import com.clubsis.repository.clase.RegistroClaseRepository;
import com.clubsis.repository.club.MultaRepository;
import com.clubsis.repository.evento.EventoRepository;
import com.clubsis.repository.pago.CuotaExtraordinariaRepository;
import com.clubsis.repository.pago.PagoRepository;
import com.clubsis.repository.persona.SocioRepository;
import com.clubsis.repository.sede.InstalacionRepository;
import com.clubsis.repository.sede.ReservaInstalacionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    @Autowired
    private SocioRepository socioRepository;
    @Autowired
    private EventoRepository eventoRepository;
    @Autowired
    private ReservaBungalowRepository reservaBungalowRepository;
    @Autowired
    private RegistroClaseRepository registroClaseRepository;
    @Autowired
    private ReservaInstalacionRepository reservaInstalacionRepository;
    @Autowired
    private MultaRepository multaRepository;

    //CuotaExtraordinaria
    public List<CuotaExtraordinaria> mostrarCuotasExtraordinarias(){ return cuotaExtraordinariaRepository.findAll(); }
    public CuotaExtraordinaria buscarCuotaExtraordinaria(Integer id) {return cuotaExtraordinariaRepository.findOne(id);}
    public CuotaExtraordinaria actualizarCuotaExtraordinaria(Integer id, CuotaExtraordinaria cuotaExtraordinaria){
        CuotaExtraordinaria cuotaExistente = cuotaExtraordinariaRepository.findOne(id);
        BeanUtils.copyProperties(cuotaExtraordinaria,cuotaExistente);
        return cuotaExtraordinariaRepository.saveAndFlush(cuotaExistente);
    }

    //Pago
    public List<Pago> mostrarPagos(){ return pagoRepository.findAll(); }
    public Pago buscarPago(Integer id) {return pagoRepository.findOne(id);}
    public Pago crearPago(Integer idSocio , Integer idServicio , TipoPago tipoPago , Double monto){
        Socio socio=socioRepository.findOne(idSocio);
        if(tipoPago==TipoPago.EVENTO){
            Evento evento= eventoRepository.findOne(idServicio);
            Pago nuevoPago = new Pago(null,null,monto,evento.getFechaInicio(),null,null,new Date(),EstadoPago.REGISTRADO,tipoPago,
                    null,socio,evento,null,null,null,null);
            return pagoRepository.saveAndFlush(nuevoPago);
        }
        else if(tipoPago==TipoPago.BUNGALOW){
            ReservaBungalow reservaBungalow = reservaBungalowRepository.findOne(idServicio);
            Pago nuevoPago = new Pago(null,null,monto,reservaBungalow.getFechaReserva(),null,null,new Date(),EstadoPago.REGISTRADO,
                    tipoPago,null,socio,null,reservaBungalow.getBungalow(),null,null,null);
            return pagoRepository.saveAndFlush(nuevoPago);

        }
        else if(tipoPago==TipoPago.CLASE){
            RegistroClase registroClase= registroClaseRepository.findOne(idServicio);
            Pago nuevoPago = new Pago(null,null,monto,registroClase.getClase().getCiclo().getFechaInicio(),null,null,new Date(),EstadoPago.REGISTRADO,
                    tipoPago,null,socio,null,null,registroClase.getClase(),null,null);
            return pagoRepository.saveAndFlush(nuevoPago);
        }
        else if(tipoPago==TipoPago.INSTALACION){
            ReservaInstalacion reservaInstalacion= reservaInstalacionRepository.findOne(idServicio);
            Pago nuevoPago= new Pago(null,null,monto,reservaInstalacion.getFechaReserva(),null,null,new Date(),EstadoPago.REGISTRADO,
                    tipoPago,null,socio,null,null,null,reservaInstalacion.getInstalacion(),null);
            return pagoRepository.saveAndFlush(nuevoPago);
        }
        else if(tipoPago==TipoPago.MULTA){
            Date fechaFinal = new Date();
            fechaFinal.setTime(fechaFinal.getTime() + 7 * 24 * 60 * 60 * 1000);
            Multa multa=multaRepository.findOne(idServicio);
            Pago nuevoPago= new Pago(null,null,monto,fechaFinal,null,null,new Date(),EstadoPago.REGISTRADO,TipoPago.MULTA,null,
                    socio,null,null,null,null,multa);
            return pagoRepository.saveAndFlush(nuevoPago);
        }
        return null;
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
        Pago nuevoPago = new Pago(null,null,pago,fechaFinal,null,null,fechaInicial, EstadoPago.REGISTRADO,TipoPago.MEMBRESIA,null,socio,null,null,null,null,null);
        pagoRepository.saveAndFlush(nuevoPago);
        return nuevoPago;
    }

    public List<CuotaExtraordinaria> crearCuotasExtraordinarias(CuotaExtraordinaria replica){
        List<Socio> socios= socioRepository.findAll();
        List<CuotaExtraordinaria> respuesta=new ArrayList<CuotaExtraordinaria>();
        for(Socio item:socios){
            CuotaExtraordinaria nuevaCuota= new CuotaExtraordinaria(replica.getNombre(),replica.getDescripcion(),
                    replica.getMonto(),replica.getFechaInicio(),replica.getFechaFin(),EstadoCuotaExtraordinaria.REGISTRADA,
                    item,replica.getClub());
            cuotaExtraordinariaRepository.saveAndFlush(nuevaCuota);
            respuesta.add(nuevaCuota);
        }
        return respuesta;
    }

}
