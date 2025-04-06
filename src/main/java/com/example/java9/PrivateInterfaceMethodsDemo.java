package com.example.java9;

/**
 * Exercice : Méthodes privées dans les interfaces (Java 9)
 * 
 * Avant Java 9, il n'était pas possible de factoriser le code commun entre
 * plusieurs méthodes par défaut d'une interface.
 * 
 * Complétez les TODO dans ce fichier pour utiliser les méthodes privées
 * d'interface introduites dans Java 9.
 */
public class PrivateInterfaceMethodsDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Démonstration des méthodes privées dans les interfaces (Java 9) ===\n");
        
        // Création d'un logger
        Logger consoleLogger = new ConsoleLogger();
        
        // Test des différentes méthodes
        consoleLogger.logInfo("Application démarrée");
        consoleLogger.logWarning("Mémoire faible");
        consoleLogger.logError("Connexion à la base de données perdue");
        
        // Décommentez après avoir complété l'exercice
        // consoleLogger.logDebug("Initialisation du cache");
    }
    
    /**
     * Interface définissant un logger avec méthodes par défaut.
     * 
     * Exercice: Refactorisez ce code en utilisant une méthode privée pour
     * éviter la duplication de code.
     */
    interface Logger {
        
        // Ces 3 méthodes contiennent du code dupliqué
        default void logInfo(String message) {
            String formattedMessage = "[INFO] " + System.currentTimeMillis() + " - " + message;
            System.out.println(formattedMessage);
        }
        
        default void logWarning(String message) {
            String formattedMessage = "[WARNING] " + System.currentTimeMillis() + " - " + message;
            System.out.println(formattedMessage);
        }
        
        default void logError(String message) {
            String formattedMessage = "[ERROR] " + System.currentTimeMillis() + " - " + message;
            System.out.println(formattedMessage);
        }
        
        // TODO 1: Ajoutez une méthode par défaut logDebug(String message)
        
        // TODO 2: Ajoutez une méthode privée log(String level, String message)
        // pour éviter la duplication de code
        
        // TODO 3: Ajoutez une méthode privée statique formatTime() 
        // qui retourne l'heure actuelle formatée (HH:mm:ss)
    }
    
    /**
     * Implémentation simple d'un logger
     */
    static class ConsoleLogger implements Logger {
        // Aucune implémentation nécessaire, tout est hérité de l'interface
    }
    
    // TODO 4: Créez une nouvelle classe FileLogger qui implémente Logger
    // et remplace la méthode logError pour afficher un message différent
}