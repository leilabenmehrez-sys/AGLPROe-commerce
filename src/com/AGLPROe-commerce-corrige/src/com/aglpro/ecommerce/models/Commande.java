package com.aglpro.ecommerce.models;

import java.util.ArrayList;
import java.util.List;

public class Commande {
    private int id;
    private Client client;
    private List<LigneCommande> lignes;
    private double montantTotal;
    private String statut;
    private String dateCommande;

    public Commande() {
        this.lignes = new ArrayList<>();
        this.statut = "EN_ATTENTE";
    }

    public Commande(int id, Client client, Panier panier, String dateCommande) {
        this.id = id;
        this.client = client;
        this.lignes = new ArrayList<>(panier.getLignes());
        this.montantTotal = panier.getTotalPanier();
        this.statut = "EN_ATTENTE";
        this.dateCommande = dateCommande;
    }

    public boolean validerCommande() {
        if (lignes.isEmpty()) {
            System.out.println("Commande refusee : panier vide");
            return false;
        }
        for (LigneCommande ligne : lignes) {
            if (!ligne.getProduit().diminuerStock(ligne.getQuantite())) {
                System.out.println("Commande refusee : stock insuffisant pour " + ligne.getProduit().getNom());
                return false;
            }
        }
        statut = "VALIDEE";
        System.out.println("Commande validee : #" + id);
        return true;
    }

    public void confirmer() {
        this.statut = "CONFIRMEE";
    }

    public void annuler() {
        this.statut = "ANNULEE";
    }

    public void afficherDetails() {
        System.out.println("Commande #" + id + " | Statut : " + statut + " | Date : " + dateCommande);
        for (LigneCommande ligne : lignes) {
            ligne.afficherDetails();
        }
        System.out.println("Total commande : " + montantTotal + " DT");
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }
    public List<LigneCommande> getLignes() { return lignes; }
    public double getMontantTotal() { return montantTotal; }
    public void setMontantTotal(double montantTotal) { this.montantTotal = montantTotal; }
    public String getStatut() { return statut; }
    public void setStatut(String statut) { this.statut = statut; }
    public String getDateCommande() { return dateCommande; }
    public void setDateCommande(String dateCommande) { this.dateCommande = dateCommande; }
}
