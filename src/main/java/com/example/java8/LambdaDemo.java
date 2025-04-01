package com.example.java8;

import java.util.Arrays;
import java.util.List;

public class LambdaDemo {

    public static void main(String[] args) {
        System.out.println("Démonstration des expressions lambda en Java 8");

        // Un exemple simple de lambda pour trier une liste
        List<String> noms = Arrays.asList("Jean", "Pierre", "Marie", "Sophie");

        // Tri avec lambda
        noms.sort((s1, s2) -> s1.compareTo(s2));

        // Affichage avec lambda
        noms.forEach(nom -> System.out.println(nom));
    }
}
