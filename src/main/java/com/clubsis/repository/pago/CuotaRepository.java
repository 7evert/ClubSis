package com.clubsis.repository.pago;

import org.springframework.data.jpa.repository.JpaRepository;
import com.clubsis.model.pago.Cuota;
/**
 * Created by Juan Tenorio on 1/5/2016.
 */
public interface CuotaRepository extends JpaRepository<Cuota, Integer> {

}
