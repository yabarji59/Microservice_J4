# Microservice Student

Ce projet est un microservice simple de gestion d'étudiants, conçu comme un exemple pédagogique pour les débutants en Spring Boot.

## Fonctionnalités

- Liste de tous les étudiants (GET /students)
- Recherche d'un étudiant par ID (GET /students/{id})
- Création d'un étudiant (POST /students)
- Modification d'un étudiant (PUT /students/{id})
- Suppression d'un étudiant (DELETE /students/{id})
- Recherche d'étudiants par promotion (GET /students?promotion=2025)

## Prérequis

- Java 17 ou supérieur
- Maven
- Un IDE (IntelliJ IDEA, Eclipse, VS Code)

## Installation

1. Cloner le projet :
```bash
git clone [URL_DU_REPO]
```

2. Se placer dans le répertoire du projet :
```bash
cd [NOM_DU_REPERTOIRE]
```

3. Compiler le projet :
```bash
mvn clean install
```

## Lancement

Pour démarrer l'application :
```bash
mvn spring-boot:run
```

L'application sera accessible à l'adresse : http://localhost:8088

## Tests

Pour exécuter les tests :
```bash
mvn test
```

## Structure du projet

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── example/
│   │           └── student/
│   │               ├── controller/
│   │               ├── model/
│   │               ├── repository/
│   │               └── StudentApplication.java
│   └── resources/
│       └── application.properties
└── test/
    └── java/
        └── com/
            └── example/
                └── student/
```

## Exemples d'utilisation

### 1. Créer un étudiant
```bash
curl -X POST http://localhost:8088/students \
-H "Content-Type: application/json" \
-d '{
    "firstName": "John",
    "lastName": "Doe",
    "email": "john.doe@example.com",
    "promotion": 2025
}'
```

### 2. Lister tous les étudiants
```bash
curl http://localhost:8088/students
```

### 3. Rechercher par promotion
```bash
curl http://localhost:8088/students?promotion=2025
```

### 4. Rechercher par ID
```bash
curl http://localhost:8088/students/1
```

### 5. Modifier un étudiant
```bash
curl -X PUT http://localhost:8088/students/1 \
-H "Content-Type: application/json" \
-d '{
    "firstName": "John",
    "lastName": "Doe",
    "email": "john.doe.updated@example.com",
    "promotion": 2025
}'
```

### 6. Supprimer un étudiant
```bash
curl -X DELETE http://localhost:8088/students/1
```

### Accès à la console H2
La console H2 est accessible à l'adresse : http://localhost:8088/h2-console 