package com.aglpro.models;

public class Utilisateur {
    private int id;
    private String nom;
    private String email;
    private String motDePasse;

    public Utilisateur() {}

    public Utilisateur(int id, String nom, 
                       String email, String motDePasse) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.motDePasse = motDePasse;
    }

    public boolean seConnecter(String email, String mdp) {
        if (this.email.equals(email) && 
            this.motDePasse.equals(mdp)) {
            System.out.println("Connexion réussie! Bienvenue " + nom);
            return true;
        }
        System.out.println("Email ou mot de passe incorrect");
        return false;
    }

    public void seDeconnecter() {
        System.out.println(nom + " déconnecté");
    }

    public int getId() { return id; }
    public String getNom() { return nom; }
    public String getEmail() { return email; }
    public void setId(int id) { this.id = id; }
    public void setNom(String nom) { this.nom = nom; }
    public void setEmail(String email) { this.email = email; }
}
