package com.clubsis.repository.club;

import com.clubsis.model.club.Sancion;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Juan Tenorio on 1/5/2016.
 */
public interface SancionRepository extends JpaRepository<Sancion, Integer> {
}
