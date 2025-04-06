package com.example.java17;

/**
 * Exercice : Sealed Classes (Java 17)
 * 
 * Objectif : Comprendre et utiliser les classes scellées pour
 * restreindre la hiérarchie d'héritage.
 */
public class SealedClasses {

    public static void main(String[] args) {
        System.out.println("Travaillez dans le fichier src/main/java/com/example/java17/SealedClasses.java");

        // Partie 1: Utilisation des classes scellées
        testShapeHierarchy();
        
        // Partie 2: Combinaison avec pattern matching
        testPatternMatching();
        
        // Partie 3: Interfaces scellées
        testPaymentMethods();
    }
    
    static void testShapeHierarchy() {
        System.out.println("\n--- Shape Hierarchy ---");
        
        // TO DO: Créez une instance de chaque sous-classe de Shape
        // et affichez leur aire
        
        // Pour chaque forme, affichez aussi sa classe
    }
    
    static void testPatternMatching() {
        System.out.println("\n--- Pattern Matching with Sealed Classes ---");
        
        // TO DO: Créez un tableau de formes diverses
        // et utilisez instanceof pattern matching pour afficher des informations spécifiques
        // à chaque type
    }
    
    static void testPaymentMethods() {
        System.out.println("\n--- Payment Methods (Sealed Interface) ---");
        
        // TO DO: Créez différentes méthodes de paiement
        // et traitez une transaction avec chacune
    }
}

// TO DO:
// 1. Créez une hiérarchie de classes scellées pour les formes géométriques:
//    - Shape (sealed class)
//    - Circle (final)
//    - Rectangle (final)
//    - Triangle (non-sealed)
//    - EquilateralTriangle (extends Triangle)
//
// 2. Chaque forme doit avoir une méthode area() qui calcule sa surface
//
// 3. Créez une hiérarchie d'interfaces scellées pour les méthodes de paiement:
//    - PaymentMethod (sealed interface)
//    - CreditCard (final record)
//    - BankTransfer (final record)
//    - DigitalWallet (non-sealed interface)
//    - PayPal (implements DigitalWallet)