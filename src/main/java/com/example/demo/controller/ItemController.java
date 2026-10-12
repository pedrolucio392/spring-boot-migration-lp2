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
    @PostMapping("/use/{nomeDoItem}")
    public String useItem(@PathVariable String nomeDoItem) throws ItemNotFoundException {
        itemService.usarItem(nomeDoItem);
        return "Success! The item '" + nomeDoItem + "' was used and its effect applied.";
    }
}
