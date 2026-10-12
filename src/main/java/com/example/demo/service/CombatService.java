package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.entities.Personagem;
import com.example.demo.model.entities.enemies.Enemy;

/**
 * CombatService
 */
@Service
public class CombatService {
    private final PersonagemService personagemService;
    private final EnemyService enemyService;

    public CombatService(PersonagemService personagemService, EnemyService enemyService) {
        this.personagemService = personagemService;
        this.enemyService = enemyService;
    }

    public Enemy atacarEnemy() {

    Personagem personagem = personagemService.buscarPersonagem();

    if (personagem.getVida() <= 0) {
        throw new IllegalStateException("O personagem está morto e não pode atacar.");
    }

    if (enemyService.buscarEnemy().getLife() <= 0) {
        throw new IllegalStateException("O monstro já está morto.");
    }

    return enemyService.receberDano(personagem.getDano());
}

    public Personagem enemyRevidar() {

        Enemy enemy = enemyService.buscarEnemy();

        if (enemy.getLife() <= 0) {
            throw new IllegalStateException("O monstro está morto e não pode revidar.");
        }

        return personagemService.receberDano(enemy.getDamage());
    }

    public String turno() {
        Enemy enemy = atacarEnemy();
        if (enemy.getLife() == 0) {
            return "Você derrotou o " + enemy.getName() + "!";
        }
        Personagem personagem = enemyRevidar();
        if (personagem.getVida() == 0) {
            return "O " + enemy.getName() + " derrotou você!";
        }
        return "Você causou " + personagem.getDano() + " de dano no " + enemy.getName()
                + " (vida: " + enemy.getLife() + ") e recebeu " + enemy.getDamage()
                + " de volta (sua vida: " + personagem.getVida() + ").";
    }
}