package com.example.demo.model.equipment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Weapon extends Item {
    private int damage;

    public Weapon(String name, ItemType type, Rarity rarity, int damage) {
        super(name, type, rarity);
        if (damage < 0) {
            throw new IllegalArgumentException("Weapon damage cannot be negative.");
        }
        this.damage = damage;
    }
}