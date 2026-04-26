package com.aglpro.ecommerce.models;;

import java.util.ArrayList;
import java.util.List;

public class Panier {

    private Client client;
    private List<LigneCommande> lignes;
    private double totalPanier;

    public Panier() { this.lignes = new ArrayList<>(); this.totalPanier = 0.0; }

    public Panier(Client client) {
        this.client = client;
        this.lignes = new ArrayList<>();
        this.totalPanier = 0.0;
    }

    public boolean ajouterProduit(Produit produit, int quantite) {
        if (produit == null || quantite <= 0) return false;
        if (!produit.estEnStock(quantite)) {
            System.out.println("  [PANIER] Stock insuffisant pour : " + produit.getNom());
            return false;
        }
        lignes.add(new LigneCommande(produit, quantite));
        recalculerTotal();
        return true;
    }

    private void recalculerTotal() {
        this.totalPanier = 0.0;
        for (LigneCommande l : lignes) this.totalPanier += l.calculerSousTotal();
    }

    public void vider() { this.lignes.clear(); this.totalPanier = 0.0; }

    public void afficherDetails() {
        System.out.println("  Panier de " + client.getPrenom() + " " + client.getNom() + " :");
        if (lignes.isEmpty()) { System.out.println("    (Panier vide)"); }
        else {
            for (LigneCommande l : lignes) l.afficherDetails();
            System.out.printf("  Total panier : %.2f DT%n", totalPanier);
        }
    }

    public Client getClient() { return client; }
    public void setClient(Client c) { this.client = c; }
    public List<LigneCommande> getLignes() { return lignes; }
    public void setLignes(List<LigneCommande> l) { this.lignes = l; }
    public double getTotalPanier() { return totalPanier; }
}