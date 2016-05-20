package com.clubsis.controller.producto;
import com.clubsis.model.producto.Producto;
import com.clubsis.service.ServicioProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * Created by Vivian on 20/05/2016.
 */
@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    @Autowired
    private ServicioProducto servicioProducto;

    @RequestMapping(method = RequestMethod.GET)
    public List<Producto> list() {
        return servicioProducto.mostrarProductos();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Producto get(@PathVariable Integer id) {
        return servicioProducto.buscarProducto(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Producto create(@RequestBody Producto producto) {
        return servicioProducto.crearProducto(producto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Producto update(@PathVariable Integer id, @RequestBody Producto producto) {
        return servicioProducto.actualizarProducto(id, producto);
    }
}
