package com.clubsis.repository.club;

import org.springframework.data.jpa.repository.JpaRepository;
import com.clubsis.model.club.Usuario;
/**
 * Created by Juan Tenorio on 1/5/2016.
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
