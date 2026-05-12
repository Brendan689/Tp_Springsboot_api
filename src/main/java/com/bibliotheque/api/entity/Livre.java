package com.bibliotheque.api.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity                    // Indique que cette classe est une table en BDD
@Table(name = "livres")    // Nom de la table
@Data                      // Lombok : génère getters, setters, toString, equals, hashCode
@NoArgsConstructor         // Lombok : génère le constructeur sans paramètres
@AllArgsConstructor        // Lombok : génère le constructeur avec tous les paramètres
public class Livre {

    @Id                                                    // Clé primaire
    @GeneratedValue(strategy = GenerationType.IDENTITY)    // Auto-incrément
    private Long id;

    @Column(nullable = false)    // La colonne ne peut pas être NULL
    private String titre;

    @Column(nullable = false)
    private String isbn;

    @Enumerated(EnumType.STRING)    // Stocke la catégorie comme texte (ex: "ROMAN")
    private Categorie categorie;

    // Enumération des catégories (définie dans la même classe pour simplifier)
    public enum Categorie {
        ROMAN, NOUVELLE, POESIE, MANGA, ROMANCE, COMEDIE
    }

    @NotBlank(message = "Le titre est obligatoire")
    private String titre;
    
    @Pattern(regexp = "\\d{3}-\\d{1,5}-\\d{1,7}-\\d{1,7}-\\d{1}", message = "ISBN invalide")
    private String isbn;
}