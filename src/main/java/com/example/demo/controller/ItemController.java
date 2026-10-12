package com.example.demo.controller;

import com.example.demo.model.equipment.ItemNotFoundException;
import com.example.demo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    // POST
    @PostMapping("/use/{itemName}")
    public String useItem(@PathVariable String itemName) throws ItemNotFoundException {
        itemService.useItem(itemName);
        return "Success! The item '" + itemName + "' was used and its effect applied.";
    }
}
