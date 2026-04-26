package com.aglpro.ecommerce.models;

public class LigneCommande {
    private Produit produit;
    private int quantite;
    private double prixUnitaire;

    public LigneCommande() {}

    public LigneCommande(Produit produit, int quantite) {
        this.produit = produit;
        this.quantite = quantite;
        this.prixUnitaire = produit.getPrix();
    }

    public double calculerSousTotal() {
        return prixUnitaire * quantite;
    }

    public void afficherDetails() {
        System.out.println("- " + produit.getNom() + " x" + quantite + " = " + calculerSousTotal() + " DT");
    }

    public Produit getProduit() { return produit; }
    public void setProduit(Produit produit) { this.produit = produit; }
    public int getQuantite() { return quantite; }
    public void setQuantite(int quantite) { this.quantite = quantite; }
    public double getPrixUnitaire() { return prixUnitaire; }
    public void setPrixUnitaire(double prixUnitaire) { this.prixUnitaire = prixUnitaire; }
}
