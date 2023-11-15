package com.example.pw3.services;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.example.pw3.dto.ResumoDTO;
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
        repository.delete(conta);
    }

    public Conta updateById(Conta conta) {
        Conta contaAtualizada = repository.findById(conta.getId())
                .orElseThrow(() -> new RuntimeException("Conta não encontrada"));
        contaAtualizada = conta;
        return repository.save(contaAtualizada);
    }

    public ResumoDTO resumo() {
        Collection<Conta> despesas = repository.findByTipo(Conta.TIPO_DESPESA);
        Collection<Conta> receitas = repository.findByTipo(Conta.TIPO_RECEITA);

        double totalDespesa = despesas.stream().mapToDouble(d -> d.getValor()).sum();
        double totalReceita = receitas.stream().mapToDouble(r -> r.getValor()).sum();
        double totalSaldo = totalReceita - totalDespesa;

        ResumoDTO resumo = new ResumoDTO();
        
        resumo.setTotalDespesa(totalDespesa);
        resumo.setTotalReceita(totalReceita);
        resumo.setSaldo(totalSaldo);

        return resumo;
    }
}
