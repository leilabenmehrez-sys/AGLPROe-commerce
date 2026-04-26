package com.aglpro.ecommerce.models;

public class Client extends Utilisateur {
    private String adresseLivraison;
    private String telephone;
    private double solde;

    public Client() {
        super();
        this.solde = 0.0;
    }

    public Client(int id, String nom, String prenom, String email, String motDePasse,
                  String adresseLivraison, String telephone) {
        super(id, nom, prenom, email, motDePasse);
        this.adresseLivraison = adresseLivraison;
        this.telephone = telephone;
        this.solde = 0.0;
    }

    public void rechargerSolde(double montant) {
        if (montant > 0) {
            this.solde += montant;
            System.out.println("Solde recharge : +" + montant + " DT");
        }
    }

    public boolean debiterSolde(double montant) {
        if (montant > 0 && solde >= montant) {
            solde -= montant;
            return true;
        }
        return false;
    }

    @Override
    public void afficherDetails() {
        super.afficherDetails();
        System.out.println("Telephone : " + telephone);
        System.out.println("Adresse : " + adresseLivraison);
        System.out.println("Solde : " + solde + " DT");
    }

    public String getAdresseLivraison() { return adresseLivraison; }
    public void setAdresseLivraison(String adresseLivraison) { this.adresseLivraison = adresseLivraison; }
    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }
    public double getSolde() { return solde; }
    public void setSolde(double solde) { this.solde = solde; }
}
