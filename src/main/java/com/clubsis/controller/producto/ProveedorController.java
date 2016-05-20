package com.clubsis.controller.producto;

import com.clubsis.model.producto.Proveedor;
import com.clubsis.service.ServicioProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Vivian on 20/05/2016.
 */

@RestController
@RequestMapping("/api/proveedor")
public class ProveedorController {

    @Autowired
    private ServicioProducto servicioProducto;

    @RequestMapping(method = RequestMethod.GET)
    public List<Proveedor> list() {
        return servicioProducto.mostrarProveedores();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Proveedor get(@PathVariable Integer id) {
        return servicioProducto.buscarProveedor(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Proveedor create(@RequestBody Proveedor proveedor) {
        return servicioProducto.crearProveedor(proveedor);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Proveedor update(@PathVariable Integer id, @RequestBody Proveedor proveedor) {
        return servicioProducto.actualizarProveedor(id, proveedor);
    }
}
