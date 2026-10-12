package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.entities.Personagem;
import com.example.demo.service.PersonagemService;

@RestController
@RequestMapping("/adventurer")
public class AdventurerController {

    private final PersonagemService personagemService;

    public AdventurerController(PersonagemService personagemService) {
        this.personagemService = personagemService;
    }

    @GetMapping("/status")
    public ResponseEntity<Personagem> status() {
        return ResponseEntity.ok(personagemService.buscarPersonagem());
    }
}