package com.example.pw3.controllers;

import java.util.Collection;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.pw3.models.Categoria;
import com.example.pw3.services.CategoriaService;

@RestController
@RequestMapping(value = "/categoria")
public class CategoriaController {
    private CategoriaService service;

    public CategoriaController(CategoriaService service) {
        this.service = service;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<Collection<Categoria>> findAll() {
        Collection<Categoria> categorias = service.findAll();

        return ResponseEntity.ok(categorias);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<Categoria> save(@RequestBody Categoria categoria) {
        Categoria categoriaSalva = service.save(categoria);

        return ResponseEntity.ok(categoriaSalva);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity<Categoria> delete(@RequestBody Long id) {
        Categoria categoria = service.findById(id);
        service.delete(categoria);

        return ResponseEntity.ok(categoria);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<Categoria> updateById(@RequestBody Long id) {
        Categoria categoria = service.updateById(id);

        return ResponseEntity.ok(categoria);
    }

}
