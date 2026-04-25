package com.aglpro.models;

public class LigneCommande {

    private Produit produit;
    private int quantite;
    private double prixUnitaire;

    public LigneCommande() {}

    public LigneCommande(Produit produit, int quantite) {
        this.produit = produit;
        this.quantite = quantite;
        this.prixUnitaire= produit.getPrix();
    }

    public double calculerSousTotal() {
        return this.prixUnitaire * this.quantite;
    }

    public void afficherDetails() {
        System.out.printf("    - %-25s x%d  =  %.2f DT%n",
                produit.getNom(), quantite, calculerSousTotal());
    }

    public Produit getProduit() { return produit; }
    public void setProduit(Produit p) { this.produit = p; }
    public int getQuantite() { return quantite; }
    public void setQuantite(int q) { this.quantite = q; }
    public double getPrixUnitaire() { return prixUnitaire; }
    public void setPrixUnitaire(double p) { this.prixUnitaire = p; }
}