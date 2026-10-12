package com.example.demo.model.entities.enemies;
import com.example.demo.model.entities.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
public abstract class Enemy extends Entity {
    public Enemy(String name, int coins) {
        super(name, coins);
    }
    public abstract int attack();
}
