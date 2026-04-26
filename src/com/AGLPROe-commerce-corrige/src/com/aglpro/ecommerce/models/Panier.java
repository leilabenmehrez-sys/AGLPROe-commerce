package com.aglpro.ecommerce.models;

import java.util.ArrayList;
import java.util.List;

public class Panier {
    private Client client;
    private List<LigneCommande> lignes;
    private double totalPanier;

    public Panier() {
        this.lignes = new ArrayList<>();
        this.totalPanier = 0.0;
    }

    public Panier(Client client) {
        this.client = client;
        this.lignes = new ArrayList<>();
        this.totalPanier = 0.0;
    }

    public boolean ajouterProduit(Produit produit, int quantite) {
        if (produit == null || quantite <= 0) {
            System.out.println("Quantite invalide");
            return false;
        }
        if (!produit.estEnStock(quantite)) {
            System.out.println("Stock insuffisant pour : " + produit.getNom());
            return false;
        }
        lignes.add(new LigneCommande(produit, quantite));
        recalculerTotal();
        System.out.println("Produit ajoute au panier : " + produit.getNom());
        return true;
    }

    public void retirerProduit(int idProduit) {
        lignes.removeIf(ligne -> ligne.getProduit().getId() == idProduit);
        recalculerTotal();
        System.out.println("Produit retire du panier si existant");
    }

    public void vider() {
        lignes.clear();
        totalPanier = 0.0;
    }

    public void recalculerTotal() {
        totalPanier = 0.0;
        for (LigneCommande ligne : lignes) {
            totalPanier += ligne.calculerSousTotal();
        }
    }

    public void afficherPanier() {
        System.out.println("Contenu du panier :");
        if (lignes.isEmpty()) {
            System.out.println("Panier vide");
            return;
        }
        for (LigneCommande ligne : lignes) {
            ligne.afficherDetails();
        }
        System.out.println("Total panier : " + totalPanier + " DT");
    }

    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }
    public List<LigneCommande> getLignes() { return lignes; }
    public double getTotalPanier() { return totalPanier; }
}
