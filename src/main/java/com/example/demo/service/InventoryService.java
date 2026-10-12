package com.example.demo.service;

import java.util.Set;

import com.example.demo.model.equipment.Inventory;
import com.example.demo.model.equipment.Item;

import org.springframework.stereotype.Service;

/**
 * InventoryService
 */
@Service
public class InventoryService {
    private final Inventory<Item> playerInventory = new Inventory<>();

    public Inventory<Item> getPlayerInventory() {
        return playerInventory;
    }

    public void addItem(Item item, Integer quantity) {
        playerInventory.insertItem(item, quantity);
    }

    public void removeItem(Item item, Integer quantity) {
        playerInventory.removeItem(item, quantity);
    }

    public Boolean hasItem(Item item) {
        return playerInventory.hasItem(item);
    }

    public Set<Item> getItems() {
        return playerInventory.getItemsKeys();
    }
}
