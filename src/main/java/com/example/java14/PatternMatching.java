package com.example.java14;

public class PatternMatching {
    public static void main(String[] args) {
        System.out.println("Allez voir le fichier src/main/java/com/example/java14/PatternMatching.java");

        Object obj = "Hello, Java!";
        
        if (obj instanceof String s) {
            System.out.println("Longueur de la chaîne : " + s.length());
        }
    }
}
