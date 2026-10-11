package com.example.demo.model.entities.enemies;
import com.example.demo.model.entities.Entity;

public abstract class Enemy extends Entity {
    public Enemy(String name, int coins) {
        super(name, coins);
    }
    public abstract int attack();
}
