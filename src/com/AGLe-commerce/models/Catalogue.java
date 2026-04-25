package com.aglpro.models;

import java.util.ArrayList;
import java.util.List;

public class Catalogue {

    private List<Produit> produits;
    private int nombreTotalProduits;

    public Catalogue() {
        this.produits = new ArrayList<>();
        this.nombreTotalProduits = 0;
    }

    public void ajouterProduit(Produit produit) {
        if (produit != null) {
            this.produits.add(produit);
            this.nombreTotalProduits++;
        }
    }

    public List<Produit> rechercherParNom(String motCle) {
        List<Produit> resultats = new ArrayList<>();
        for (Produit p : produits)
            if (p.getNom().toLowerCase().contains(motCle.toLowerCase()))
                resultats.add(p);
        return resultats;
    }

    public List<Produit> filtrerParCategorie(String categorie) {
        List<Produit> resultats = new ArrayList<>();
        for (Produit p : produits)
            if (p.getCategorie().equalsIgnoreCase(categorie))
                resultats.add(p);
        return resultats;
    }

    public List<Produit> filtrerParPrixMax(double prixMax) {
        List<Produit> resultats = new ArrayList<>();
        for (Produit p : produits)
            if (p.getPrix() <= prixMax)
                resultats.add(p);
        return resultats;
    }

    public void afficherCatalogue() {
        System.out.println("  Catalogue AGL.pro (" + nombreTotalProduits + " produits) :");
        for (Produit p : produits) p.afficherDetails();
    }

    public List<Produit> getProduits() { return produits; }
    public int getNombreTotalProduits() { return nombreTotalProduits; }
}