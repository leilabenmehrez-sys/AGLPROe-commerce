package com.aglpro.ecommerce.models;

public class Client extends Utilisateur {

    private String adresseLivraison;
    private String telephone;
    private double solde;

    public Client() {
        super();
        this.solde = 0.0;
    }

    public Client(int id, String nom, String prenom, String email,
                  String motDePasse, String adresseLivraison, String telephone) {
        super(id, nom, prenom, email, motDePasse);
        this.adresseLivraison = adresseLivraison;
        this.telephone = telephone;
        this.solde = 0.0;
    }

    public boolean sInscrire(String nom, String prenom, String email,
                              String motDePasse, String telephone) {
        if (nom == null || nom.isEmpty()) return false;
        if (prenom == null || prenom.isEmpty()) return false;
        if (!emailValide()) return false;
        if (motDePasse == null || motDePasse.length() < 6) return false;
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setEmail(email);
        this.setMotDePasse(motDePasse);
        this.telephone = telephone;
        return true;
    }

    public void rechargerSolde(double montant) {
        if (montant > 0) this.solde += montant;
    }

    public boolean debiterSolde(double montant) {
        if (montant > 0 && this.solde >= montant) {
            this.solde -= montant;
            return true;
        }
        return false;
    }

    @Override
    public void afficherDetails() {
        super.afficherDetails();
        System.out.println("  Téléphone   : " + telephone);
        System.out.println("  Adresse     : " + adresseLivraison);
        System.out.printf("  Solde       : %.2f DT%n", solde);
    }

    public String getAdresseLivraison() { return adresseLivraison; }
    public void setAdresseLivraison(String a) { this.adresseLivraison = a; }
    public String getTelephone() { return telephone; }
    public void setTelephone(String t) { this.telephone = t; }
    public double getSolde() { return solde; }
    public void setSolde(double solde) { this.solde = solde; }
}