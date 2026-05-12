package com.bibliotheque.api.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDate;

@Data
public class EmpruntRequest {
    @NotNull(message = "L'ID utilisateur est obligatoire")
    private Long utilisateurId;

    @NotNull(message = "L'ID exemplaire est obligatoire")
    private Long exemplaireId;

    private LocalDate dateEmprunt = LocalDate.now();
    private Integer dureeEmpruntJours = 14; 
}