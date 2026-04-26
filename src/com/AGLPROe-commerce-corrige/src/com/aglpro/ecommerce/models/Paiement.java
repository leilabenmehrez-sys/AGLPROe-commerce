package com.aglpro.ecommerce.models;

public class Paiement {
    private int id;
    private Commande commande;
    private double montant;
    private String methodePaiement;
    private String statut;
    private String datePaiement;

    public Paiement() {
        this.statut = "EN_COURS";
    }

    public Paiement(int id, Commande commande, String methodePaiement, String datePaiement) {
        this.id = id;
        this.commande = commande;
        this.montant = commande.getMontantTotal();
        this.methodePaiement = methodePaiement;
        this.datePaiement = datePaiement;
        this.statut = "EN_COURS";
    }

    public boolean effectuerPaiement() {
        Client client = commande.getClient();
        if (client.debiterSolde(montant)) {
            statut = "VALIDE";
            commande.confirmer();
            System.out.println("Paiement reussi : " + montant + " DT");
            return true;
        }
        statut = "REFUSE";
        System.out.println("Paiement refuse : solde insuffisant");
        return false;
    }

    public void afficherRecu() {
        System.out.println("Recu paiement #" + id + " | " + montant + " DT | " + statut);
    }

    public int getId() { return id; }
    public Commande getCommande() { return commande; }
    public double getMontant() { return montant; }
    public String getMethodePaiement() { return methodePaiement; }
    public String getStatut() { return statut; }
    public String getDatePaiement() { return datePaiement; }
}
