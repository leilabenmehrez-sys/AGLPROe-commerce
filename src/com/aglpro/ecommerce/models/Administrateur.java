package com.aglpro.ecommerce.models;

public class Administrateur extends Utilisateur {

    private String niveauAcces;

    public Administrateur() {
        super();
        this.niveauAcces = "COMPLET";
    }

    public Administrateur(int id, String nom, String prenom,
                          String email, String motDePasse, String niveauAcces) {
        super(id, nom, prenom, email, motDePasse);
        this.niveauAcces = niveauAcces;
    }

    public boolean aAccesA(String ressource) {
        return this.isEstConnecte() && this.niveauAcces.equals("COMPLET");
    }

    @Override
    public void afficherDetails() {
        super.afficherDetails();
        System.out.println("  Niveau accès : " + niveauAcces);
    }

    public String getNiveauAcces() { return niveauAcces; }
    public void setNiveauAcces(String n) { this.niveauAcces = n; }
}
