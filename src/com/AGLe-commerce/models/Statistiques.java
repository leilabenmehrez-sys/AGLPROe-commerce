package com.aglpro.ecommerce.models;

import java.util.ArrayList;
import java.util.List;

public class Statistiques {

    private List<Commande> commandes;
    private List<Client> clients;
    private List<Produit> produits;
    private double revenusJour;

    public Statistiques() {
        this.commandes = new ArrayList<>();
        this.clients = new ArrayList<>();
        this.produits = new ArrayList<>();
        this.revenusJour = 0.0;
    }

    public double calculerRevenusJour(String date) {
        double total = 0.0;
        for (Commande c : commandes)
            if (c.getDateCommande().equals(date) && c.getStatut().equals("CONFIRMEE"))
                total += c.getMontantTotal();
        this.revenusJour = total;
        return total;
    }

    public int compterCommandesActives() {
        int count = 0;
        for (Commande c : commandes)
            if (c.getStatut().equals("EN_ATTENTE") || c.getStatut().equals("CONFIRMEE"))
                count++;
        return count;
    }

    public void verifierAlertes() {
        System.out.println("  [ALERTES ADMIN]");
        boolean alerte = false;
        for (Produit p : produits) {
            if (p.getQuantiteStock() == 0) {
                System.out.println("  ⚠️ ALERTE : \"" + p.getNom() + "\" en rupture de stock !");
                alerte = true;
            } else if (p.getQuantiteStock() < 5) {
                System.out.println("  ⚠️ ALERTE : \"" + p.getNom() + "\" stock faible (" + p.getQuantiteStock() + " restants)");
                alerte = true;
            }
        }
        if (!alerte) System.out.println("  Aucune alerte — tout est en ordre.");
    }

    public void afficherTableauDeBord(String date) {
        System.out.println("  ═══════════════════════════════════");
        System.out.println("  TABLEAU DE BORD ADMIN — " + date);
        System.out.println("  ═══════════════════════════════════");
        System.out.println("  Clients inscrits    : " + clients.size());
        System.out.println("  Commandes actives   : " + compterCommandesActives());
        System.out.printf ("  Revenus du jour     : %.2f DT%n", calculerRevenusJour(date));
        System.out.println("  Produits catalogue  : " + produits.size());
        System.out.println("  ───────────────────────────────────");
        verifierAlertes();
        System.out.println("  ═══════════════════════════════════");
    }

    public void ajouterCommande(Commande c) { this.commandes.add(c); }
    public void ajouterClient(Client c) { this.clients.add(c); }
    public void ajouterProduit(Produit p) { this.produits.add(p); }
    public List<Commande> getCommandes() { return commandes; }
    public List<Client> getClients() { return clients; }
    public List<Produit> getProduits() { return produits; }
    public double getRevenusJour() { return revenusJour; }
}