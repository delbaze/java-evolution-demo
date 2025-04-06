package com.example.java14;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Exercice : Records (Java 14)
 * 
 * Objectif : Refactoriser des classes de données traditionnelles
 * en utilisant des records.
 */
public class Records {

    public static void main(String[] args) {
        System.out.println("Travaillez dans le fichier src/main/java/com/example/java14/Records.java");

        // Exercice 1: Utiliser la classe Person (convertir en record)
        testPersonClass();
        
        // Exercice 2: Utiliser la classe Product (convertir en record)
        testProductClass();
        
        // Exercice 3: Créer un record avec validations et méthodes
        testEmployeeRecord();
        
        // Exercice 4: Records imbriqués
        testNestedRecords();
    }
    
    static void testPersonClass() {
        System.out.println("\n=== Person Test ===");
        
        Person p1 = new Person("John Doe", "john@example.com", 30);
        Person p2 = new Person("John Doe", "john@example.com", 30);
        Person p3 = new Person("Jane Smith", "jane@example.com", 25);
        
        System.out.println("p1: " + p1);
        System.out.println("p1 equals p2: " + p1.equals(p2));
        System.out.println("p1 equals p3: " + p1.equals(p3));
    }
    
    static void testProductClass() {
        System.out.println("\n=== Product Test ===");
        
        Product p1 = new Product("Laptop", "Electronics", 1299.99);
        Product p2 = new Product("Smartphone", "Electronics", 699.99);
        
        System.out.println("p1: " + p1);
        System.out.println("p2: " + p2);
        
        // Simulation d'une opération de panier
        List<Product> cart = new ArrayList<>();
        cart.add(p1);
        cart.add(p2);
        
        double total = cart.stream()
                          .mapToDouble(Product::getPrice)
                          .sum();
        
        System.out.println("Total price: $" + total);
    }
    
    static void testEmployeeRecord() {
        System.out.println("\n=== Employee Test ===");
        
        // TODO: Remplacez cette classe par un record Employee
        //       Ajoutez une validation pour que le salaire soit > 0
        
        // Test avec valeurs valides
        try {
            // TODO: Créez une instance d'Employee avec id=1, name="Alice", salary=5000
            // TODO: Affichez les détails
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        // Test avec salaire négatif
        try {
            // TODO: Créez une instance d'Employee avec id=2, name="Bob", salary=-1000
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    static void testNestedRecords() {
        System.out.println("\n=== Nested Records Test ===");
        
        // TODO: Créez des records imbriqués Address et Customer
        // Address: street, city, zipCode
        // Customer: id, name, address
        
        // TODO: Créez un customer avec une adresse et affichez les détails
    }
}

// Classe 1: Traditionnelle à convertir en record
class Person {
    private final String name;
    private final String email;
    private final int age;
    
    public Person(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }
    
    public String getName() {
        return name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public int getAge() {
        return age;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && 
               Objects.equals(name, person.name) && 
               Objects.equals(email, person.email);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(name, email, age);
    }
    
    @Override
    public String toString() {
        return "Person{" +
               "name='" + name + '\'' +
               ", email='" + email + '\'' +
               ", age=" + age +
               '}';
    }
}

// Classe 2: Traditionnelle à convertir en record
class Product {
    private final String name;
    private final String category;
    private final double price;
    
    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }
    
    public String getName() {
        return name;
    }
    
    public String getCategory() {
        return category;
    }
    
    public double getPrice() {
        return price;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 && 
               Objects.equals(name, product.name) && 
               Objects.equals(category, product.category);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(name, category, price);
    }
    
    @Override
    public String toString() {
        return "Product{" +
               "name='" + name + '\'' +
               ", category='" + category + '\'' +
               ", price=" + price +
               '}';
    }
}