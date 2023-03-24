package com.addname.demo.controler;

import com.addname.demo.excepciones.ResourceNoFoundException;
import com.addname.demo.modelo.Producto;
import com.addname.demo.repositorio.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ResponseStatus(HttpStatus.OK)
@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductoControlador {

    @Autowired
    private ProductoRepositorio repositorio;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/productos")
    public List<Producto> listarLosProductos() {

        return repositorio.findAll();

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/productos")
    public Producto guardarProducto(@RequestBody Producto producto) {
        return repositorio.save(producto);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/productos/{id}")
    public ResponseEntity<Producto> obtenerProductoPorId(@PathVariable Long id) {
        Producto producto = repositorio.findById(id)
                .orElseThrow(() -> new ResourceNoFoundException("No existe el producto con el ID :" + id));
        return ResponseEntity.ok(producto);

    }


    @PatchMapping("/productos/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable Long id, @RequestBody Producto detallesProducto) {
        Producto producto = repositorio.findById(id)
                .orElseThrow(() -> new ResourceNoFoundException("No existe el producto con el ID :" + id));
        if (detallesProducto.getNombre() != null) {
            producto.setNombre(detallesProducto.getNombre());
        }
        if (detallesProducto.getCodigo() != null) {
            producto.setCodigo(detallesProducto.getCodigo());
        }
        if (detallesProducto.getStock() != null) {
            producto.setStock(detallesProducto.getStock());
        }
        if (detallesProducto.getPrecioIva() != null) {
            producto.setPrecioIva(detallesProducto.getPrecioIva());
        }
        Producto productoActualizado = repositorio.save(producto);
        return ResponseEntity.ok(productoActualizado);
    }

    @DeleteMapping("/producto/{id}")
    public ResponseEntity<Map<String,Boolean>> eliminarProducto(@PathVariable Long id){
        Producto producto = repositorio.findById(id)
                .orElseThrow(() -> new ResourceNoFoundException ("No existe el producto con el ID : " + id));

        repositorio.delete(producto);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminar",Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
}}