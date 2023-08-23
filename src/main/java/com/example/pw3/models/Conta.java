package com.example.pw3.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Conta {
    static final boolean DESPESA = true;
    static final boolean RECEITA = false;

    @Id
    private long id;

    @ManyToOne
    private Categoria categoria;

    private boolean tipo;
    private LocalDate data;
    private String descricao;
    private double valor;
    private String destinoOrigem;
    private boolean pagoRecebido;
}
