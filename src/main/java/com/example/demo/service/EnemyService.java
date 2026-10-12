package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.entities.enemies.*;

/**
 * MonstroService
 */
@Service
public class EnemyService {

    private final Enemy enemy = new Goblin("Teste", 20);

    public Enemy receberDano(int dano) {

        int novaVida = enemy.getLife() - dano;

        if (novaVida < 0) {
            novaVida = 0;
        }

        enemy.setLife(novaVida);

        return enemy;
    }

    public Enemy buscarEnemy() {
        return this.enemy;
    }
}