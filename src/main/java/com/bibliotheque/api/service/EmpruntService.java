package com.bibliotheque.api.service;

import com.bibliotheque.api.dto.EmpruntRequest;
import com.bibliotheque.api.entity.Emprunt;
import com.bibliotheque.api.entity.Exemplaire;
import com.bibliotheque.api.entity.Utilisateur;
import com.bibliotheque.api.repository.EmpruntRepository;
import com.bibliotheque.api.repository.ExemplaireRepository;
import com.bibliotheque.api.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class EmpruntService {

    @Autowired
    private EmpruntRepository empruntRepository;
    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Autowired
    private ExemplaireRepository exemplaireRepository;

    public List<Emprunt> getAllEmprunts() {
        return empruntRepository.findAll();
    }

    public Emprunt createEmprunt(EmpruntRequest request) {
        Utilisateur user = utilisateurRepository.findById(request.getUtilisateurId())
                .orElseThrow(() -> new IllegalArgumentException("Utilisateur non trouvé"));
        
        Exemplaire exemplaire = exemplaireRepository.findById(request.getExemplaireId())
                .orElseThrow(() -> new IllegalArgumentException("Exemplaire non trouvé"));

        Emprunt emprunt = new Emprunt();
        emprunt.setUtilisateur(user);
        emprunt.setExemplaire(exemplaire);
        emprunt.setDateEmprunt(request.getDateEmprunt());
        emprunt.setDateRetourPrevue(request.getDateEmprunt().plusDays(request.getDureeEmpruntJours()));

        return empruntRepository.save(emprunt);
    }

    public Emprunt enregistrerRetour(Long id) {
        Emprunt emprunt = empruntRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Emprunt non trouvé"));
        emprunt.setDateRetourEffective(LocalDate.now());
        return empruntRepository.save(emprunt);
    }
}