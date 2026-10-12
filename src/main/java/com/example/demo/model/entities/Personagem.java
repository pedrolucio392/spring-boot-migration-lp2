package com.example.demo.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Personagem
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Personagem {

    private String nome;
    private int vida;
    private int dano;
    private int gold;
}
