package com.example.demo.model.equipment;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Collectible extends Item {
    public Collectible(String name, ItemType type, Rarity rarity) {
        super(name, type, rarity);
    }
}