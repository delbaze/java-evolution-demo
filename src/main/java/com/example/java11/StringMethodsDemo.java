package com.example.java11;

/**
 * ----------------------- * Vous devez obtenir ce résultat :
 *
 * Entrée : "Hello" -> Valide Entrée : "" -> Invalide (vide ou espaces) Entrée :
 * " " -> Invalide (vide ou espaces) Entrée : null -> Invalide (null)
 *
 * Exercice 2 - Analyse du journal utilisateur : Nombre de lignes : 3 Dates
 * extraites : 2023-01-01 2023-01-02 2023-01-03
 *
 * Exercice 3 - Formatage de la citation : **** La vie est belle *****
 *
 *
 * ------------------------*
 */
public class StringMethodsDemo {

    public static void main(String[] args) {
        System.out.println("Travaillez dans le fichier src/main/java/com/example/java11/StringMethodsDemo.java");
        // Exercice 1: Utilisez isBlank pour valider l'entrée utilisateur
        String[] inputs = {"Hello", "", "   ", null};
        System.out.println("Exercice 1 - Validation des entrées :");

        for (String input : inputs) {
            if (input == null) {
                System.out.println("Entrée: null -> invalide (null)");
            } else if (input.isBlank()) {
                System.out.println("Entrée: \"" + input + "\" -> invalide (vide ou espaces)");
            } else {
                System.out.println("Entrée: \"" + input + "\" -> Valide");
            }
        }

        System.out.println();
        System.out.println("Exercice 2 - Analyse du journal utilisateur :");
        // Exercice 2: Utilisez lines() pour compter et extraire les lignes
        String userLog = "2023-01-01: Login\n2023-01-02: Update profile\n2023-01-03: Logout";
        long lineCount = userLog.lines().count();

        System.out.println("Nombre de lignes: " + lineCount);

        userLog.lines()
                .map(line -> line.split(":")[0])
                .forEach(System.out::println);

        System.out.println();

        System.out.println("Exercice 3 - Formatage de la citation :");

        // Exercice 3: Utilisez strip et repeat pour formater un texte
        String quote = "  La vie est belle  ";
        String cleanedQuote = quote.strip();
        String stars = "*".repeat(5);
        String formattedQuote = stars + " " + cleanedQuote + " " + stars;

        System.out.println(formattedQuote);

        // TODO: Enlevez les espaces et encadrez la citation avec des étoiles
    }
}
