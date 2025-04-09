package com.example.java9;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

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
        consoleLogger.logDebug("Initialisation du cache");

        Logger fileLogger = new FileLogger();
        fileLogger.logInfo("Configuration chargée");
        fileLogger.logError("Erreur d'écriture disque");
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
            log("INFO", message);

        }

        default void logWarning(String message) {
            log("WARNING", message);
        }

        default void logError(String message) {
            log("ERROR", message);
        }

        default void logDebug(String message) {
            log("DEBUG", message);
        }

        private void log(String level, String message) {
            String time = formatTime();
            String formattedMessage = "[" + level + "] " + time + " - " + message;
            System.out.println(formattedMessage);
        }

        private static String formatTime() {
            return LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));

        }

        //FAIT  TODO 1: Ajoutez une méthode par défaut logDebug(String message)
        //FAIT TODO 2: Ajoutez une méthode privée log(String level, String message)
        // pour éviter la duplication de code
        //FAIT TODO 3: Ajoutez une méthode privée statique formatTime() 
        // qui retourne l'heure actuelle formatée (HH:mm:ss)
    }

    /**
     * Implémentation simple d'un logger
     */
    static class ConsoleLogger implements Logger {
        // Aucune implémentation nécessaire, tout est hérité de l'interface
    }

    static class FileLogger implements Logger {

        @Override()
        public void logError(String message) {
            System.out.println("Fichier: Erreur critique - " + message);
        }
    }

    //FAIT TODO 4: Créez une nouvelle classe FileLogger qui implémente Logger
    // et remplace la méthode logError pour afficher un message différent
}
