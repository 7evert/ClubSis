package com.clubsis.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.clubsis.repository.producto.ProveedorRepository;
import com.clubsis.model.producto.Proveedor;
import com.clubsis.repository.producto.OrdenCompraRepository;
import com.clubsis.model.producto.OrdenCompra;
import com.clubsis.repository.producto.ProductoRepository;
import com.clubsis.model.producto.Producto;

import java.util.List;


/**
 * Created by Vivian on 20/05/2016.
 */
@Service
public class ServicioProducto {
    @Autowired
    private ProveedorRepository proveedorRepository;
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private OrdenCompraRepository ordenCompraRepository;

    //Proveedores
    public List<Proveedor> mostrarProveedores() {
        return proveedorRepository.findAll();
    }

    public Proveedor crearProveedor(Proveedor proveedor) {
        return proveedorRepository.saveAndFlush(proveedor);
    }

    public Proveedor buscarProveedor(Integer id) {
        return proveedorRepository.findOne(id);
    }

    public Proveedor actualizarProveedor(Integer id, Proveedor proveedor) {
        Proveedor proveedorExistente = proveedorRepository.findOne(id);
        BeanUtils.copyProperties(proveedor, proveedorExistente);
        return proveedorRepository.saveAndFlush(proveedorExistente);
    }

    //Producto
    public  List<Producto> mostrarProductos(){
        return productoRepository.findAll();
    }

    public Producto crearProducto(Producto producto){
        return productoRepository.saveAndFlush(producto);
    }

    public Producto buscarProducto(Integer id){
        return productoRepository.findOne(id);
    }

    public Producto actualizarProducto(Integer id, Producto producto) {
        Producto productoExistente = productoRepository.findOne(id);
        BeanUtils.copyProperties(producto, productoExistente);
        return productoRepository.saveAndFlush(productoExistente);
    }

    //OrdenCompra
    public  List<OrdenCompra> mostrarOrdenCompra(){
        return ordenCompraRepository.findAll();
    }

    public OrdenCompra crearOrdenCompra(OrdenCompra orden){
        return ordenCompraRepository.saveAndFlush(orden);
    }

    public OrdenCompra buscarOrdenCompra(Integer id){
        return ordenCompraRepository.findOne(id);
    }

    public OrdenCompra actualizarOrdenCompra(Integer id, OrdenCompra producto) {
        OrdenCompra ordenCompraExistente = ordenCompraRepository.findOne(id);
        BeanUtils.copyProperties(producto, ordenCompraExistente);
        return ordenCompraRepository.saveAndFlush(ordenCompraExistente);
    }




}
