package com.clubsis.repository.evento;
import com.clubsis.model.evento.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * Created by Juan Tenorio on 17/5/2016.
 */
public interface EventoRepository extends JpaRepository<Evento, Integer>  {
}
