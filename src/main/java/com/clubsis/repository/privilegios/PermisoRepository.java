package com.clubsis.repository.privilegios;

import com.clubsis.model.privilegio.Permiso;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Lati on 24.05.2016.
 */
public interface PermisoRepository extends JpaRepository<Permiso, Integer> {
}
