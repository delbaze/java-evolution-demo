package com.example.java9;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Exercice sur les améliorations de l'API Optional dans Java 9
 * 
 * Java 9 a introduit trois nouvelles méthodes très utiles pour Optional:
 * - ifPresentOrElse(Consumer, Runnable) : permet d'exécuter une action si la valeur est présente, sinon une autre action
 * - or(Supplier) : permet de fournir un Optional alternatif si l'Optional est vide
 * - stream() : convertit un Optional en Stream de 0 ou 1 élément
 */
public class OptionalEnhancementsDemo {
    public static void main(String[] args) {
        System.out.println("=== Exercice sur les améliorations d'Optional (Java 9) ===\n");
        
        // PARTIE 1: ifPresentOrElse
        System.out.println("=== Partie 1: ifPresentOrElse ===");
        
        Optional<String> optPresent = Optional.of("Bonjour le monde");
        Optional<String> optEmpty = Optional.empty();
        
        // Dans Java 8, il fallait faire:
        if (optPresent.isPresent()) {
            System.out.println("Java 8 (present): " + optPresent.get());
        } else {
            System.out.println("Java 8 (present): Pas de valeur");
        }
        
        if (optEmpty.isPresent()) {
            System.out.println("Java 8 (empty): " + optEmpty.get());
        } else {
            System.out.println("Java 8 (empty): Pas de valeur");
        }
        
        // TODO 1: Utilisez ifPresentOrElse pour optPresent pour afficher la valeur ou "Pas de valeur"
        
        
        // TODO 2: Utilisez ifPresentOrElse pour optEmpty pour afficher la valeur ou "Pas de valeur"
        
        
        // PARTIE 2: or (fournir un Optional alternatif)
        System.out.println("\n=== Partie 2: or ===");
        
        // Dans Java 8, il fallait faire:
        Optional<String> resultJava8 = optEmpty.isPresent() ? optEmpty : Optional.of("Valeur alternative");
        System.out.println("Java 8: " + resultJava8.get());
        
        // TODO 3: Utilisez la méthode or pour optEmpty pour fournir "Valeur alternative" si vide
        
        
        // TODO 4: Utilisez la méthode or pour optPresent et montrez qu'elle garde sa valeur originale
        
        
        // PARTIE 5: stream (convertir un Optional en Stream de 0 ou 1 élément)
        System.out.println("\n=== Partie 3: stream ===");
        
        // TODO 5: Convertissez optPresent en Stream et comptez les éléments
        
        
        // TODO 6: Convertissez optEmpty en Stream et comptez les éléments
        
        
        // TODO 7: Utilisez stream pour filtrer une liste d'Optionals et ne garder que les valeurs présentes
        List<Optional<String>> optionals = List.of(
            Optional.of("Premier"),
            Optional.empty(),
            Optional.of("Deuxième"),
            Optional.empty(),
            Optional.of("Troisième")
        );
        
        // En Java 8, il fallait faire:
        List<String> valuesJava8 = optionals.stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
        
        System.out.println("Java 8 - valeurs filtrées: " + valuesJava8);
        
        // TODO 8: Utilisez la méthode stream et flatMap pour simplifier le filtrage
        
        
        // BONUS: Combinez les 3 méthodes
        System.out.println("\n=== BONUS: Combinaison des méthodes ===");
        
        Optional<User> user = getUser("admin"); // Retourne un utilisateur
        Optional<User> guest = getUser("guest"); // Retourne empty
        
        // TODO 9: Pour user, utilisez les 3 méthodes ensemble pour:
        // 1. Extraire l'email s'il existe (voir la méthode getEmail de User)
        // 2. Utiliser "invité@example.com" comme alternative si pas d'email
        // 3. Afficher l'email ou "Adresse introuvable" si aucun email n'est disponible
        
        
        // TODO 10: Répétez l'opération pour guest
        
    }
    
    // Classe utilisateur pour l'exemple
    static class User {
        private final String username;
        private final String email;
        
        User(String username, String email) {
            this.username = username;
            this.email = email;
        }
        
        public String getUsername() {
            return username;
        }
        
        // Retourne l'email sous forme d'Optional car il peut être null
        public Optional<String> getEmail() {
            return Optional.ofNullable(email);
        }
    }
    
    // Méthode qui simule la récupération d'un utilisateur
    static Optional<User> getUser(String username) {
        if ("admin".equals(username)) {
            return Optional.of(new User("admin", "admin@example.com"));
        } else {
            return Optional.empty();
        }
    }
}