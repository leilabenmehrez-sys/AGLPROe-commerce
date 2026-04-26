package com.aglpro.ecommerce.models;

public class Administrateur extends Utilisateur {
    private String niveauAcces;

    public Administrateur() {
        super();
        this.niveauAcces = "COMPLET";
    }

    public Administrateur(int id, String nom, String prenom, String email, String motDePasse, String niveauAcces) {
        super(id, nom, prenom, email, motDePasse);
        this.niveauAcces = niveauAcces;
    }

    public void gererProduit(Produit produit) {
        System.out.println("Admin : gestion du produit " + produit.getNom());
    }

    public String getNiveauAcces() { return niveauAcces; }
    public void setNiveauAcces(String niveauAcces) { this.niveauAcces = niveauAcces; }
}
