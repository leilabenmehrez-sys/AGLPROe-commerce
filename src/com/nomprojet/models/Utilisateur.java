package com.nomprojet.models;

/**
 * Classe représentant un utilisateur dans le système AGL Pro.
 */
public class Utilisateur {

    // Champs privés
    private int id;
    private String nom;
    private String email;
    private String motDePasse;
    private String dateInscription;

    /**
     * Constructeur vide pour créer un utilisateur sans initialisation.
     */
    public Utilisateur() {
    }

    /**
     * Constructeur complet pour initialiser tous les champs de l'utilisateur.
     * @param id L'identifiant unique de l'utilisateur
     * @param nom Le nom de l'utilisateur
     * @param email L'adresse email de l'utilisateur
     * @param motDePasse Le mot de passe de l'utilisateur
     * @param dateInscription La date d'inscription de l'utilisateur
     */
    public Utilisateur(int id, String nom, String email, String motDePasse, String dateInscription) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.motDePasse = motDePasse;
        this.dateInscription = dateInscription;
    }

    /**
     * Méthode pour permettre à l'utilisateur de se connecter.
     */
    public void seConnecter() {
    }

    /**
     * Méthode pour permettre à l'utilisateur de se déconnecter.
     */
    public void seDeconnecter() {
    }

    /**
     * Méthode pour permettre à l'utilisateur de modifier son profil.
     */
    public void modifierProfil() {
    }

    // Getters et setters

    /**
     * Getter pour l'identifiant de l'utilisateur.
     * @return L'identifiant de l'utilisateur
     */
    public int getId() {
        return id;
    }

    /**
     * Setter pour l'identifiant de l'utilisateur.
     * @param id L'identifiant de l'utilisateur
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter pour le nom de l'utilisateur.
     * @return Le nom de l'utilisateur
     */
    public String getNom() {
        return nom;
    }

    /**
     * Setter pour le nom de l'utilisateur.
     * @param nom Le nom de l'utilisateur
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Getter pour l'email de l'utilisateur.
     * @return L'email de l'utilisateur
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter pour l'email de l'utilisateur.
     * @param email L'email de l'utilisateur
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Getter pour le mot de passe de l'utilisateur.
     * @return Le mot de passe de l'utilisateur
     */
    public String getMotDePasse() {
        return motDePasse;
    }

    /**
     * Setter pour le mot de passe de l'utilisateur.
     * @param motDePasse Le mot de passe de l'utilisateur
     */
    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    /**
     * Getter pour la date d'inscription de l'utilisateur.
     * @return La date d'inscription de l'utilisateur
     */
    public String getDateInscription() {
        return dateInscription;
    }

    /**
     * Setter pour la date d'inscription de l'utilisateur.
     * @param dateInscription La date d'inscription de l'utilisateur
     */
    public void setDateInscription(String dateInscription) {
        this.dateInscription = dateInscription;
    }

    /**
     * Méthode toString pour afficher les informations de l'utilisateur.
     * @return Une chaîne représentant l'utilisateur
     */
    @Override
    public String toString() {
        return "Utilisateur{id=" + id + ", nom='" + nom + "', email='" + email + "', motDePasse='" + motDePasse + "', dateInscription='" + dateInscription + "'}";
    }

    /**
     * Méthode pour afficher les détails de l'utilisateur dans la console.
     */
    public void afficherDetails() {
        System.out.println("Détails de l'utilisateur :");
        System.out.println("ID : " + id);
        System.out.println("Nom : " + nom);
        System.out.println("Email : " + email);
        System.out.println("Mot de passe : " + motDePasse);
        System.out.println("Date d'inscription : " + dateInscription);
    }
}