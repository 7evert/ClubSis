package com.clubsis.repository.privilegios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.clubsis.model.privilegio.Rol;
/**
 * Created by Lati on 24.05.2016.
 */
public interface RolRepository extends JpaRepository<Rol, Integer> {
}
