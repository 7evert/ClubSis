package com.clubsis.repository.persona;

import org.springframework.data.jpa.repository.JpaRepository;
import com.clubsis.model.persona.Persona;
/**
 * Created by Juan Tenorio on 1/5/2016.
 */
public interface PersonaRepository extends JpaRepository<Persona, Long> {
}
