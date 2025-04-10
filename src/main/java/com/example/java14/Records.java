package com.example.java14;

import java.util.ArrayList;
import java.util.List;

/**
 * Exercice : Records (Java 14)
 *
 * Objectif : Refactoriser des classes de données traditionnelles en utilisant
 * des records.
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
                .mapToDouble(Product::price)
                .sum();

        System.out.println("Total price: $" + total);
    }

    static void testEmployeeRecord() {
        System.out.println("\n=== Employee Test ===");

        try {
            Employee emp1 = new Employee(1, "Alice", 5000);
            System.out.println(emp1.name());
            System.out.println(emp1.salary());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void testNestedRecords() {
        System.out.println("\n=== Nested Records Test ===");

        // Address: street, city, zipCode
        // Customer: id, name, address
        Address addr = new Address("123 toto street", "Town", "12346");
        Customer cust = new Customer(1, "John", addr);
        System.out.println(cust.address().city());
    }
}

record Person(String name, String email, int age) {

}

record Product(String name, String category, double price) {

}

record Employee(int id, String name, double salary) {
    public Employee   {
        if (salary <= 0) {
            throw new IllegalArgumentException("Salary must be positive");
        }
    }
}

record Address(String street, String city, String zipCode) {

}

record Customer(int id, String name, Address address) {

}
