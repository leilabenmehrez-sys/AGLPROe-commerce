package com.aglpro.ecommerce.models;

public class Transaction {
    private int id;
    private Paiement paiement;
    private String dateTransaction;

    public Transaction(int id, Paiement paiement, String dateTransaction) {
        this.id = id;
        this.paiement = paiement;
        this.dateTransaction = dateTransaction;
    }

    public void enregistrer() {
        System.out.println("Transaction #" + id + " enregistree le " + dateTransaction);
    }

    public int getId() { return id; }
    public Paiement getPaiement() { return paiement; }
    public String getDateTransaction() { return dateTransaction; }
}
