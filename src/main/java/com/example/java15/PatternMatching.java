package com.example.java15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Exercice : Pattern Matching pour instanceof (Java 14-15)
 * 
 * Objectif : Simplifier le code qui utilise instanceof suivi de cast
 * en utilisant le pattern matching.
 */
public class PatternMatching {

    public static void main(String[] args) {
        System.out.println("Travaillez dans le fichier src/main/java/com/example/java15/PatternMatching.java");

        // Créons une liste d'objets de différents types
        List<Object> objects = new ArrayList<>();
        objects.add("Hello, Java 15!");
        objects.add(Integer.valueOf(42));
        objects.add(Double.valueOf(3.14));
        objects.add(new ArrayList<>(List.of("a", "b", "c")));
        objects.add(new HashMap<>(Map.of("key", "value")));
        
        // Exercice 1: Simplifier cette méthode avec pattern matching
        System.out.println("--- Without Pattern Matching ---");
        processObjectsOldWay(objects);
        
        // Exercice 2: Implémenter avec pattern matching
        System.out.println("--- With Pattern Matching ---");
        processObjectsNewWay(objects);
        
        // Exercice 3: Combiner pattern matching avec des conditions
        Shape[] shapes = {new Circle(5), new Rectangle(4, 6), new Circle(10)};
        System.out.println("--- Area Calculation ---");
        calculateAreas(shapes);
    }
    
    // Ancienne façon (avant Java 14)
    static void processObjectsOldWay(List<Object> objects) {
        for (Object obj : objects) {
            if (obj instanceof String) {
                String s = (String) obj;
                System.out.println("String of length " + s.length() + ": " + s);
            } else if (obj instanceof Integer) {
                Integer i = (Integer) obj;
                System.out.println("Integer with value: " + i);
            } else if (obj instanceof Double) {
                Double d = (Double) obj;
                System.out.println("Double with value: " + d);
            } else if (obj instanceof List) {
                List<?> list = (List<?>) obj;
                System.out.println("List with " + list.size() + " elements");
            } else if (obj instanceof Map) {
                Map<?, ?> map = (Map<?, ?>) obj;
                System.out.println("Map with " + map.size() + " entries");
            } else {
                System.out.println("Unknown type: " + obj.getClass().getName());
            }
        }
    }
    
    // TODO: Implémentez cette méthode avec pattern matching
    static void processObjectsNewWay(List<Object> objects) {
        // Votre code ici
    }
    
    // Exercice 3: Utilisez pattern matching avec des conditions
    static void calculateAreas(Shape[] shapes) {
        for (Object shape : shapes) {
            // Ancienne façon:
            if (shape instanceof Circle) {
                Circle c = (Circle) shape;
                if (c.radius > 5) {
                    System.out.println("Large circle with area: " + c.calculateArea());
                } else {
                    System.out.println("Small circle with area: " + c.calculateArea());
                }
            } else if (shape instanceof Rectangle) {
                Rectangle r = (Rectangle) shape;
                if (r.width > r.height) {
                    System.out.println("Wide rectangle with area: " + r.calculateArea());
                } else {
                    System.out.println("Tall rectangle with area: " + r.calculateArea());
                }
            }
            
            // TODO: Refactorisez avec pattern matching
        }
    }
}

// Classes pour l'exercice 3
abstract class Shape {
    abstract double calculateArea();
}

class Circle extends Shape {
    double radius;
    
    Circle(double radius) {
        this.radius = radius;
    }
    
    @Override
    double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    double width;
    double height;
    
    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    
    @Override
    double calculateArea() {
        return width * height;
    }
}