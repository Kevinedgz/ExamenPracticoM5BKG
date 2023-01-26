package com.edu.exam.ExamenPracticoM5BKG.controller;

import com.edu.exam.ExamenPracticoM5BKG.model.Producto;
import com.edu.exam.ExamenPracticoM5BKG.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoController {
    @Autowired
     private ProductoService productoSer;

    @GetMapping("/listarpro")
    public ResponseEntity<List<Producto>> obtenerLista() {
        return new ResponseEntity<>(productoSer.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/crearpro")
    public ResponseEntity<Producto> crear(@RequestBody Producto c){
        return new ResponseEntity<>(productoSer.save(c), HttpStatus.CREATED);
    }

    @GetMapping("/buscarproducto/{id}")
    public Producto findbyid(@PathVariable Integer id){
        return productoSer.findById(id);
    }
    @PutMapping("/editarproducto/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Producto edit(@RequestBody Producto objeto, @PathVariable Integer id) {
        Producto productoedit=productoSer.findById(id);
        productoedit.setCodigo(objeto.getCodigo());
        productoedit.setDescripcion(objeto.getDescripcion());
        productoedit.setPrecio(objeto.getPrecio());
        productoedit.setCantidad(objeto.getCantidad());
        return productoSer.save(productoedit);
    }

    @DeleteMapping("/eliminarproducto/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@PathVariable Integer id) {
        productoSer.delete(id);
    }
}