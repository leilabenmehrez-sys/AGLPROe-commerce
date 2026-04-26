package com.aglpro.ecommerce.models;

import java.util.ArrayList;
import java.util.List;

public class Statistiques {
    private List<Commande> commandes;
    private List<Client> clients;
    private List<Produit> produits;

    public Statistiques() {
        this.commandes = new ArrayList<>();
        this.clients = new ArrayList<>();
        this.produits = new ArrayList<>();
    }

    public void ajouterCommande(Commande commande) { commandes.add(commande); }
    public void ajouterClient(Client client) { clients.add(client); }
    public void ajouterProduit(Produit produit) { produits.add(produit); }

    public double calculerRevenus() {
        double total = 0.0;
        for (Commande commande : commandes) {
            if ("CONFIRMEE".equals(commande.getStatut())) {
                total += commande.getMontantTotal();
            }
        }
        return total;
    }

    public void afficherTableauDeBord() {
        System.out.println("--- Dashboard Admin ---");
        System.out.println("Clients : " + clients.size());
        System.out.println("Commandes : " + commandes.size());
        System.out.println("Produits : " + produits.size());
        System.out.println("Revenus : " + calculerRevenus() + " DT");
    }
}
