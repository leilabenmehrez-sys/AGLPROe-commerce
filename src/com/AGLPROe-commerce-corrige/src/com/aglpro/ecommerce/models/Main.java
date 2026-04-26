package com.aglpro.ecommerce.models;

public class Main {
    public static void main(String[] args) {
        System.out.println("====================================");
        System.out.println("     AGLPROe-commerce - Sprint 1");
        System.out.println("====================================");

        Client client = new Client(1, "Ben Ali", "Ahmed", "ahmed@email.com", "1234", "Tunis", "12345678");
        client.sInscrire();
        client.seConnecter("ahmed@email.com", "1234");
        client.rechargerSolde(500.0);

        Produit produit1 = new Produit(1, "Montre premium", 120.0, "Objet durable et elegant", 5, "Accessoire");
        Produit produit2 = new Produit(2, "Sac artisanal", 80.0, "Produit fait main", 3, "Artisanat");

        Catalogue catalogue = new Catalogue();
        catalogue.ajouterProduit(produit1);
        catalogue.ajouterProduit(produit2);
        catalogue.afficherCatalogue();

        Panier panier = new Panier(client);
        panier.ajouterProduit(produit1, 1);
        panier.ajouterProduit(produit2, 2);
        panier.afficherPanier();

        Commande commande = new Commande(1001, client, panier, "2026-04-26");
        commande.validerCommande();
        commande.afficherDetails();

        Paiement paiement = new Paiement(501, commande, "Carte bancaire", "2026-04-26");
        paiement.effectuerPaiement();
        paiement.afficherRecu();

        Transaction transaction = new Transaction(9001, paiement, "2026-04-26");
        transaction.enregistrer();

        Statistiques statistiques = new Statistiques();
        statistiques.ajouterClient(client);
        statistiques.ajouterProduit(produit1);
        statistiques.ajouterProduit(produit2);
        statistiques.ajouterCommande(commande);
        statistiques.afficherTableauDeBord();

        System.out.println("====================================");
        System.out.println("Prototype V1 execute avec succes.");
        System.out.println("====================================");
    }
}
