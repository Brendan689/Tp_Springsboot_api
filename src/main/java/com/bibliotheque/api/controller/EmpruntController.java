package com.bibliotheque.api.controller;

import com.bibliotheque.api.dto.EmpruntRequest;
import com.bibliotheque.api.entity.Emprunt;
import com.bibliotheque.api.service.EmpruntService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/emprunts")
public class EmpruntController {

    @Autowired
    private EmpruntService empruntService;

    @GetMapping
    public List<Emprunt> getAll() {
        return empruntService.getAllEmprunts();
    }

    @PostMapping
    public ResponseEntity<Emprunt> create(@Valid @RequestBody EmpruntRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(empruntService.createEmprunt(request));
    }

    @PatchMapping("/{id}/retour")
    public ResponseEntity<Emprunt> retour(@PathVariable Long id) {
        return ResponseEntity.ok(empruntService.enregistrerRetour(id));
    }
}