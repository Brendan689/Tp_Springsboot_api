package com.bibliotheque.api.controller;

import com.bibliotheque.api.entity.Livre;
import com.bibliotheque.api.service.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController               
@RequestMapping("/api/livres") 
public class LivreController {

    @Autowired
    private LivreService livreService;

    //GET
    @GetMapping
    public ResponseEntity<List<Livre>> getAllLivres() {
        List<Livre> livres = livreService.getAllLivres();
        return ResponseEntity.ok(livres); 
    }

    //GET
    @GetMapping("/{id}")
    public ResponseEntity<Livre> getLivreById(@PathVariable Long id) {
        return livreService.getLivreById(id)
                .map(livre -> ResponseEntity.ok(livre))           
                .orElse(ResponseEntity.notFound().build());       
    }

//POST
    @PostMapping
    public ResponseEntity<Livre> createLivre(@Valid @RequestBody LivreRequest request) {
        Livre nouveauLivre = livreService.createLivre(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(nouveauLivre);  
    }

    //PUT
    @PutMapping("/{id}")
    public ResponseEntity<Livre> updateLivre(@PathVariable Long id,
                                              @RequestBody Livre livre) {
        return livreService.updateLivre(id, livre)
                .map(livreModifie -> ResponseEntity.ok(livreModifie))
                .orElse(ResponseEntity.notFound().build());
    }

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLivre(@PathVariable Long id) {
        if (livreService.deleteLivre(id)) {
            return ResponseEntity.noContent().build();    
        }
        return ResponseEntity.notFound().build();        
    }

    //GET
    @GetMapping("/search")
    public ResponseEntity<List<Livre>> searchByTitre(@RequestParam String titre) {
        List<Livre> livres = livreService.searchByTitre(titre);
        return ResponseEntity.ok(livres);
    }

    //GET
    @GetMapping("/categorie/{categorie}")
    public ResponseEntity<List<Livre>> getByCategorie(
            @PathVariable Livre.Categorie categorie) {
        List<Livre> livres = livreService.getByCategorie(categorie);
        return ResponseEntity.ok(livres);
    }

}