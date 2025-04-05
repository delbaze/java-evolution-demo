package com.example.java10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Exercice sur var dans Java 10 
 * Objectif : Refactorisez le code existant pour
 * utiliser var et comprendre quand son utilisation est appropriée
 */
public class VarDemo {
    public static void main(String[] args) {
        System.out.println("Démarrage de l'exemple var de Java 10");
        
        VarDemo demo = new VarDemo();
        demo.processInventory();
    }
    
    public void processInventory() {
        List<Product> products = getProducts();
        Map<String, List<Product>> productsByCategory = new HashMap<>();
        
        for (Product product : products) {
            String category = product.getCategory();
            if (!productsByCategory.containsKey(category)) {
                productsByCategory.put(category, new ArrayList<>());
            }
            productsByCategory.get(category).add(product);
        }
        
        for (Map.Entry<String, List<Product>> entry : productsByCategory.entrySet()) {
            String category = entry.getKey();
            List<Product> categoryProducts = entry.getValue();
            double totalValue = 0.0;
            
            for (Product product : categoryProducts) {
                totalValue += product.getPrice();
            }
            
            System.out.println("Category: " + category + ", Total value: " + totalValue);
        }
    }
    
    private List<Product> getProducts() {
        // Création de produits pour l'exemple
        List<Product> products = new ArrayList<>();
        
        Product product1 = new Product();
        product1.setName("Laptop");
        product1.setCategory("Electronics");
        product1.setPrice(1200.0);
        products.add(product1);
        
        Product product2 = new Product();
        product2.setName("Smartphone");
        product2.setCategory("Electronics");
        product2.setPrice(800.0);
        products.add(product2);
        
        Product product3 = new Product();
        product3.setName("Table");
        product3.setCategory("Furniture");
        product3.setPrice(350.0);
        products.add(product3);
        
        Product product4 = new Product();
        product4.setName("Chair");
        product4.setCategory("Furniture");
        product4.setPrice(150.0);
        products.add(product4);
        
        return products;
    }
}

class Product {
    private String name;
    private String category;
    private double price;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getCategory() {
        return category;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
}