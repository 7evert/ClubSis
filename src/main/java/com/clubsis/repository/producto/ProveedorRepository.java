package com.clubsis.repository.producto;

import org.springframework.data.jpa.repository.JpaRepository;
import com.clubsis.model.producto.Proveedor;

/**
 * Created by Vivian on 20/05/2016.
 */
public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {
}
