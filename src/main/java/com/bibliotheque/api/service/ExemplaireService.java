package com.bibliotheque.api.service;

import com.bibliotheque.api.dto.ExemplaireRequest;
import com.bibliotheque.api.entity.Exemplaire;
import com.bibliotheque.api.entity.Livre;
import com.bibliotheque.api.repository.ExemplaireRepository;
import com.bibliotheque.api.repository.LivreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExemplaireService {

    @Autowired
    private ExemplaireRepository exemplaireRepository;

    @Autowired
    private LivreRepository livreRepository;

    public List<Exemplaire> getAllExemplaires() {
        return exemplaireRepository.findAll();
    }

    public Exemplaire createExemplaire(ExemplaireRequest request) {
        Livre livre = livreRepository.findById(request.getLivreId())
                .orElseThrow(() -> new IllegalArgumentException("Livre introuvable avec l'id : " + request.getLivreId()));

        Exemplaire exemplaire = new Exemplaire();
        exemplaire.setCodeInventaire(request.getCodeInventaire());
        exemplaire.setEtat(request.getEtat());
        exemplaire.setLivre(livre); 

        return exemplaireRepository.save(exemplaire);
    }

    public List<Exemplaire> getExemplairesByLivre(Long livreId) {
        return exemplaireRepository.findByLivreId(livreId);
    }

    public void deleteExemplaire(Long id) {
        exemplaireRepository.deleteById(id);
    }
}