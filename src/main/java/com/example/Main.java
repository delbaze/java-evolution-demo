package com.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Java version: " + System.getProperty("java.version"));
        System.out.println("Java Evolution Demo");
        System.out.println("===================");

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nChoisissez une démo à exécuter:");
            System.out.println("1. Java 8 - Lambda");
            System.out.println("2. Java 8 - Interfaces fonctionnelles");
            System.out.println("3. Java 8 - Streams API");
            System.out.println("4. Java 9 - Collections Factory Methods");
            System.out.println("5. Java 9 - Stream API Enhancements");
            System.out.println("6. Java 9 - Private Interface Methods");
            System.out.println("7. Java 9 - Optional API Enhancements");
            System.out.println("8. Java 9 - Module System Demo");
            System.out.println("9. Java 9 - Process API Demo");
            System.out.println("10. Java 10 - Var");
            System.out.println("11. Java 11 - String Enhancements");
            System.out.println("12. Java 11 - Client HTTP");
            System.out.println("13. Java 11 - Lambda var");
            System.out.println("14. Java 12 - Switch avant Java 12");
            System.out.println("15. Java 12 - Switch avec Java 12");
            System.out.println("16. Java 13 - Switch avec Java 13");
            System.out.println("17. Java 14 - Switch avec Java 14");
            System.out.println("18. Java 12 - Blocs de chaines avant Java 13");
            System.out.println("19. Java 13 - Blocs de chaines avec Java 13");
            System.out.println("20. Java 14 - Blocs de chaines avec Java 14");
            System.out.println("21. Java 15 - Blocs de chaines avec Java 15");
            System.out.println("22. Java 14 - Pattern Matching instanceof");
            System.out.println("23. Java 15 - Pattern Matching instanceof (exo)");
            System.out.println("24. Java 14 - Records");
            System.out.println("25. Java 17 - Sealed Classes");
            System.out.println("0. Quitter");

            System.out.print("\nVotre choix: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    runDemo("Démo Java 8 - Lambda", "com.example.java8.LambdaDemo");
                    break;
                case "2":
                    runDemo("Démo Java 8 - Interfaces fonctionnelles", "com.example.java8.FunctionalInterfacesDemo");
                    break;
                case "3":
                    runDemo("Démo Java 8 - Streams API", "com.example.java8.StreamsDemo");
                    break;
                case "4":
                    runDemo("Démo Java 9 - Collections Factory Methods", "com.example.java9.CollectionsFactoryDemo");
                    break;
                case "5":
                    runDemo("Démo Java 9 - Stream API Enhancements", "com.example.java9.StreamEnhancementsDemo");
                    break;
                case "6":
                    runDemo("Démo Java 9 - Private Interface Methods", "com.example.java9.PrivateInterfaceMethodsDemo");
                    break;
                case "7":
                    runDemo("Démo Java 9 - Optional API Enhancements", "com.example.java9.OptionalEnhancementsDemo");
                    break;
                case "8":
                    runDemo("Démo Java 9 - Module System", "com.example.java9.ModularityDemo");
                    break;
                case "9":
                    runDemo("Démo Java 9 - Process API", "com.example.java9.ProcessApiDemo");
                    break;
                case "10":
                    runDemo("Démo Java 10 - Var", "com.example.java10.VarDemo");
                    break;
                case "11":
                    runDemo("Démo Java 11 - String Enhancements", "com.example.java11.StringMethodsDemo");
                    break;
                case "12":
                    runDemo("Démo Java 11 - Client HTTP", "com.example.java11.HttpClientDemo");
                    break;
                case "13":
                    runDemo("Démo Java 11 - Lambda var", "com.example.java11.LambdaVarDemo");
                    break;
                case "14":
                    runDemo("Démo Java 12 - Switch avant Java 12", "com.example.java12.SwitchDemo");
                    break;
                case "15":
                    runDemo("Démo Java 12 - Switch avec Java 12", "com.example.java12.SwitchDemo2");
                    break;
                case "16":
                    runDemo("Démo Java 13 - Switch avec Java 13", "com.example.java13.SwitchDemo");
                    break;
                case "17":
                    runDemo("Démo Java 14 - Switch avec Java 14", "com.example.java14.SwitchMonthDay");
                    break;
                case "18":
                    runDemo("Démo Java 12 - Blocs de chaines avant Java 13", "com.example.java12.StringBeforeTextBlock");
                    break;
                case "19":
                    runDemo("Démo Java 13 - Blocs de chaines avec Java 13", "com.example.java13.StringWithTextBlock");
                    break;
                case "20":
                    runDemo("Démo Java 14 - Blocs de chaines avec Java 14", "com.example.java14.StringWithTextBlock");
                    break;
                case "21":
                    runDemo("Démo Java 15 - Blocs de chaines avec Java 15", "com.example.java15.TextBlocks");
                    break;
                case "22":
                    runDemo("Démo Java 14 - Pattern Matching instanceof", "com.example.java14.PatternMatching");
                    break;
                case "23":
                    runDemo("Démo Java 15 - Pattern Matching instanceof (exo)", "com.example.java15.PatternMatching");
                    break;
                case "24":
                    runDemo("Démo Java 14 - Records", "com.example.java14.Records");
                    break;
                case "25":
                    runDemo("Démo Java 17 - Sealed Classes", "com.example.java17.SealedClasses");
                    break;
                case "0":
                    exit = true;
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }

        scanner.close();
        System.out.println("Au revoir!");
    }

    // Méthode réutilisable pour exécuter une démo
    private static void runDemo(String demoTitle, String className) {
        System.out.println("\n" + demoTitle);
        try {
            Class.forName(className)
                    .getMethod("main", String[].class)
                    .invoke(null, (Object) new String[]{});
        } catch (Exception e) {
            System.out.println("Cette démo n'est pas encore implémentée ou une erreur s'est produite.");
            e.printStackTrace();
        }
    }
}
