package com.example.java9;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Exercice sur les améliorations de l'API Stream introduites dans Java 9
 */
public class StreamEnhancementsDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Exercice sur les améliorations de l'API Stream (Java 9) ===\n");
        
        Integer[] numbers = {2, 4, 6, 8, 9, 10, 12};
        System.out.println("Tableau de nombres: " + Arrays.toString(numbers));
        
        System.out.println("\n--- EXERCICE 1: takeWhile et dropWhile ---");
        System.out.println("En Java 8, si on veut prendre des éléments jusqu'à ce qu'une condition ne soit plus vraie,");
        System.out.println("on doit écrire un code complexe comme ceci:");
        
        // Java 8 - Approche pour simuler takeWhile
        List<Integer> takenManually = Arrays.stream(numbers)
                .collect(Collectors.toList());
        
        // Trouver l'index du premier élément impair
        int firstOddIndex = -1;
        for (int i = 0; i < takenManually.size(); i++) {
            if (takenManually.get(i) % 2 != 0) {
                firstOddIndex = i;
                break;
            }
        }
        
        // Prendre les éléments jusqu'à cet index
        if (firstOddIndex != -1) {
            takenManually = takenManually.subList(0, firstOddIndex);
        }
        
        System.out.println("Résultat (tous les nombres pairs du début): " + takenManually);
        
        System.out.println("\nConsigne: Utilisez la nouvelle méthode takeWhile de Java 9 pour obtenir le même résultat");
        System.out.println("Indice: numbers.stream().takeWhile(predicate)...");
        
        System.out.println("\n--- EXERCICE 2: iterate avec prédicat ---");
        System.out.println("En Java 8, pour créer un stream avec une condition de fin, on doit utiliser limit:");
        
        // Java 8 - iterate avec limit
        System.out.print("Nombres de 1 à 10 (Java 8): ");
        Stream.iterate(1, n -> n + 1)
              .limit(10)
              .forEach(n -> System.out.print(n + " "));
        System.out.println();
        
        System.out.println("\nConsigne: Utilisez la nouvelle version de iterate de Java 9 avec un prédicat");
        System.out.println("pour obtenir le même résultat mais sans utiliser limit()");
        System.out.println("Indice: Stream.iterate(valeurInitiale, predicat, operateur)...");
        
        System.out.println("\n--- EXERCICE 3: ofNullable ---");
        System.out.println("En Java 8, pour créer un stream à partir d'une valeur potentiellement null:");
        
        String value = getValue(true);  // Non-null
        Stream<String> streamBeforeJava9 = value == null ? Stream.empty() : Stream.of(value);
        System.out.println("Résultat avec valeur non-null: " + streamBeforeJava9.collect(Collectors.toList()));
        
        String nullValue = getValue(false);  // Null
        Stream<String> streamWithNull = nullValue == null ? Stream.empty() : Stream.of(nullValue);
        System.out.println("Résultat avec valeur null: " + streamWithNull.collect(Collectors.toList()));
        
        System.out.println("\nConsigne: Utilisez Stream.ofNullable de Java 9 pour simplifier ce code");
        System.out.println("Indice: Stream.ofNullable(value)...");
        
        System.out.println("\n--- EXERCICE BONUS ---");
        System.out.println("En Java 8, pour filtrer les valeurs null d'un tableau:");
        
        String[] arrayWithNulls = {"Un", null, "Deux", null, "Trois"};
        long countNonNull = Arrays.stream(arrayWithNulls)
                .filter(s -> s != null)
                .count();
        System.out.println("Nombre d'éléments non-null avec filter: " + countNonNull);
        
        System.out.println("\nConsigne: Utilisez flatMap avec ofNullable pour filtrer les valeurs null");
        System.out.println("Indice: flatMap(Stream::ofNullable)");
    }
    
    private static String getValue(boolean returnValue) {
        return returnValue ? "Valeur non-null" : null;
    }
}