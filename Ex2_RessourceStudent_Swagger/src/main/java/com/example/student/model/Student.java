package com.example.student.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Entité représentant un étudiant")
public class Student {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identifiant unique de l'étudiant", example = "1")
    private Long id;
    
    @Schema(description = "Prénom de l'étudiant", example = "Jean")
    private String firstName;
    
    @Schema(description = "Nom de famille de l'étudiant", example = "Dupont")
    private String lastName;
    
    @Schema(description = "Adresse email de l'étudiant", example = "jean.dupont@example.com")
    private String email;
    
    @Schema(description = "Année de promotion de l'étudiant", example = "2025")
    private Integer promotion;
} 