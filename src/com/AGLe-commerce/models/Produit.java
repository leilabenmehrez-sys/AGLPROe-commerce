package com.aglpro.models;

public class Produit {

    private int id;
    private String nom;
    private String description;
    private double prix;
    private int quantiteStock;
    private String categorie;
    private boolean estDisponible;

    public Produit() { this.estDisponible = true; }

    public Produit(int id, String nom, String description,
                   double prix, int quantiteStock, String categorie) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.quantiteStock = quantiteStock;
        this.categorie = categorie;
        this.estDisponible = quantiteStock > 0;
    }

    public boolean estEnStock(int quantiteDemandee) {
        return this.quantiteStock >= quantiteDemandee;
    }

    public boolean reduireStock(int quantite) {
        if (estEnStock(quantite)) {
            this.quantiteStock -= quantite;
            this.estDisponible = this.quantiteStock > 0;
            return true;
        }
        return false;
    }

    public double calculerPrixReduit(double pourcentageReduction) {
        return this.prix * (1 - pourcentageReduction / 100);
    }

    public void afficherDetails() {
        System.out.printf("  [%d] %-25s | %.2f DT | Stock: %d | Catégorie: %s%n",
                id, nom, prix, quantiteStock, categorie);
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getDescription() { return description; }
    public void setDescription(String d) { this.description = d; }
    public double getPrix() { return prix; }
    public void setPrix(double prix) { this.prix = prix; }
    public int getQuantiteStock() { return quantiteStock; }
    public void setQuantiteStock(int q) { this.quantiteStock = q; this.estDisponible = q > 0; }
    public String getCategorie() { return categorie; }
    public void setCategorie(String c) { this.categorie = c; }
    public boolean isEstDisponible() { return estDisponible; }
    public void setEstDisponible(boolean e) { this.estDisponible = e; }
}