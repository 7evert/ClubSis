package com.clubsis.repository.producto;

import com.clubsis.model.producto.Producto_Sede;
import com.clubsis.model.producto.Producto_SedeID;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Vivian on 7/06/2016.
 */

public interface Producto_SedeRepository extends JpaRepository<Producto_Sede,Producto_SedeID> {

}
