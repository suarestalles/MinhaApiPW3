package com.example.pw3.controllers;

import java.util.Collection;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.pw3.dto.ResumoDTO;
import com.example.pw3.models.Conta;
import com.example.pw3.services.ContaService;

@RestController
@RequestMapping(value = "/conta")
public class ContaController {
    private ContaService service;

    public ContaController(ContaService service) {
        this.service = service;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<Collection<Conta>> findAll() {
        Collection<Conta> contas = service.findAll();

        return ResponseEntity.ok(contas);
    }

    @RequestMapping(value = "/findById", method = RequestMethod.GET)
    public ResponseEntity<Conta> findById(Long id) {
        Conta conta = service.findById(id);

        return ResponseEntity.ok(conta);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<Conta> save(@RequestBody Conta conta) {
        Conta contaSalva = service.save(conta);

        return ResponseEntity.ok(contaSalva);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity<Conta> delete(@RequestBody Conta conta) {
        service.delete(conta);

        return ResponseEntity.ok(conta);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<Conta> updateById(@RequestBody Conta conta) {
        Conta contaAtualizada = service.updateById(conta);

        return ResponseEntity.ok(contaAtualizada);
    }

    @RequestMapping(value = "/resumo", method = RequestMethod.GET)
    public ResponseEntity<ResumoDTO> resumo(Long id) {
        ResumoDTO resumo = service.resumo();

        return ResponseEntity.ok(resumo);
    }
}
