package com.bibliotheque.api.controller;

import com.bibliotheque.api.dto.ExemplaireRequest;
import com.bibliotheque.api.entity.Exemplaire;
import com.bibliotheque.api.service.ExemplaireService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exemplaires")
public class ExemplaireController {

    @Autowired
    private ExemplaireService exemplaireService;

    //GET
    @GetMapping
    public ResponseEntity<List<Exemplaire>> getAllExemplaires() {
        return ResponseEntity.ok(exemplaireService.getAllExemplaires());
    }

    //POST
    @PostMapping
    public ResponseEntity<Exemplaire> createExemplaire(@Valid @RequestBody ExemplaireRequest request) {
        Exemplaire nouveau = exemplaireService.createExemplaire(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(nouveau);
    }

    //GET
    public ResponseEntity<List<Exemplaire>> getExemplairesByLivre(@PathVariable Long livreId) {
        return ResponseEntity.ok(exemplaireService.getExemplairesByLivre(livreId));
    }

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExemplaire(@PathVariable Long id) {
        exemplaireService.deleteExemplaire(id);
        return ResponseEntity.noContent().build();
    }
}