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