package com.aglpro.ecommerce.models;

import java.util.ArrayList;
import java.util.List;

public class Catalogue {
    private List<Produit> produits;

    public Catalogue() {
        this.produits = new ArrayList<>();
    }

    public void ajouterProduit(Produit produit) {
        if (produit != null) {
            produits.add(produit);
            System.out.println("Produit ajoute au catalogue : " + produit.getNom());
        }
    }

    public void supprimerProduit(int idProduit) {
        produits.removeIf(produit -> produit.getId() == idProduit);
        System.out.println("Produit supprime si existant");
    }

    public List<Produit> rechercherParNom(String motCle) {
        List<Produit> resultats = new ArrayList<>();
        for (Produit produit : produits) {
            if (produit.getNom().toLowerCase().contains(motCle.toLowerCase())) {
                resultats.add(produit);
            }
        }
        return resultats;
    }

    public void afficherCatalogue() {
        System.out.println("Catalogue produits :");
        for (Produit produit : produits) {
            produit.afficherDetails();
        }
    }

    public List<Produit> getProduits() { return produits; }
}
