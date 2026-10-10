package com.example.demo.controller;

import com.example.demo.model.Personagem;
import com.example.demo.service.PersonagemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * PersonagemController
 */
@RestController
@RequestMapping("/personagem")
@RequiredArgsConstructor
public class PersonagemController {

    private final PersonagemService personagemService = null;

    @GetMapping
    public Personagem buscarPersonagem() {
        return personagemService.buscarPersonagem();
    }

    @PostMapping("/dano/{dano}")
    public Personagem receberDano(@PathVariable int dano) {
        return personagemService.receberDano(dano);
    }

    @PostMapping("/recuperar/{quantidade}")
    public Personagem recuperarVida(@PathVariable int quantidade) {
        return personagemService.recuperarVida(quantidade);
    }
}
