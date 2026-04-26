# ecomerce souk online

## Description
 ecomerce souk online est une plateforme e-commerce développée 
en Java selon la méthode Agile Scrum. Elle permet aux 
commerçants tunisiens de créer leur boutique en ligne en 
quelques minutes, sans compétences techniques.

## Problème résolu
Le coût de développement d'un site e-commerce spécialisé 
est trop élevé pour les petits commerçants tunisiens. 
Notre solution offre une alternative simple et abordable.

## Fonctionnalités principales
- Inscription et authentification des utilisateurs
- Catalogue de produits avec recherche et filtres
- Gestion du panier et des commandes
- Système de paiement sécurisé (simulation)
- Tableau de bord administrateur avec statistiques

## Équipe
| Membre | Rôle | Fonctionnalité |
|--------|------|----------------|
| Leila | Product Owner + Dev | Authentification |
| Hamza | Scrum Master + Dev | Paiement |
| Ghofrane | Développeuse | Catalogue |
| Lina | Développeuse | Panier & Commandes |
| Abdelkader | Développeur | Dashboard Admin |

## Technologies utilisées
- Java (POO)
- GitHub (versioning)
- Jira (gestion de projet)
- Figma/Uizard (maquettes)
- PlantUML (diagrammes UML)
- Méthode Scrum (2 Sprints)

## Structure du projet
src/com/aglpro/models/
├── Utilisateur.java
├── Client.java
├── Administrateur.java
├── Produit.java
├── Catalogue.java
├── Panier.java
├── Commande.java
├── Paiement.java
├── Transaction.java
├── Livraison.java
└── Main.java

## Comment exécuter
javac src/com/aglpro/models/*.java
java -cp src com.aglpro.models.Main

## Méthode Agile
- Sprint 1: Squelette Java + Maquettes Figma + UML
- Sprint 2: Implémentation logique métier complète
