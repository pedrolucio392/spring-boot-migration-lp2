package com.example.demo.controller;

import java.util.Set;

import com.example.demo.model.equipment.Inventory;
import com.example.demo.model.equipment.Item;
import com.example.demo.service.InventoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @GetMapping
    public ResponseEntity<Inventory<Item>> getPlayerInventory() {
        return ResponseEntity.ok(inventoryService.getPlayerInventory());
    }

    @PostMapping("/add")
    public ResponseEntity<String> addItem(@RequestBody Item item, @RequestParam(defaultValue = "1") Integer quantity) {
        inventoryService.addItem(item, quantity);

        return ResponseEntity.ok("Success! Added " + quantity + "x " + item.toString() + " to inventory.");
    }

    @PostMapping("/remove")
    public ResponseEntity<String> removeItem(@RequestBody Item item,
            @RequestParam(defaultValue = "1") Integer quantity) {
        inventoryService.removeItem(item, quantity);

        return ResponseEntity.ok("Success! Removed " + quantity + "x " + item.toString() + " on inventory.");
    }

    @PostMapping("/has")
    public ResponseEntity<Boolean> hasItem(@RequestBody Item item) {
        return ResponseEntity.ok(inventoryService.hasItem(item));
    }

    @GetMapping("/get")
    public ResponseEntity<Set<Item>> getItems() {
        return ResponseEntity.ok(inventoryService.getItems());
    }
}
