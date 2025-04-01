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
            System.out.println("1. Java 8 - Lambda et Interfaces fonctionnelles");
            System.out.println("2. Java 8 - Streams API");
            System.out.println("3. Java 9 - Collections Factory Methods");
            System.out.println("4. Java 9 - Stream API Enhancements");
            System.out.println("5. Java 9 - Private Interface Methods");
            System.out.println("0. Quitter");
            
            System.out.print("\nVotre choix: ");
            String choice = scanner.nextLine();
            
            switch (choice) {
                case "1":
                    System.out.println("\nDémo Java 8 - Lambda et Interfaces fonctionnelles");
                    try {
                        Class.forName("com.example.java8.LambdaDemo").getMethod("main", String[].class)
                            .invoke(null, (Object) new String[]{});
                    } catch (Exception e) {
                        System.out.println("Cette démo n'est pas encore implémentée ou une erreur s'est produite.");
                        e.printStackTrace();
                    }
                    break;
                case "2":
                    System.out.println("\nDémo Java 8 - Streams API");
                    try {
                        Class.forName("com.example.java8.StreamsDemo").getMethod("main", String[].class)
                            .invoke(null, (Object) new String[]{});
                    } catch (Exception e) {
                        System.out.println("Cette démo n'est pas encore implémentée ou une erreur s'est produite.");
                        e.printStackTrace();
                    }
                    break;
                case "3":
                    System.out.println("\nDémo Java 9 - Collections Factory Methods");
                    try {
                        Class.forName("com.example.java9.CollectionsFactoryDemo").getMethod("main", String[].class)
                            .invoke(null, (Object) new String[]{});
                    } catch (Exception e) {
                        System.out.println("Cette démo n'est pas encore implémentée ou une erreur s'est produite.");
                        e.printStackTrace();
                    }
                    break;
                case "4":
                    System.out.println("\nDémo Java 9 - Stream API Enhancements");
                    try {
                        Class.forName("com.example.java9.StreamEnhancementsDemo").getMethod("main", String[].class)
                            .invoke(null, (Object) new String[]{});
                    } catch (Exception e) {
                        System.out.println("Cette démo n'est pas encore implémentée ou une erreur s'est produite.");
                        e.printStackTrace();
                    }
                    break;
                case "5":
                    System.out.println("\nDémo Java 9 - Private Interface Methods");
                    try {
                        Class.forName("com.example.java9.PrivateInterfaceMethodsDemo").getMethod("main", String[].class)
                            .invoke(null, (Object) new String[]{});
                    } catch (Exception e) {
                        System.out.println("Cette démo n'est pas encore implémentée ou une erreur s'est produite.");
                        e.printStackTrace();
                    }
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
}
