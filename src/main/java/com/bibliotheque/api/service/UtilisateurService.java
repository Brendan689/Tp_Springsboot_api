package com.bibliotheque.api.service;

import com.bibliotheque.api.entity.Utilisateur;
import com.bibliotheque.api.repository.UtilisateurRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;

    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    public List<Utilisateur> getAll() {
        return utilisateurRepository.findAll();
    }

    public Optional<Utilisateur> getById(Long id) {
        return utilisateurRepository.findById(id);
    }

    public Utilisateur create(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    public Optional<Utilisateur> update(Long id, Utilisateur data) {
        return utilisateurRepository.findById(id)
                .map(u -> {
                    u.setNom(data.getNom());
                    u.setEmail(data.getEmail());
                    return utilisateurRepository.save(u);
                });
    }

    public boolean delete(Long id) {
        if (utilisateurRepository.existsById(id)) {
            utilisateurRepository.deleteById(id);
            return true;
        }
        return false;
    }
}