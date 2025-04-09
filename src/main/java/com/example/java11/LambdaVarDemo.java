package com.example.java11;


import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class LambdaVarDemo {

    public static void main(String[] args) {
        System.out.println("Travaillez dans le fichier src/main/java/com/example/java11/LambdaVarDemo.java");

        List<String> names = List.of("Pierre", "Aurélien", "David");

        //FAIT TODO: Réécrivez ces lambdas en utilisant 'var'
        Consumer<String> printer = (var s) -> System.out.println(s.toUpperCase());
        Function<String, Integer> lengthFunc = (var s) -> s.length();

        names.forEach(printer);
        names.forEach(s -> System.out.println(lengthFunc.apply(s)));


        //FAIT TODO: Créez une BiFunction qui concatène deux chaînes et utilise 'var' 
        // avec l'annotation @NonNull pour indiquer que les paramètres ne doivent pas être null.
        BiFunction<String, String, String> concat = (@NonNull var s1, @NonNull var s2) -> {
            return s1.concat(s2);            
        };

        System.out.println("Concaténation:" + concat.apply("Hello ", "World"));

        // Exemple d'utilisation: concat.apply("Hello", "World") retourne "HelloWorld"
        //FAIT TODO: Créez une BiFunction qui vérifie si un nombre est compris entre deux bornes.
        // Utilisez 'var' avec des annotations personnalisées @Min et @Max pour indiquer

        BiFunction<Integer, Integer, Boolean> checkRange = (@Min(0) var min, @Max(100) var max) -> {
            return min <= max;
        };
        System.out.println("Plage valide: " + checkRange.apply(10, 50));
        // les contraintes sur les valeurs des paramètres.
        // Exemple d'utilisation: isInRange.apply(10, 20) qui vérifie si 10 ≤ x ≤ 20    }
    }

     // Définitions d'annotations pour l'exercice
     @interface NonNull {}
     @interface Min { int value(); }
     @interface Max { int value(); }
}
