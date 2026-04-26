# AGLPROe-commerce

Prototype Java console pour un site e-commerce.

## Structure

```text
AGLPROe-commerce/
├── README.md
├── docs/diagrammes/
├── src/com/aglpro/ecommerce/models/
│   ├── Main.java
│   ├── Utilisateur.java
│   ├── Client.java
│   ├── Administrateur.java
│   ├── Produit.java
│   ├── Catalogue.java
│   ├── Panier.java
│   ├── LigneCommande.java
│   ├── Commande.java
│   ├── Paiement.java
│   ├── Transaction.java
│   └── Statistiques.java
└── tests/
```

## Compilation

```bash
javac -encoding UTF-8 -d out src/com/aglpro/ecommerce/models/*.java
java -cp out com.aglpro.ecommerce.models.Main
```
