package org.example;

import java.util.Scanner;

public class GestionStock {

    static final int MAX_PRODUITS = 100;
    static Produit[] produits = new Produit[MAX_PRODUITS];
    static int taille = 0;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean quitter = false;
        while (!quitter) {
            printMenu();
            int choix = scanner.nextInt();
            scanner.nextLine();
            switch (choix) {
                case 1 -> menuAjouterProduit();
                case 2 -> menuModifierProduit();
                case 3 -> menuSupprimerProduit();
                case 4 -> afficherProduits();
                case 5 -> menuRechercherProduit();
                case 6 -> System.out.println("Valeur totale du stock : " + calculerValeurStock() + " DH");
                case 0 -> {
                    quitter = true;
                    System.out.println("Au revoir !");
                }
                default -> System.out.println("Choix invalide !");
            }
        }
    }

    public static void printMenu() {
        System.out.println("""
                \n=== MENU GESTION DE STOCK ===
                1. Ajouter un produit
                2. Modifier un produit
                3. Supprimer un produit
                4. Afficher tous les produits
                5. Rechercher un produit par nom
                6. Calculer la valeur totale du stock
                0. Quitter
                Votre choix : """);
    }

    public static void menuAjouterProduit() {
        if (taille >= MAX_PRODUITS) {
            System.out.println("Erreur : Stock plein !");
            return;
        }
        System.out.print("Code : ");
        int code = scanner.nextInt();
        scanner.nextLine();
        if (chercherIndexParCode(code) != -1) {
            System.out.println("Erreur : Code déjà utilisé.");
            return;
        }
        System.out.print("Nom : ");
        String nom = scanner.nextLine();
        System.out.print("Quantité : ");
        int quantite = scanner.nextInt();
        System.out.print("Prix : ");
        double prix = scanner.nextDouble();
        scanner.nextLine();
        if (quantite < 0 || prix < 0) {
            System.out.println("Quantité et prix doivent être positifs.");
            return;
        }
        produits[taille++] = new Produit(code, nom, quantite, prix);
        System.out.println("Produit ajouté !");
    }

    public static void menuModifierProduit() {
        System.out.print("Code du produit à modifier : ");
        int code = scanner.nextInt();
        scanner.nextLine();
        int index = chercherIndexParCode(code);
        if (index == -1) {
            System.out.println("Produit introuvable.");
            return;
        }
        System.out.print("Nouveau nom : ");
        String nom = scanner.nextLine();
        System.out.print("Nouvelle quantité : ");
        int quantite = scanner.nextInt();
        System.out.print("Nouveau prix : ");
        double prix = scanner.nextDouble();
        scanner.nextLine();
        if (quantite < 0 || prix < 0) {
            System.out.println("Valeurs invalides.");
            return;
        }
        produits[index].setNom(nom);
        produits[index].setQuantite(quantite);
        produits[index].setPrix(prix);
        System.out.println("Produit modifié.");
    }

    public static void menuSupprimerProduit() {
        System.out.print("Code du produit à supprimer : ");
        int code = scanner.nextInt();
        scanner.nextLine();
        int index = chercherIndexParCode(code);
        if (index == -1) {
            System.out.println("Produit non trouvé.");
            return;
        }
        for (int i = index; i < taille - 1; i++) {
            produits[i] = produits[i + 1];
        }
        produits[--taille] = null;
        System.out.println("Produit supprimé.");
    }

    public static void afficherProduits() {
        if (taille == 0) {
            System.out.println("Aucun produit en stock.");
            return;
        }
        System.out.println("\n--- Liste des produits ---");
        for (int i = 0; i < taille; i++) {
            System.out.println(produits[i]);
        }
    }

    public static void menuRechercherProduit() {
        System.out.print("Nom du produit : ");
        String nom = scanner.nextLine();
        boolean trouvé = false;
        for (int i = 0; i < taille; i++) {
            if (produits[i].getNom().equalsIgnoreCase(nom)) {
                System.out.println(produits[i]);
                trouvé = true;
            }
        }
        if (!trouvé) System.out.println("Aucun produit trouvé.");
    }

    public static double calculerValeurStock() {
        double total = 0;
        for (int i = 0; i < taille; i++) {
            total += produits[i].calculerValeur();
        }
        return total;
    }

    public static int chercherIndexParCode(int code) {
        for (int i = 0; i < taille; i++) {
            if (produits[i].getCode() == code) {
                return i;
            }
        }
        return -1;
    }
}
