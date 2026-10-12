package com.example.demo.service;

import com.example.demo.model.equipment.Collectible;
import com.example.demo.model.equipment.Item;
import com.example.demo.model.equipment.ItemType;
import com.example.demo.model.equipment.Potion;
import com.example.demo.model.equipment.Rarity;
import com.example.demo.model.equipment.Weapon;
import com.example.demo.model.equipment.ItemNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {

    // Simula o inventário
    private final List<Item> availableItems = new ArrayList<>();

    public ItemService() {
        availableItems.add(new Potion("Potion of Health", ItemType.CONSUMABLE, Rarity.COMMON, 50));
        availableItems.add(new Potion("Potion of Mana", ItemType.CONSUMABLE, Rarity.RARE, 30));
        
        availableItems.add(new Weapon("Sword", ItemType.EQUIPMENT, Rarity.COMMON, 15));

        availableItems.add(new Collectible("Goblin Head", ItemType.COLLECTIBLE, Rarity.LEGENDARY));
    }

    // Método auxiliar para buscar o item e lançar a sua Exceção se der erro
    public Item searchItem(String itemName) throws ItemNotFoundException {
        return availableItems.stream()
                .filter(item -> item.getName().equalsIgnoreCase(itemName))
                .findFirst()
                .orElseThrow(() -> new ItemNotFoundException("Item '" + itemName + "' doesn't exist in the inventory."));
    }

    // Lógica principal
    public String useItem(String itemName) throws ItemNotFoundException {
        
        Item item = searchItem(itemName);

        if (item.getType() != ItemType.CONSUMABLE) {
            throw new IllegalArgumentException("You cannot use the item '" + itemName + "', as it is not consumable!");
        }

        return "The item " + item.getName() + " was used successfully!";
    }
}