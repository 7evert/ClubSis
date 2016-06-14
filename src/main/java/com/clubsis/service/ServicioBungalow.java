package com.clubsis.service;

import com.clubsis.model.bungalow.EstadoBungalow;
import com.clubsis.repository.bungalow.BungalowRepository;
import com.clubsis.repository.bungalow.ReservaBungalowRepository;
import com.clubsis.repository.bungalow.TipoBungalowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by gerson on 7/06/2016.
 */
@Service
public class ServicioBungalow {
    @Autowired
    private BungalowRepository bungalowRepository;

    @Autowired
    private TipoBungalowRepository tipoBungalowRepository;

    public EstadoBungalow[] getEstadoBungalow(){
        return EstadoBungalow.values();
    }
}
