package com.example.demo.model.equipment;

import java.util.Objects;
import com.example.demo.model.entities.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public abstract class Item {
    private String name;
    private ItemType type;
    private Rarity rarity;

    public Item(String name, ItemType type, Rarity rarity) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("equipment.Item name cannot be empty or null.");
        }
        if (type == null) {
            throw new IllegalArgumentException("equipment.Item type cannot be null.");
        }
        if (rarity == null) {
            throw new IllegalArgumentException("equipment.Item rarity cannot be null.");
        }

        this.name = name;
        this.type = type;
        this.rarity = rarity;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Item otherItem = (Item) obj;

        return Objects.equals(this.name, otherItem.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name);
    }

    @Override
    public String toString() {
        return this.getName();
    }

    public void use(Entity entity) {
        throw new UnsupportedOperationException("Unimplemented method 'use'");
    }
}
