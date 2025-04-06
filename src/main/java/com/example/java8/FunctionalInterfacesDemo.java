package com.example.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class FunctionalInterfacesDemo {
    public static void main(String[] args) {
        System.out.println("Démonstration des interfaces fonctionnelles en Java 8");
        
        List<String> noms = Arrays.asList("Jean", "Pierre", "Marie", "Sophie", "Alexandre", "Isabelle");
        
        // AVANT JAVA 8 : Utilisation de classes internes pour filtrer
        System.out.println("\nAVANT JAVA 8 :");
        
        // Filtrer les noms qui commencent par 'A'
        List<String> filtrésAvantJava8 = filtrerNoms(noms, new NomFilter() {
            @Override
            public boolean accepter(String nom) {
                return nom.startsWith("A");
            }
        });
        
        System.out.println("Noms commençant par 'A' :");
        for (String nom : filtrésAvantJava8) {
            System.out.println(nom);
        }
        
        // Filtrer les noms de plus de 5 lettres
        List<String> longsNomsAvantJava8 = filtrerNoms(noms, new NomFilter() {
            @Override
            public boolean accepter(String nom) {
                return nom.length() > 5;
            }
        });
        
        System.out.println("\nNoms de plus de 5 lettres :");
        for (String nom : longsNomsAvantJava8) {
            System.out.println(nom);
        }
        
        // AVEC JAVA 8 : Utilisation des interfaces fonctionnelles standard
        System.out.println("\nAVEC JAVA 8 (interfaces fonctionnelles) :");
        
        // Filtrer les noms qui commencent par 'A' avec Predicate
        List<String> filtrésJava8 = filtrerNomsJava8(noms, nom -> nom.startsWith("A"));
        
        System.out.println("Noms commençant par 'A' :");
        filtrésJava8.forEach(System.out::println);
        
        // Filtrer les noms de plus de 5 lettres avec Predicate
        List<String> longsNomsJava8 = filtrerNomsJava8(noms, nom -> nom.length() > 5);
        
        System.out.println("\nNoms de plus de 5 lettres :");
        longsNomsJava8.forEach(System.out::println);
        
        // Combiner des prédicats
        System.out.println("\nNoms commençant par 'A' ET de plus de 5 lettres :");
        Predicate<String> commenceParA = nom -> nom.startsWith("A");
        Predicate<String> plusDe5Lettres = nom -> nom.length() > 5;
        
        filtrerNomsJava8(noms, commenceParA.and(plusDe5Lettres))
            .forEach(System.out::println);
    }
    
    // Interface personnalisée pour le filtrage - avant Java 8
    interface NomFilter {
        boolean accepter(String nom);
    }
    
    // Méthode de filtrage avant Java 8
    static List<String> filtrerNoms(List<String> noms, NomFilter filter) {
        List<String> resultat = new ArrayList<>();
        for (String nom : noms) {
            if (filter.accepter(nom)) {
                resultat.add(nom);
            }
        }
        return resultat;
    }
    
    // Méthode de filtrage avec Java 8 utilisant l'interface fonctionnelle Predicate
    static List<String> filtrerNomsJava8(List<String> noms, Predicate<String> predicate) {
        List<String> resultat = new ArrayList<>();
        for (String nom : noms) {
            if (predicate.test(nom)) {
                resultat.add(nom);
            }
        }
        return resultat;
        
        // Ou plus simplement avec l'API Stream:
        // return noms.stream().filter(predicate).collect(Collectors.toList());
    }
}