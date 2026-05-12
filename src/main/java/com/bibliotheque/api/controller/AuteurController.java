package com.bibliotheque.api.controller;

import com.bibliotheque.api.entity.Auteur;
import com.bibliotheque.api.service.AuteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auteurs")
public class AuteurController {
    @Autowired
    private AuteurService auteurService;

    @GetMapping
    public List<Auteur> getAllAuteurs() { return auteurService.getAllAuteurs(); }

    @PostMapping
    public ResponseEntity<Auteur> createAuteur(@RequestBody Auteur auteur) {
        return ResponseEntity.status(HttpStatus.CREATED).body(auteurService.createAuteur(auteur));
    }
}