package com.clubsis.repository.evento;
import com.clubsis.model.evento.Tarifa;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * Created by Juan Tenorio on 17/5/2016.
 */
public interface TarifaEventoRepository extends JpaRepository<Tarifa, Integer> {
}