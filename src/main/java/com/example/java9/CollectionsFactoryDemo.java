package com.example.java9;

import java.util.*;

/**
 * Démonstration des méthodes factory de collections introduites dans Java 9
 * Exercice: Convertir le code Java 8 en code Java 9 en utilisant les méthodes
 * factory
 */
public class CollectionsFactoryDemo {

    public static void main(String[] args) {
        System.out.println("=== Démonstration des méthodes factory de collections (Java 9) ===\n");

        System.out.println("APPROCHE JAVA 8:");
        // Code Java 8 pour créer des collections immuables
        List<String> couleurs = new ArrayList<>();
        couleurs.add("Rouge");
        couleurs.add("Vert");
        couleurs.add("Bleu");
        couleurs = Collections.unmodifiableList(couleurs);
        System.out.println("Liste immuable (Java 8): " + couleurs);

        Map<String, Integer> scores = new HashMap<>();
        scores.put("Alice", 95);
        scores.put("Bob", 87);
        scores.put("Charlie", 91);
        scores = Collections.unmodifiableMap(scores);
        System.out.println("Map immuable (Java 8): " + scores);

        Set<Integer> nombresPremiers = new HashSet<>();
        nombresPremiers.add(2);
        nombresPremiers.add(3);
        nombresPremiers.add(5);
        nombresPremiers.add(7);
        nombresPremiers = Collections.unmodifiableSet(nombresPremiers);
        System.out.println("Set immuable (Java 8): " + nombresPremiers);

        System.out.println("\n--- EXERCICE ---");
        System.out.println("Consigne: Réécrivez le code ci-dessus en utilisant les méthodes factory de Java 9.");
        System.out.println("Objectif: Créer les mêmes collections immuables en une seule ligne.");
        System.out.println("Indice: Utilisez List.of(), Set.of() et Map.of()\n");

        System.out.println("---------JAVA 9 +");
        try {
            List<String> couleursJ9 = List.of("Rouge", "Vert", "Bleu");
            System.out.println("Liste immuable (Java 9): " + couleursJ9);
        } catch (NullPointerException e) {
            System.out.println("Erreur : List.of() ne tolère pas de valeur null");
        }

        try {
            Set<Integer> nombresPremiersJ9 = Set.of(2, 3, 5, 7);
            System.out.println("Set immuable (Java 9): " + nombresPremiersJ9);
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur : Set.of() ne tolère pas de doublon");
        } catch (NullPointerException e) {
            System.out.println("Erreur : Set.of() ne tolère pas de valeur null");
        }

        try {
            Map<String, Integer> scoresJ9 = Map.of("Alice", 95, "Bob", 87, "Charlie", 91);
            System.out.println("Map immuable (Java 9): " + scoresJ9);
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur : Map.of() ne tolère pas de clé dupliquées");
        } catch (NullPointerException e) {
            System.out.println("Erreur : Map.of() ne tolère pas de valeur null");
        }

    }
}
