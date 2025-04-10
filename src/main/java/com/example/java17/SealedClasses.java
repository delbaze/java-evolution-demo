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
        
        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(4, 6);
        Shape triangle = new Triangle(3, 4);
        Shape equilateral = new EquilateralTriangle(5);
        
        Shape[] shapes = {circle, rectangle, triangle, equilateral};
        for (Shape shape : shapes) {
            System.out.printf("Class: %s, Area: %.2f%n", 
                shape.getClass().getSimpleName(), shape.area());
        }
    }
    
    static void testPatternMatching() {
        System.out.println("\n--- Pattern Matching with Sealed Classes ---");
        
        Shape[] shapes = {
            new Circle(3),
            new Rectangle(2, 5),
            new Triangle(6, 8),
            new EquilateralTriangle(4)
        };
        
        for (Shape shape : shapes) {
            if (shape instanceof Circle c) {
                System.out.println("Circle with radius " + c.radius + ", area: " + c.area());
            } else if (shape instanceof Rectangle r) {
                System.out.println("Rectangle " + r.width + "x" + r.height + ", area: " + r.area());
            } else if (shape instanceof EquilateralTriangle et) {
                System.out.println("Equilateral Triangle with side " + et.side + ", area: " + et.area());
            } else if (shape instanceof Triangle t) {
                System.out.println("Triangle base " + t.base + ", height " + t.height + ", area: " + t.area());
            }
        }
    }
    
    static void testPaymentMethods() {
        System.out.println("\n--- Payment Methods (Sealed Interface) ---");
        
        PaymentMethod[] payments = {
            new CreditCard("1234-5678-9012-3456", "12/25"),
            new BankTransfer("FR7612345678901234567890123", "BANK123"),
            new PayPal("user@example.com")
        };
        
        for (PaymentMethod payment : payments) {
            System.out.println("Processing " + payment + ": " + payment.processTransaction(100.0));
        }
    }
}

// Partie 1: Hiérarchie des formes géométriques
sealed abstract class Shape permits Circle, Rectangle, Triangle {
    abstract double area();
}

final class Circle extends Shape {
    final double radius;
    Circle(double radius) { this.radius = radius; }
    double area() { return Math.PI * radius * radius; }
}

final class Rectangle extends Shape {
    final double width, height;
    Rectangle(double width, double height) { this.width = width; this.height = height; }
    double area() { return width * height; }
}

non-sealed class Triangle extends Shape {
    final double base, height;
    Triangle(double base, double height) { this.base = base; this.height = height; }
    double area() { return 0.5 * base * height; }
}

class EquilateralTriangle extends Triangle {
    final double side;
    EquilateralTriangle(double side) { 
        super(side, side * Math.sqrt(3) / 2); // Hauteur d’un triangle équilatéral
        this.side = side; 
    }
}

// Partie 3: Hiérarchie des méthodes de paiement
sealed interface PaymentMethod permits CreditCard, BankTransfer, DigitalWallet {
    String processTransaction(double amount);
}

final record CreditCard(String cardNumber, String expiryDate) implements PaymentMethod {
    public String processTransaction(double amount) {
        return "Paid $" + amount + " with card " + cardNumber;
    }
}

final record BankTransfer(String iban, String bic) implements PaymentMethod {
    public String processTransaction(double amount) {
        return "Transferred $" + amount + " to IBAN " + iban;
    }
}

non-sealed interface DigitalWallet extends PaymentMethod {
}

final class PayPal implements DigitalWallet {
    private final String email;
    PayPal(String email) { this.email = email; }
    public String processTransaction(double amount) {
        return "Paid $" + amount + " via PayPal (" + email + ")";
    }
    public String toString() { return "PayPal[email=" + email + "]"; }
}
