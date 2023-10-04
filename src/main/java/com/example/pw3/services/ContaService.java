package com.example.pw3.services;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.example.pw3.models.Conta;
import com.example.pw3.repositories.ContaRepository;

@Service
public class ContaService {

    private ContaRepository repository;

    public ContaService(ContaRepository repository) {
        this.repository = repository;
    }

    public Collection<Conta> findAll() {
        return repository.findAll();
    }

    public Conta findById(Long id) {
        Conta conta = repository.findById(id).orElseThrow(() -> new RuntimeException("Conta não encontrada!"));
        return conta;
    }

    public Conta save(Conta conta) {
        return repository.save(conta);
    }

    public void delete(Conta conta) {
        repository.deleteById(conta.getId());
    }

    public Conta updateById(Long id) {
        Conta contaAtualizada = repository.findById(id).orElseThrow(() -> new RuntimeException("Conta não encontrada"));
        return repository.save(contaAtualizada);
    }
}
