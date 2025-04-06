package com.example.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaDemo {
    public static void main(String[] args) {
        System.out.println("Démonstration des expressions lambda en Java 8");
        
        List<String> noms = Arrays.asList("Jean", "Pierre", "Marie", "Sophie");
        
        // AVANT JAVA 8 : Utilisation de classes anonymes
        System.out.println("\nAVANT JAVA 8 :");
        
        // Tri avec une classe anonyme implémentant Comparator
        Collections.sort(noms, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });
        
        // Affichage avec une boucle for classique
        System.out.println("Résultat du tri :");
        for (String nom : noms) {
            System.out.println(nom);
        }
        
        // Mélanger à nouveau la liste pour la deuxième démo
        Collections.shuffle(noms);
        
        // AVEC JAVA 8 : Utilisation des expressions lambda
        System.out.println("\nAVEC JAVA 8 (lambdas) :");
        
        // Tri avec lambda
        noms.sort((s1, s2) -> s1.compareTo(s2));
        
        // Affichage avec lambda
        System.out.println("Résultat du tri :");
        noms.forEach(nom -> System.out.println(nom));
    }
}