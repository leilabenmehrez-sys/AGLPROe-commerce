package com.aglpro.models;

public class Client extends Utilisateur {
    private String adresse;
    private String telephone;

    public Client() {}

    public Client(int id, String nom, String email,
                  String motDePasse, String adresse,
                  String telephone) {
        super(id, nom, email, motDePasse);
        this.adresse = adresse;
        this.telephone = telephone;
    }

    public void consulterCatalogue() {
        System.out.println("Consultation du catalogue...");
    }

    public void ajouterAuPanier(Produit produit, int quantite) {
        System.out.println(produit.getNom() +
                           " ajouté au panier (x" +
                           quantite + ")");
    }

    public Commande passerCommande() {
        System.out.println("Commande passée par " + getNom());
        return new Commande();
    }

    public String getAdresse() { return adresse; }
    public String getTelephone() { return telephone; }
    public void setAdresse(String adresse) { this.adresse = adresse; }
    public void setTelephone(String tel) { this.telephone = tel; }
}
