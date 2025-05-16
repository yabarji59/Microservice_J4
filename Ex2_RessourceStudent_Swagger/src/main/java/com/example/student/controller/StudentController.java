package com.example.student.controller;

import com.example.student.model.Student;
import com.example.student.repository.StudentRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@Tag(name = "Student Controller", description = "API de gestion des étudiants - Permet de gérer les étudiants (création, lecture, mise à jour, suppression)")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Operation(
        summary = "Récupérer tous les étudiants",
        description = "Retourne la liste de tous les étudiants. Possibilité de filtrer par année de promotion."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Liste des étudiants récupérée avec succès"),
        @ApiResponse(responseCode = "500", description = "Erreur serveur interne")
    })
    @GetMapping
    public List<Student> getAllStudents(
            @Parameter(
                description = "Année de promotion pour filtrer les étudiants",
                example = "2025",
                schema = @Schema(type = "integer", format = "int32")
            )
            @RequestParam(required = false) Integer promotion) {
        if (promotion != null) {
            return studentRepository.findByPromotion(promotion);
        }
        return studentRepository.findAll();
    }

    @Operation(
        summary = "Récupérer un étudiant par son ID",
        description = "Retourne un étudiant spécifique en fonction de son ID. Retourne une erreur 404 si l'étudiant n'existe pas."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Étudiant trouvé et retourné avec succès"),
        @ApiResponse(responseCode = "404", description = "Aucun étudiant trouvé avec l'ID fourni")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(
            @Parameter(
                description = "ID de l'étudiant à récupérer",
                example = "1",
                schema = @Schema(type = "integer", format = "int64")
            )
            @PathVariable Long id) {
        return studentRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(
        summary = "Créer un nouvel étudiant",
        description = "Crée un nouvel étudiant avec les informations fournies. Les champs obligatoires sont : firstName, lastName, email et promotion."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Étudiant créé avec succès"),
        @ApiResponse(responseCode = "400", description = "Données invalides ou incomplètes")
    })
    @PostMapping
    public Student createStudent(
            @Parameter(
                description = "Informations de l'étudiant à créer",
                required = true
            )
            @RequestBody Student student) {
        return studentRepository.save(student);
    }

    @Operation(
        summary = "Mettre à jour un étudiant",
        description = "Met à jour les informations d'un étudiant existant. Tous les champs seront mis à jour avec les nouvelles valeurs fournies."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Étudiant mis à jour avec succès"),
        @ApiResponse(responseCode = "404", description = "Aucun étudiant trouvé avec l'ID fourni")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(
            @Parameter(
                description = "ID de l'étudiant à mettre à jour",
                example = "1",
                schema = @Schema(type = "integer", format = "int64")
            )
            @PathVariable Long id,
            @Parameter(
                description = "Nouvelles informations de l'étudiant",
                required = true
            )
            @RequestBody Student studentDetails) {
        return studentRepository.findById(id)
                .map(existingStudent -> {
                    existingStudent.setFirstName(studentDetails.getFirstName());
                    existingStudent.setLastName(studentDetails.getLastName());
                    existingStudent.setEmail(studentDetails.getEmail());
                    existingStudent.setPromotion(studentDetails.getPromotion());
                    return ResponseEntity.ok(studentRepository.save(existingStudent));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(
        summary = "Supprimer un étudiant",
        description = "Supprime un étudiant en fonction de son ID. Retourne une erreur 404 si l'étudiant n'existe pas."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Étudiant supprimé avec succès"),
        @ApiResponse(responseCode = "404", description = "Aucun étudiant trouvé avec l'ID fourni")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(
            @Parameter(
                description = "ID de l'étudiant à supprimer",
                example = "1",
                schema = @Schema(type = "integer", format = "int64")
            )
            @PathVariable Long id) {
        return studentRepository.findById(id)
                .map(student -> {
                    studentRepository.delete(student);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
} 