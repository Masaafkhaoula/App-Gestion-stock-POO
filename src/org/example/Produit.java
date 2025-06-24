package org.example;

public class Produit {
    private int code;
    private String nom;
    private int quantite;
    private double prix;

    // Constructeur par défaut
    public Produit() {}

    // Constructeur avec tous les attributs
    public Produit(int code, String nom, int quantite, double prix) {
        this.code = code;
        this.nom = nom;
        this.quantite = quantite;
        this.prix = prix;
    }

    // Getters et Setters
    public int getCode() { return code; }
    public void setCode(int code) { this.code = code; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public int getQuantite() { return quantite; }
    public void setQuantite(int quantite) { this.quantite = quantite; }

    public double getPrix() { return prix; }
    public void setPrix(double prix) { this.prix = prix; }

    // toString pour afficher les détails du produit
    @Override
    public String toString() {
        return "Code: " + code + ", Nom: " + nom + ", Quantité: " + quantite + ", Prix: " + prix + " DH";
    }

    // Méthode pour calculer la valeur totale du produit en stock
    public double calculerValeur() {
        return quantite * prix;
    }
}
