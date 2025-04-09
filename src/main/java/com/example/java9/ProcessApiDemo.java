package com.example.java9;

import java.time.Instant;

/**
 * Exercice simplifié sur la Process API de Java 9
 */
public class ProcessApiDemo {

    public static void main(String[] args) {
        System.out.println("=== Exercice sur la Process API (Java 9) ===\n");

        // ProcessBuilder pb = new ProcessBuilder("notepad.exe");
        // Process process = pb.start();
        // ProcessHandle handle = process.toHandle();
        // PARTIE 1: Information sur le processus courant
        // TODO 1: Obtenez le handle du processus courant et affichez son PID
        ProcessHandle current = ProcessHandle.current();
        System.out.println("PID du processus en cours: " + current.pid());

        // TODO 2: Affichez des informations sur le processus courant (commande, utilisateur, instant de démarrage), utilisez orElse (Optional) pour gérer les cas où les informations ne sont pas disponibles
        // PARTIE 2: Exploration des processus système
        ProcessHandle.Info info = current.info();
        System.out.println("\nInformations sur le processus courant: ");
        System.out.println("Commande: " + info.command().orElse("Inconnue"));
        System.out.println("Utilisateur: " + info.user().orElse("Inconnu"));
        System.out.println("Démarré à: " + info.startInstant().orElse(Instant.EPOCH));

        System.out.println("\n=== Exploration des processus système ===");

        // TODO 3: Comptez et affichez le nombre total de processus en cours d'exécution
        long processCount = ProcessHandle.allProcesses().count();
        System.out.println("Nombre de processus en cours d'exécution: " + processCount);
        // TODO 4: Affichez les 5 premiers processus du système (leur PID uniquement)
        ProcessHandle.allProcesses().limit(5).forEach(p -> System.out.print("-PID: " + p.pid()));

        // TODO 5: Affichez tous les processus enfants du processus courant
        long childCount = current.children().count();
        if (childCount == 0) {
            System.out.println("Aucun processus enfant trouvé");
        } else {
            current.children().forEach(child -> System.out.println("- Enfant PID: " + child.pid()));
        }
        // TODO 6: BONUS : Affichez tous les processus dont la commande contient "java" en utilisant ProcessHandle.allProcesses et filter()

        ProcessHandle.allProcesses()
            .filter(p -> p.info().command().orElse("").contains("java"))
            .forEach(p -> System.out.println("PID Java: " + p.pid()));


        
        // ProcessBuilder pb = new ProcessBuilder("printenv", "MY_VAR"); // set
        // pb.environment().put("MY_VAR", "Hello");
    }
}
