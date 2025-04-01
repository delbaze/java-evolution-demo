package com.example.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Cette classe démontre l'utilisation de l'API Stream introduite dans Java 8
 * avec des exemples avant/après pour mieux comprendre les avantages.
 */
public class StreamsDemo {

    public static void main(String[] args) {
        System.out.println("=== Démonstration de l'API Stream ===\n");
        
        // PARTIE 1: Filtrage et transformation
        filtrageEtTransformation();
        
        // PARTIE 2: Opérations de réduction
        operationsDeReduction();
        
        // PARTIE 3: Collect - Regroupement et partitionnement
        collectOperations();
    }
    
    /**
     * Démontre le filtrage et la transformation avec et sans streams
     */
    private static void filtrageEtTransformation() {
        System.out.println("PARTIE 1: FILTRAGE ET TRANSFORMATION\n");
        
        List<String> mots = Arrays.asList("Java", "Stream", "API", "Lambda", "Collection", "Interface", "Fonctionnelle");
        
        System.out.println("Liste originale: " + mots);
        
        // AVANT JAVA 8: Filtrer les mots de plus de 6 lettres et les mettre en majuscules
        System.out.println("\nAVANT JAVA 8:");
        List<String> resultatAvant = new ArrayList<>();
        
        for (String mot : mots) {
            if (mot.length() > 6) {
                resultatAvant.add(mot.toUpperCase());
            }
        }
        
        System.out.println("Mots de plus de 6 lettres en majuscules: " + resultatAvant);
        
        // AVEC JAVA 8: La même opération avec l'API Stream
        System.out.println("\nAVEC JAVA 8 (API Stream):");
        List<String> resultatApres = mots.stream()
                                        .filter(mot -> mot.length() > 6)
                                        .map(String::toUpperCase)
                                        .collect(Collectors.toList());
        
        System.out.println("Mots de plus de 6 lettres en majuscules: " + resultatApres);
        
        // Exemple supplémentaire: opération flatMap
        System.out.println("\nExemple de flatMap - Transformer une liste de phrases en mots distincts:");
        
        List<String> phrases = Arrays.asList(
            "Java est un langage de programmation",
            "Les streams sont une fonctionnalité puissante",
            "Java 8 a introduit de nombreuses améliorations"
        );
        
        // AVANT JAVA 8
        System.out.println("\nAVANT JAVA 8:");
        List<String> motsUniquesAvant = new ArrayList<>();
        
        for (String phrase : phrases) {
            String[] motsDansPhrase = phrase.split(" ");
            for (String mot : motsDansPhrase) {
                if (!motsUniquesAvant.contains(mot)) {
                    motsUniquesAvant.add(mot);
                }
            }
        }
        
        System.out.println("Mots uniques: " + motsUniquesAvant);
        
        // AVEC JAVA 8
        System.out.println("\nAVEC JAVA 8 (avec flatMap):");
        List<String> motsUniquesApres = phrases.stream()
                                              .flatMap(phrase -> Arrays.stream(phrase.split(" ")))
                                              .distinct()
                                              .collect(Collectors.toList());
        
        System.out.println("Mots uniques: " + motsUniquesApres);
    }
    
    /**
     * Démontre les opérations de réduction avec et sans streams
     */
    private static void operationsDeReduction() {
        System.out.println("\nPARTIE 2: OPÉRATIONS DE RÉDUCTION\n");
        
        List<Integer> nombres = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        System.out.println("Liste de nombres: " + nombres);
        
        // AVANT JAVA 8: Calculer la somme des nombres pairs
        System.out.println("\nAVANT JAVA 8:");
        int sommeAvant = 0;
        
        for (int nombre : nombres) {
            if (nombre % 2 == 0) {
                sommeAvant += nombre;
            }
        }
        
        System.out.println("Somme des nombres pairs: " + sommeAvant);
        
        // AVEC JAVA 8: La même opération avec l'API Stream
        System.out.println("\nAVEC JAVA 8 (API Stream):");
        int sommeApres = nombres.stream()
                              .filter(n -> n % 2 == 0)
                              .mapToInt(Integer::intValue)
                              .sum();
        
        System.out.println("Somme des nombres pairs: " + sommeApres);
        
        // Autre exemple: Utilisation de reduce pour multiplier tous les nombres
        System.out.println("\nUtilisation de reduce pour calculer le produit des nombres:");
        
        // AVANT JAVA 8
        int produitAvant = 1;
        for (int nombre : nombres) {
            produitAvant *= nombre;
        }
        
        System.out.println("AVANT JAVA 8 - Produit: " + produitAvant);
        
        // AVEC JAVA 8
        Optional<Integer> produitOptional = nombres.stream()
                                                 .reduce((a, b) -> a * b);
        
        int produitApres = produitOptional.orElse(0);
        System.out.println("AVEC JAVA 8 - Produit: " + produitApres);
        
        // Exemple avec reduce qui prend une valeur initiale
        int produitAvecValeurInitiale = nombres.stream()
                                             .reduce(1, (a, b) -> a * b);
        
        System.out.println("AVEC JAVA 8 (valeur initiale) - Produit: " + produitAvecValeurInitiale);
    }
    
    /**
     * Démontre les opérations collect avec et sans streams
     */
    private static void collectOperations() {
        System.out.println("\nPARTIE 3: COLLECT - REGROUPEMENT ET PARTITIONNEMENT\n");
        
        // Classe interne pour l'exemple
        class Personne {
            private final String nom;
            private final String ville;
            private final int age;
            
            public Personne(String nom, String ville, int age) {
                this.nom = nom;
                this.ville = ville;
                this.age = age;
            }
            
            public String getNom() { return nom; }
            public String getVille() { return ville; }
            public int getAge() { return age; }
            
            @Override
            public String toString() {
                return nom + " (" + age + " ans, " + ville + ")";
            }
        }
        
        List<Personne> personnes = Arrays.asList(
            new Personne("Alice", "Paris", 30),
            new Personne("Bob", "Lyon", 25),
            new Personne("Charlie", "Paris", 35),
            new Personne("David", "Lyon", 28),
            new Personne("Eve", "Paris", 22),
            new Personne("Frank", "Marseille", 40)
        );
        
        System.out.println("Liste de personnes:");
        for (Personne p : personnes) {
            System.out.println("  " + p);
        }
        
        // AVANT JAVA 8: Grouper les personnes par ville
        System.out.println("\nAVANT JAVA 8 - Personnes groupées par ville:");
        Map<String, List<Personne>> parVilleAvant = new java.util.HashMap<>();
        
        for (Personne p : personnes) {
            String ville = p.getVille();
            if (!parVilleAvant.containsKey(ville)) {
                parVilleAvant.put(ville, new ArrayList<>());
            }
            parVilleAvant.get(ville).add(p);
        }
        
        for (Map.Entry<String, List<Personne>> entry : parVilleAvant.entrySet()) {
            System.out.println("  " + entry.getKey() + ":");
            for (Personne p : entry.getValue()) {
                System.out.println("    - " + p.getNom() + " (" + p.getAge() + " ans)");
            }
        }
        
        // AVEC JAVA 8: Grouper les personnes par ville
        System.out.println("\nAVEC JAVA 8 - Personnes groupées par ville:");
        Map<String, List<Personne>> parVilleApres = personnes.stream()
                                                           .collect(Collectors.groupingBy(Personne::getVille));
        
        parVilleApres.forEach((ville, list) -> {
            System.out.println("  " + ville + ":");
            list.forEach(p -> System.out.println("    - " + p.getNom() + " (" + p.getAge() + " ans)"));
        });
        
        // AVANT JAVA 8: Partitionner les personnes par âge (plus ou moins de 30 ans)
        System.out.println("\nAVANT JAVA 8 - Personnes partitionnées par âge (< 30 ans):");
        List<Personne> jeunesAvant = new ArrayList<>();
        List<Personne> adultesAvant = new ArrayList<>();
        
        for (Personne p : personnes) {
            if (p.getAge() < 30) {
                jeunesAvant.add(p);
            } else {
                adultesAvant.add(p);
            }
        }
        
        System.out.println("  Moins de 30 ans:");
        for (Personne p : jeunesAvant) {
            System.out.println("    - " + p.getNom() + " (" + p.getAge() + " ans)");
        }
        
        System.out.println("  30 ans et plus:");
        for (Personne p : adultesAvant) {
            System.out.println("    - " + p.getNom() + " (" + p.getAge() + " ans)");
        }
        
        // AVEC JAVA 8: Partitionner les personnes par âge
        System.out.println("\nAVEC JAVA 8 - Personnes partitionnées par âge (< 30 ans):");
        Map<Boolean, List<Personne>> partitionParAge = personnes.stream()
                                                             .collect(Collectors.partitioningBy(p -> p.getAge() < 30));
        
        System.out.println("  Moins de 30 ans:");
        partitionParAge.get(true).forEach(p -> System.out.println("    - " + p.getNom() + " (" + p.getAge() + " ans)"));
        
        System.out.println("  30 ans et plus:");
        partitionParAge.get(false).forEach(p -> System.out.println("    - " + p.getNom() + " (" + p.getAge() + " ans)"));
    }
}