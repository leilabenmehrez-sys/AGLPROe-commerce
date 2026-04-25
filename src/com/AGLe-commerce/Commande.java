package com.aglpro.models;

import java.util.ArrayList;
import java.util.List;

public class Commande {

    private int id;
    private Client client;
    private List<LigneCommande> lignes;
    private double montantTotal;
    private String statut; // EN_ATTENTE, CONFIRMEE, LIVREE, ANNULEE
    private String dateCommande;

    public Commande() {
        this.lignes = new ArrayList<>();
        this.statut = "EN_ATTENTE";
        this.montantTotal = 0.0;
    }

    public Commande(int id, Client client, Panier panier, String dateCommande) {
        this.id = id;
        this.client = client;
        this.lignes = new ArrayList<>(panier.getLignes());
        this.montantTotal = panier.getTotalPanier();
        this.statut = "EN_ATTENTE";
        this.dateCommande = dateCommande;
    }

    public void confirmer() { this.statut = "CONFIRMEE"; }
    public void annuler() { this.statut = "ANNULEE"; }

    public void afficherDetails() {
        System.out.println("  Commande #" + id + " — " + dateCommande);
        System.out.println("  Client  : " + client.getPrenom() + " " + client.getNom());
        System.out.println("  Statut  : " + statut);
        for (LigneCommande l : lignes) l.afficherDetails();
        System.out.printf("  Total   : %.2f DT%n", montantTotal);
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public Client getClient() { return client; }
    public void setClient(Client c) { this.client = c; }
    public List<LigneCommande> getLignes() { return lignes; }
    public void setLignes(List<LigneCommande> l) { this.lignes = l; }
    public double getMontantTotal() { return montantTotal; }
    public void setMontantTotal(double m) { this.montantTotal = m; }
    public String getStatut() { return statut; }
    public void setStatut(String s) { this.statut = s; }
    public String getDateCommande() { return dateCommande; }
    public void setDateCommande(String d) { this.dateCommande = d; }
}