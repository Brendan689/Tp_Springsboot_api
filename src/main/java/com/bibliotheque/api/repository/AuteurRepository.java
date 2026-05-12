package com.bibliotheque.api.repository;

import com.bibliotheque.api.entity.Auteur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuteurRepository extends JpaRepository<Auteur, Long> {
}