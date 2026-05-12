@ManyToOne @JoinColumn(name = "auteur_id")private Auteur auteur;

package com.bibliotheque.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "auteurs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Auteur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    // Un auteur peut avoir plusieurs livres
    @OneToMany(mappedBy = "auteur")
    @JsonIgnore
    private List<Livre> livres;
}