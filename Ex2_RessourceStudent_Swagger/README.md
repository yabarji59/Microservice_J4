# Microservice Student avec Swagger

## Description
Ce microservice permet de gérer une base de données d'étudiants avec une API REST documentée via Swagger. Il offre les fonctionnalités CRUD (Create, Read, Update, Delete) pour la gestion des étudiants.

## Technologies utilisées
- Java 17
- Spring Boot 3.2.3
- Spring Data JPA
- H2 Database (base de données en mémoire)
- Swagger/OpenAPI 3.0
- Maven

## Prérequis
- JDK 17 ou supérieur
- Maven 3.6 ou supérieur
- Un navigateur web moderne

## Installation et démarrage

### 1. Cloner le projet
```bash
git clone [URL_DU_REPO]
cd student-swagger
```

### 2. Compiler le projet
```bash
mvn clean install
```

### 3. Lancer l'application
```bash
mvn spring-boot:run
```

L'application démarre sur le port 8088 par défaut.

## Accès à l'API

### Interface Swagger
- URL : http://localhost:8088/swagger-ui/index.html
- Documentation complète de l'API avec interface interactive
- Possibilité de tester les endpoints directement depuis l'interface

### Endpoints disponibles

#### 1. Récupérer tous les étudiants
- **GET** `/students`
- Paramètre optionnel : `promotion` (année de promotion)
- Exemple : `GET /students?promotion=2025`

#### 2. Récupérer un étudiant par ID
- **GET** `/students/{id}`
- Exemple : `GET /students/1`

#### 3. Créer un nouvel étudiant
- **POST** `/students`
- Body (JSON) :
```json
{
    "firstName": "Jean",
    "lastName": "Dupont",
    "email": "jean.dupont@example.com",
    "promotion": 2025
}
```

#### 4. Mettre à jour un étudiant
- **PUT** `/students/{id}`
- Body (JSON) : même format que la création

#### 5. Supprimer un étudiant
- **DELETE** `/students/{id}`

## Structure du projet
```
src/main/java/com/example/student/
├── config/
│   └── OpenApiConfig.java      # Configuration Swagger
├── controller/
│   └── StudentController.java  # Contrôleur REST
├── model/
│   └── Student.java           # Entité Student
├── repository/
│   └── StudentRepository.java # Repository JPA
└── StudentApplication.java    # Point d'entrée
```

## Base de données
- Base de données H2 en mémoire
- URL de la console H2 : http://localhost:8088/h2-console
- JDBC URL : `jdbc:h2:mem:studentdb`
- Username : `sa`
- Password : (vide)

## Documentation Swagger
La documentation de l'API est générée automatiquement et inclut :
- Description détaillée de chaque endpoint
- Paramètres attendus avec leurs types
- Exemples de requêtes et réponses
- Codes de retour HTTP
- Schémas des modèles de données

## Tests
Pour exécuter les tests :
```bash
mvn test
```

## Contribution
1. Fork le projet
2. Créer une branche pour votre fonctionnalité
3. Commiter vos changements
4. Pousser vers la branche
5. Ouvrir une Pull Request

## Licence
Ce projet est sous licence Apache 2.0. 