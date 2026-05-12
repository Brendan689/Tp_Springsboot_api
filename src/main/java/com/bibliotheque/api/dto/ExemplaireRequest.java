package com.bibliotheque.api.dto;

import com.bibliotheque.api.entity.Exemplaire.EtatExemplaire;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExemplaireRequest {

    @NotBlank(message = "Le code d'inventaire est obligatoire")
    private String codeInventaire;

    @NotNull(message = "L'état de l'exemplaire est obligatoire")
    private EtatExemplaire etat;

    @NotNull(message = "L'ID du livre est obligatoire")
    private Long livreId;
}