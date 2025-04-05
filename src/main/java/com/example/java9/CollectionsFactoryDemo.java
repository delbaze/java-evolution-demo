package com.example.java9;

import java.util.*;

/**
 * Démonstration des méthodes factory de collections introduites dans Java 9
 * Exercice: Convertir le code Java 8 en code Java 9 en utilisant les méthodes factory
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
        
        // La solution sera dévoilée lors de la correction...
    }
}