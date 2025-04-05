package com.example.java9;

/**
 * Exercice sur le système de modules de Java 9
 * 
 * Note: Cet exercice est particulier car la mise en place de modules
 * nécessite de modifier la structure de votre projet plutôt que simplement
 * modifier une classe. Les instructions ci-dessous vous guideront à travers
 * les étapes à suivre.
 */
public class ModularityDemo {
    public static void main(String[] args) {
        System.out.println("=== Exercice sur le système de modules (Java 9) ===\n");
        
        System.out.println("Pour cet exercice, vous allez créer un projet modulaire avec deux modules:");
        System.out.println("1. Un module 'calculator' qui fournit des services de calcul");
        System.out.println("2. Un module 'application' qui utilise ces services\n");
        
        System.out.println("Voici les étapes à suivre:\n");
        
        System.out.println("ÉTAPE 1: Créez la structure de répertoires suivante:");
        System.out.println("""
            project-root/
            ├── calculator/
            │   ├── src/
            │   │   ├── main/
            │   │   │   ├── java/
            │   │   │   │   ├── module-info.java
            │   │   │   │   └── com/
            │   │   │   │       └── example/
            │   │   │   │           └── calculator/
            │   │   │   │               ├── Calculator.java
            │   │   │   │               └── impl/
            │   │   │   │                   └── BasicCalculator.java
            ├── application/
                ├── src/
                │   ├── main/
                │   │   ├── java/
                │   │   │   ├── module-info.java
                │   │   │   └── com/
                │   │   │       └── example/
                │   │   │           └── application/
                │   │   │               └── Main.java
        """);

        System.out.println("\nÉTAPE 2: Créez les fichiers 'module-info.java'");
        System.out.println("\nPour le module 'calculator':");
        System.out.println("""
            // TODO 1: Dans calculator/src/main/java/module-info.java
            // Déclarez un module nommé 'com.example.calculator'
            // Exportez le package com.example.calculator
            // N'exportez PAS le package com.example.calculator.impl
        """);
        
        System.out.println("\nPour le module 'application':");
        System.out.println("""
            // TODO 2: Dans application/src/main/java/module-info.java
            // Déclarez un module nommé 'com.example.application'
            // Indiquez que ce module requiert le module 'com.example.calculator'
        """);
        
        System.out.println("\nÉTAPE 3: Implémentez les classes du module 'calculator'");
        System.out.println("\nTODO 3: Dans Calculator.java:");
        System.out.println("""
            // Créez une interface Calculator avec les méthodes:
            // - add(double a, double b)
            // - subtract(double a, double b)
            // - multiply(double a, double b)
            // - divide(double a, double b)
        """);
        
        System.out.println("\nTODO 4: Dans BasicCalculator.java:");
        System.out.println("""
            // Implémentez l'interface Calculator
            // Cette classe sera dans le package non exporté com.example.calculator.impl
        """);
        
        System.out.println("\nTODO 5: Ajoutez une méthode factory dans l'interface Calculator:");
        System.out.println("""
            // Ajoutez cette méthode statique:
            // static Calculator getInstance() {
            //     return new com.example.calculator.impl.BasicCalculator();
            // }
        """);
        
        System.out.println("\nÉTAPE 4: Implémentez la classe Main du module 'application'");
        System.out.println("\nTODO 6: Dans Main.java:");
        System.out.println("""
            // Créez une classe Main avec une méthode main qui:
            // - Obtient une instance de Calculator en utilisant Calculator.getInstance()
            // - Effectue quelques opérations de base (addition, multiplication, etc.)
            // - Affiche les résultats
        """);
        
        System.out.println("\nÉTAPE 5: Compilez et exécutez le projet");
        System.out.println("\nCompilation:");
        System.out.println("""
            # Compiler le module calculator
            javac -d calculator/target/classes calculator/src/main/java/module-info.java calculator/src/main/java/com/example/calculator/*.java calculator/src/main/java/com/example/calculator/impl/*.java
            
            # Compiler le module application
            javac --module-path calculator/target/classes -d application/target/classes application/src/main/java/module-info.java application/src/main/java/com/example/application/*.java
        """);
        
        System.out.println("\nExécution:");
        System.out.println("""
            # Exécuter l'application
            java --module-path calculator/target/classes:application/target/classes --module com.example.application/com.example.application.Main
        """);
        
        System.out.println("\nQUESTIONS DE RÉFLEXION:");
        System.out.println("1. Pourquoi n'exposons-nous pas le package 'impl' ?");
        System.out.println("2. Comment le pattern Factory nous aide-t-il à cacher l'implémentation ?");
        System.out.println("3. Quels sont les avantages du système de modules par rapport aux JAR traditionnels ?");
        System.out.println("4. Comment pourriez-vous étendre ce système pour avoir plusieurs implémentations de Calculator ?");
    }
}