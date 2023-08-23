package com.example.pw3.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Categoria {
    @Id
    private long id;

    private String nome;
}
