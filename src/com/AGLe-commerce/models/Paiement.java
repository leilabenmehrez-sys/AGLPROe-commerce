package com.aglpro.ecommerce.models;
public class Paiement {

    private int id;
    private Commande commande;
    private double montant;
    private String methodePaiement; // CARTE, VIREMENT, LIVRAISON
    private String statut;          // EN_COURS, VALIDE, REFUSE
    private String datePaiement;
    private String reference;

    public Paiement() { this.statut = "EN_COURS"; }

    public Paiement(int id, Commande commande, String methodePaiement, String datePaiement) {
        this.id = id;
        this.commande = commande;
        this.montant = commande.getMontantTotal();
        this.methodePaiement = methodePaiement;
        this.statut = "EN_COURS";
        this.datePaiement = datePaiement;
        this.reference = "PAY-" + id + "-" + datePaiement.replace("/", "");
    }

    public boolean effectuerPaiement() {
        Client client = commande.getClient();
        if (client.debiterSolde(this.montant)) {
            this.statut = "VALIDE";
            commande.confirmer();
            return true;
        }
        this.statut = "REFUSE";
        return false;
    }

    public void genererRecu() {
        System.out.println("  ─────────────────────────────────");
        System.out.println("  REÇU DE PAIEMENT — AGL.pro");
        System.out.println("  Référence   : " + reference);
        System.out.println("  Date        : " + datePaiement);
        System.out.println("  Méthode     : " + methodePaiement);
        System.out.printf ("  Montant     : %.2f DT%n", montant);
        System.out.println("  Statut      : " + statut);
        System.out.println("  ─────────────────────────────────");
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public Commande getCommande() { return commande; }
    public void setCommande(Commande c) { this.commande = c; }
    public double getMontant() { return montant; }
    public void setMontant(double m) { this.montant = m; }
    public String getMethodePaiement() { return methodePaiement; }
    public void setMethodePaiement(String m) { this.methodePaiement = m; }
    public String getStatut() { return statut; }
    public void setStatut(String s) { this.statut = s; }
    public String getDatePaiement() { return datePaiement; }
    public void setDatePaiement(String d) { this.datePaiement = d; }
    public String getReference() { return reference; }
    public void setReference(String r) { this.reference = r; }
}