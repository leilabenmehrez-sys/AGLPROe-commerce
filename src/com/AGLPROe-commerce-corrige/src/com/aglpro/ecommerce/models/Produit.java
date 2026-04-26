package com.aglpro.ecommerce.models;

public class Produit {
    private int id;
    private String nom;
    private double prix;
    private String description;
    private int stock;
    private String categorie;

    public Produit() {}

    public Produit(int id, String nom, double prix, String description, int stock, String categorie) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.description = description;
        this.stock = stock;
        this.categorie = categorie;
    }

    public boolean estEnStock(int quantite) {
        return quantite > 0 && stock >= quantite;
    }

    public boolean diminuerStock(int quantite) {
        if (estEnStock(quantite)) {
            stock -= quantite;
            return true;
        }
        return false;
    }

    public void afficherDetails() {
        System.out.println("Produit #" + id + " : " + nom + " | " + prix + " DT | Stock : " + stock);
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public double getPrix() { return prix; }
    public void setPrix(double prix) { this.prix = prix; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }
    public String getCategorie() { return categorie; }
    public void setCategorie(String categorie) { this.categorie = categorie; }
}
