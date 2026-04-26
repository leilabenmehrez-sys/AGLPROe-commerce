package com.aglpro.models;

import java.util.ArrayList;
import java.util.List;

public class Statistiques {

    // === Champs privés ===
    private List<Commande> commandes;
    private List<Client> clients;
    private List<Produit> produits;
    private double revenusJour;
    private int nombreCommandesActives;

    // === Constructeur vide ===
    public Statistiques() {
        this.commandes = new ArrayList<>();
        this.clients = new ArrayList<>();
        this.produits = new ArrayList<>();
        this.revenusJour = 0.0;
        this.nombreCommandesActives = 0;
    }

    // === Méthodes métier ===
    /**
     * Calcule les revenus du jour (commandes CONFIRMEE uniquement) — en DT
     */
    public double calculerRevenusJour(String date) {
        double total = 0.0;
        for (Commande c : commandes) {
            if (c.getDateCommande().equals(date) && c.getStatut().equals("CONFIRMEE")) {
                total += c.getMontantTotal();
            }
        }
        this.revenusJour = total;
        return total;
    }

    /**
     * Compte les commandes EN_ATTENTE ou CONFIRMEE
     */
    public int compterCommandesActives() {
        int count = 0;
        for (Commande c : commandes) {
            if (c.getStatut().equals("EN_ATTENTE") || c.getStatut().equals("CONFIRMEE")) {
                count++;
            }
        }
        this.nombreCommandesActives = count;
        return count;
    }

    /**
     * Détecte les produits en rupture ou stock faible et affiche des alertes
     */
    public void verifierAlertes() {
        System.out.println("  [ALERTES ADMIN]");
        boolean alerteTrouvee = false;
        for (Produit p : produits) {
            if (p.getQuantiteStock() == 0) {
                System.out.println("  ⚠️  ALERTE : \"" + p.getNom() + "\" — rupture de stock !");
                alerteTrouvee = true;
            } else if (p.getQuantiteStock() < 5) {
                System.out.println("  ⚠️  ALERTE : \"" + p.getNom() + "\" — stock faible ("
                        + p.getQuantiteStock() + " restants)");
                alerteTrouvee = true;
            }
        }
        if (!alerteTrouvee) {
            System.out.println("  ✅ Aucune alerte — tout est en ordre.");
        }
    }

    /**
     * Affiche le tableau de bord complet de l'administrateur
     */
    public void afficherTableauDeBord(String date) {
        System.out.println("  ═══════════════════════════════════");
        System.out.println("  TABLEAU DE BORD ADMIN — " + date);
        System.out.println("  ═══════════════════════════════════");
        System.out.println("  Clients inscrits    : " + clients.size());
        System.out.println("  Commandes actives   : " + compterCommandesActives());
        System.out.printf("  Revenus du jour     : %.2f DT%n", calculerRevenusJour(date));
        System.out.println("  Produits catalogue  : " + produits.size());
        System.out.println("  ───────────────────────────────────");
        verifierAlertes();
        System.out.println("  ═══════════════════════════════════");
    }

    // === Méthodes d'alimentation ===
    public void ajouterCommande(Commande c) {
        this.commandes.add(c);
    }

    public void ajouterClient(Client c) {
        this.clients.add(c);
    }

    public void ajouterProduit(Produit p) {
        this.produits.add(p);
    }

    // === Getters & Setters ===
    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }

    public double getRevenusJour() {
        return revenusJour;
    }

    public int getNombreCommandesActives() {
        return nombreCommandesActives;
    }
}
