package com.aglpro.ecommerce.models;

public class Utilisateur {
    protected int id;
    protected String nom;
    protected String prenom;
    protected String email;
    protected String motDePasse;
    protected boolean estConnecte;

    public Utilisateur() {
        this.estConnecte = false;
    }

    public Utilisateur(int id, String nom, String prenom, String email, String motDePasse) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.motDePasse = motDePasse;
        this.estConnecte = false;
    }

    public void sInscrire() {
        System.out.println("Compte cree pour : " + prenom + " " + nom);
    }

    public boolean seConnecter(String email, String motDePasse) {
        if (this.email != null && this.motDePasse != null
                && this.email.equals(email) && this.motDePasse.equals(motDePasse)) {
            this.estConnecte = true;
            System.out.println("Connexion reussie pour : " + prenom + " " + nom);
            return true;
        }
        System.out.println("Echec de connexion");
        return false;
    }

    public void seDeconnecter() {
        this.estConnecte = false;
        System.out.println("Deconnexion reussie");
    }

    public void afficherDetails() {
        System.out.println("Utilisateur #" + id + " : " + prenom + " " + nom + " - " + email);
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getMotDePasse() { return motDePasse; }
    public void setMotDePasse(String motDePasse) { this.motDePasse = motDePasse; }
    public boolean isEstConnecte() { return estConnecte; }
}
