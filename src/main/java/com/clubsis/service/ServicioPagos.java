package com.clubsis.service;

import com.clubsis.model.bungalow.Bungalow;
import com.clubsis.model.bungalow.ReservaBungalow;
import com.clubsis.model.clase.RegistroClase;
import com.clubsis.model.club.Multa;
import com.clubsis.model.evento.Evento;
import com.clubsis.model.pago.*;
import com.clubsis.model.persona.EstadoSocio;
import com.clubsis.model.persona.Socio;
import com.clubsis.model.persona.TipoSocio;
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
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
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
        Pago pagoExistente= buscarPagoExistente(socio,idServicio,tipoPago);
        if(pagoExistente!=null){//Actualizar pago en caso exista
            pagoExistente.setMontoTotal(monto);
            return pagoRepository.saveAndFlush(pagoExistente);
        }
        else if(tipoPago==TipoPago.EVENTO){
            Evento evento= eventoRepository.findOne(idServicio);
            Pago nuevoPago = new Pago(null,null,monto,evento.getFechaInicio(),null,null,new Date(),EstadoPago.REGISTRADO,tipoPago,
                    null,socio,evento,null,null,null,null);
            return pagoRepository.saveAndFlush(nuevoPago);
        }
        else if(tipoPago==TipoPago.BUNGALOW){
            ReservaBungalow reservaBungalow = reservaBungalowRepository.findOne(idServicio);
            Pago nuevoPago = new Pago(null,null,monto,reservaBungalow.getFechaReserva(),null,null,new Date(),EstadoPago.REGISTRADO,
                    tipoPago,null,socio,null,reservaBungalow,null,null,null);
            return pagoRepository.saveAndFlush(nuevoPago);

        }
        else if(tipoPago==TipoPago.CLASE){
            RegistroClase registroClase= registroClaseRepository.findOne(idServicio);
            Pago nuevoPago = new Pago(null,null,monto,registroClase.getClase().getCiclo().getFechaInicio(),null,null,new Date(),EstadoPago.REGISTRADO,
                    tipoPago,null,socio,null,null,registroClase,null,null);
            return pagoRepository.saveAndFlush(nuevoPago);
        }
        else if(tipoPago==TipoPago.INSTALACION){
            ReservaInstalacion reservaInstalacion= reservaInstalacionRepository.findOne(idServicio);
            Pago nuevoPago= new Pago(null,null,monto,reservaInstalacion.getFechaReserva(),null,null,new Date(),EstadoPago.REGISTRADO,
                    tipoPago,null,socio,null,null,null,reservaInstalacion,null);
            return pagoRepository.saveAndFlush(nuevoPago);
        }
        else if(tipoPago==TipoPago.MULTA){
            Date fechaFinal = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(fechaFinal);
            calendar.add(Calendar.DATE,7);
            fechaFinal.setTime(calendar.getTime().getTime());
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

    public Pago buscarPagoExistente(Socio socio, Integer idServicio,TipoPago tipoPago){
        List<Pago> pagos = new ArrayList<>(socio.getPagos());
        for(Pago item:pagos){
            if(tipoPago==TipoPago.EVENTO){
                if(item.getEvento().getId()==idServicio)    return item;
            }
            else if(tipoPago==TipoPago.BUNGALOW){
                ReservaBungalow reservaBungalow = reservaBungalowRepository.findOne(idServicio);
                if(item.getReservaBungalow().getId()==reservaBungalow.getId())   return item;
            }
            else if(tipoPago==TipoPago.CLASE){
                RegistroClase registroClase= registroClaseRepository.findOne(idServicio);
                if(item.getRegistroClase().getId()==registroClase.getId())   return item;
            }
            else if(tipoPago==TipoPago.INSTALACION){
                ReservaInstalacion reservaInstalacion= reservaInstalacionRepository.findOne(idServicio);
                if(item.getReservaInstalacion().getId()==reservaInstalacion.getId())   return item;
            }
        }
        return null;
    }


    //ADICIONALES

    public Pago primerPago(Socio socio) {
        Date fechaFinal = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaFinal);
        calendar.add(Calendar.DATE,7);
        fechaFinal.setTime(calendar.getTime().getTime());
        Double pago= socio.getTipo().getCostoInicial()+socio.getTipo().getCostoMembresia();
        Pago nuevoPago = new Pago(null,null,pago,fechaFinal,null,null,new Date(), EstadoPago.REGISTRADO,TipoPago.MEMBRESIA,null,socio,null,null,null,null,null);
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

    public Pago anularPago(Integer idPago){
        Pago pago= pagoRepository.findOne(idPago);
        pago.setEstadoPago(EstadoPago.ANULADO);
        return pagoRepository.saveAndFlush(pago);
    }

    public CuotaExtraordinaria anularCuotaExtraordinaria(Integer idCuota){
        CuotaExtraordinaria cuota= cuotaExtraordinariaRepository.findOne(idCuota);
        cuota.setEstadoCuotaExtraordinaria(EstadoCuotaExtraordinaria.ANULADA);
        return cuotaExtraordinariaRepository.saveAndFlush(cuota);
    }

    public Pago realizarPago(Integer idPago){
        Pago pago= pagoRepository.findOne(idPago);
        pago.setEstadoPago(EstadoPago.PAGADO);
        return pagoRepository.saveAndFlush(pago);
    }

    public CuotaExtraordinaria pagarCuotaExtraordinaria(Integer idCuota){
        CuotaExtraordinaria cuota= cuotaExtraordinariaRepository.findOne(idCuota);
        cuota.setEstadoCuotaExtraordinaria(EstadoCuotaExtraordinaria.PAGADA);
        return cuotaExtraordinariaRepository.saveAndFlush(cuota);
    }

    //@Scheduled(cron="*/10 * * * * *")// cada 10 segundos
    @Scheduled(cron="0 0 0 1 * ?")// primer dia de cada mes
    public void crearPagosMembresia(){
        List<Socio> socios=socioRepository.findAll();
        Date fechaFinal = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaFinal);
        calendar.add(Calendar.DATE,7);
        fechaFinal.setTime(calendar.getTime().getTime());
        for(Socio item:socios){
            if(item.getEstado()!= EstadoSocio.ACTIVO)   continue; //SOLO PAGARA MEMBRESIA UN SOCIO ACTIVO
            TipoSocio tipoSocio= item.getTipo();
            Pago nuevoPago = new Pago(null,null,tipoSocio.getCostoMembresia(),fechaFinal,null,null,new Date(), EstadoPago.REGISTRADO,TipoPago.MEMBRESIA,null,item,null,null,null,null,null);
            pagoRepository.saveAndFlush(nuevoPago);
        }
    }


    //@Scheduled(cron="*/10 * * * * *")// cada 10 segundos
    @Scheduled(cron="0 0 0 * * ?")// cada dia
    public void actualizarPagos(){
        List<Pago> pagos=pagoRepository.findAll();
        for(Pago item:pagos){
            if(item.getFechaVencimiento().before(new Date()) && item.getEstadoPago()==EstadoPago.REGISTRADO){
                item.setEstadoPago(EstadoPago.VENCIDO);
                pagoRepository.saveAndFlush(item);
            }
        }
        List<CuotaExtraordinaria> cuotas=cuotaExtraordinariaRepository.findAll();
        for(CuotaExtraordinaria item:cuotas){
            if(item.getFechaFin().before(new Date()) && item.getEstadoCuotaExtraordinaria()==EstadoCuotaExtraordinaria.REGISTRADA){
                item.setEstadoCuotaExtraordinaria(EstadoCuotaExtraordinaria.VENCIDA);
                cuotaExtraordinariaRepository.saveAndFlush(item);
            }

        }

    }




}
