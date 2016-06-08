package com.clubsis.controller.producto;

import com.clubsis.service.ServicioProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Vivian on 7/06/2016.
 */
@RestController
@RequestMapping("/api/stocks")
public class Producto_SedeController {
    @Autowired
    private ServicioProducto servicioProducto_Sede;

    @RequestMapping(method = RequestMethod.GET)
    public List<com.clubsis.model.producto.Producto_Sede> list() {
        return servicioProducto_Sede.mostrarStocks();
    }

    @RequestMapping(value = "/{idProducto}/{idSede}", method = RequestMethod.GET)
    public com.clubsis.model.producto.Producto_Sede get(@PathVariable Integer idProducto,@PathVariable Integer idSede) {
        return servicioProducto_Sede.buscarStock(idProducto,idSede);
    }

    @RequestMapping(value = "/{idProducto}/{idSede}", method = RequestMethod.POST)
    public com.clubsis.model.producto.Producto_Sede create(@PathVariable Integer idProducto, @PathVariable Integer idSede) {
        return servicioProducto_Sede.crearStock(idProducto,idSede);
    }

    @RequestMapping(value = "/{idProducto}/{idSede}/{stock}", method = RequestMethod.PUT)
    public com.clubsis.model.producto.Producto_Sede update(@PathVariable Integer idProducto, @PathVariable Integer idSede,@PathVariable Integer stock) {
        return servicioProducto_Sede.actualizarStock(idProducto, idSede,stock);
    }
}
