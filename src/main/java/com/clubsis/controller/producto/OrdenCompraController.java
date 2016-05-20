package com.clubsis.controller.producto;
import com.clubsis.model.producto.EstadoOrdenCompra;
import com.clubsis.model.producto.OrdenCompra;
import com.clubsis.service.ServicioProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * Created by Vivian on 20/05/2016.
 */
@RestController
@RequestMapping("/api/ordenCompra")
public class OrdenCompraController {
    @Autowired
    private ServicioProducto servicioProducto;

    @RequestMapping(method = RequestMethod.GET)
    public List<OrdenCompra> list() {
        return servicioProducto.mostrarOrdenCompra();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public OrdenCompra get(@PathVariable Integer id) {
        return servicioProducto.buscarOrdenCompra(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public OrdenCompra create(@RequestBody OrdenCompra orden) { return servicioProducto.crearOrdenCompra(orden);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public OrdenCompra update(@PathVariable Integer id, @RequestBody OrdenCompra orden) {
        return servicioProducto.actualizarOrdenCompra(id, orden);
    }
}
