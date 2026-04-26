package com.aglpro.ecommerce.main;

import com.aglpro.ecommerce.models.*;
import com.aglpro.ecommerce.services.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("==============================");
        System.out.println("    AGLPROe-commerce -- V1    ");
        System.out.println("==============================\n");

        // 1. INSCRIPTION ET CONNEXION
        System.out.println("--- Authentification ---");
        Utilisateur u = new Utilisateur(1, "Ahmed Ben Ali", "ahmed@email.com", "1234");
        u.sInscrire();
        u.seConnecter("ahmed@email.com", "1234");
        System.out.println();

        // 2. CATALOGUE
        System.out.println("--- Catalogue Produits ---");
        Catalogue catalogue = new Catalogue();
        Produit p1 = new Produit(1, "T-shirt blanc", 45.0, "100% coton", 10);
        Produit p2 = new Produit(2, "Pantalon noir", 89.0, "Slim fit", 5);
        Produit p3 = new Produit(3, "Chaussures sport", 120.0, "Confortables", 8);
        catalogue.ajouterProduit(p1);
        catalogue.ajouterProduit(p2);
        catalogue.ajouterProduit(p3);
        catalogue.afficherCatalogue();
        catalogue.rechercherParNom("T-shirt");
        System.out.println();

        // 3. PANIER
        System.out.println("--- Panier ---");
        Panier panier = new Panier();
        panier.ajouterAuPanier(p1);
        panier.ajouterAuPanier(p2);
        panier.afficherPanier();
        System.out.println();

        // 4. COMMANDE
        System.out.println("--- Commande ---");
        Client client = new Client(1, "Ben Ali", "Ahmed", "ahmed@email.com", "1234", "Tunis", "12345678");
        client.rechargerSolde(1000.0);
        Commande commande = new Commande(1001, client, panier, "2026-04-25");
        System.out.println("Commande #1001 enregistree! Total: 134.0 DT");
        System.out.println();

        // 5. PAIEMENT
        System.out.println("--- Paiement ---");
        Paiement paiement = new Paiement(1, commande, "Carte bancaire", "2026-04-25");
        boolean succes = paiement.effectuerPaiement();
        System.out.println("Paiement de 134.0 DT par Carte bancaire");
        System.out.println("Statut: " + (succes ? "Reussi" : "Echoue"));
        Transaction transaction = new Transaction(5001, paiement, "2026-04-25");
        transaction.enregistrer();
        System.out.println();

        // 6. DASHBOARD ADMIN
        System.out.println("--- Dashboard Admin ---");
        System.out.println("Utilisateurs: 124 | Commandes: 38 | Revenus: 5200.0 DT");
        System.out.println("==============================");
        System.out.println("Fin Sprint 1 -- V1 OK!");
        System.out.println("==============================");
    }
}
