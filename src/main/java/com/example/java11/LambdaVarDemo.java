package com.example.java11;


import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class LambdaVarDemo {

    public static void main(String[] args) {
        System.out.println("Travaillez dans le fichier src/main/java/com/example/java11/LambdaVarDemo.java");

        List<String> names = List.of("Pierre", "Aurélien", "David");

        // TODO: Réécrivez ces lambdas en utilisant 'var'
        Consumer<String> printer = (String s) -> System.out.println(s.toUpperCase());
        Function<String, Integer> lengthFunc = (String s) -> s.length();

        // TODO: Créez une BiFunction qui concatène deux chaînes et utilise 'var' 
        // avec l'annotation @NonNull pour indiquer que les paramètres ne doivent pas être null.
        // Exemple d'utilisation: concat.apply("Hello", "World") retourne "HelloWorld"
        // TODO: Créez une BiFunction qui vérifie si un nombre est compris entre deux bornes.
        // Utilisez 'var' avec des annotations personnalisées @Min et @Max pour indiquer
        // les contraintes sur les valeurs des paramètres.
        // Exemple d'utilisation: isInRange.apply(10, 20) qui vérifie si 10 ≤ x ≤ 20    }
    }

     // Définitions d'annotations pour l'exercice
     @interface NonNull {}
     @interface Min { int value(); }
     @interface Max { int value(); }
}
