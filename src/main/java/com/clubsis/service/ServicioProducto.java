package com.clubsis.service;

import com.clubsis.model.producto.*;
import com.clubsis.repository.producto.Producto_SedeRepository;
import com.clubsis.repository.sede.SedeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.clubsis.repository.producto.ProveedorRepository;
import com.clubsis.repository.producto.OrdenCompraRepository;
import com.clubsis.repository.producto.ProductoRepository;

import java.util.ArrayList;
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
    @Autowired
    private Producto_SedeRepository producto_sedeRepository;
    @Autowired
    private SedeRepository sedeRepository;

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

    //Product_Sede
    public List<Producto_Sede> mostrarStocks(){return producto_sedeRepository.findAll(); }

    public Producto_Sede crearStockPorSede(Producto_Sede producto){
        return producto_sedeRepository.save(producto);
    }

    public Producto_Sede crearStock(Integer idProducto,Integer idSede){
        Producto_SedeID id = new Producto_SedeID(productoRepository.findOne(idProducto),sedeRepository.findOne(idSede));
        Producto_Sede stock = new Producto_Sede(id,0);
        return producto_sedeRepository.saveAndFlush(stock);
    }

    public Producto_Sede buscarStock(Integer idProducto,Integer idSede){
        Producto_SedeID id = new Producto_SedeID(productoRepository.findOne(idProducto),sedeRepository.findOne(idSede));
        return producto_sedeRepository.findOne(id);
    }

    public Producto_Sede actualizarStock(Integer idProducto, Integer idSede , Integer stock) {
        //Producto productoExistente = productoRepository.findOne(id);
        Producto_SedeID id = new Producto_SedeID(productoRepository.findOne(idProducto),sedeRepository.findOne(idSede));
        Producto_Sede stockAnterior = producto_sedeRepository.findOne(id);
        stockAnterior.setStock(stock);
        return producto_sedeRepository.saveAndFlush(stockAnterior);
    }

    public List<Producto_Sede> mostrarStockPorProducto(Integer idProducto){
        List<Producto_Sede> stocks = producto_sedeRepository.findAll();
        List<Producto_Sede> resultado = new ArrayList<Producto_Sede>();
        for (Producto_Sede item : stocks) {
            if(item.getProducto().getId()==idProducto){
                resultado.add(item);
            }
        }
        return resultado;
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
