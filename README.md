# Application de Gestion de Stock (Version POO)

Ce projet est une application console de gestion de stock développée en **Java** avec une approche **orientée objet**. Elle permet à une petite boutique de gérer ses produits de manière efficace.

## 🎯 Fonctionnalités

- ➕ Ajouter un produit
- ✏️ Modifier un produit existant (via son code)
- ❌ Supprimer un produit
- 📄 Afficher tous les produits
- 🔍 Rechercher un produit par nom
- 💰 Calculer la valeur totale du stock

## 🧱 Structure du projet

- **`Produit.java`** : Représente un produit avec ses attributs et comportements
- **`GestionStock.java`** : Classe principale contenant le menu et la logique métier

## 📐 Détails techniques

- Utilisation d’un **tableau d’objets** `Produit[]` (max 100 produits)
- Attributs encapsulés dans la classe `Produit`
- Utilisation de **getters/setters**
- Méthode `toString()` pour afficher les détails d’un produit
- Méthode `calculerValeur()` dans `Produit` pour retourner `quantité * prix`

## 📚 Exemple d'utilisation

```text
=== MENU GESTION DE STOCK ===
1. Ajouter un produit
2. Modifier un produit
3. Supprimer un produit
4. Afficher tous les produits
5. Rechercher un produit par nom
6. Calculer la valeur totale du stock
0. Quitter
