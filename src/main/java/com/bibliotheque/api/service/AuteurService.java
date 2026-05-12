package com.bibliotheque.api.service;

import com.bibliotheque.api.entity.Auteur;
import com.bibliotheque.api.repository.AuteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AuteurService {
    @Autowired
    private AuteurRepository auteurRepository;

    public List<Auteur> getAllAuteurs() { return auteurRepository.findAll(); }
    
    public Optional<Auteur> getAuteurById(Long id) { return auteurRepository.findById(id); }

    public Auteur createAuteur(Auteur auteur) { return auteurRepository.save(auteur); }

    public void deleteAuteur(Long id) { auteurRepository.deleteById(id); }
}