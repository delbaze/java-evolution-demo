package com.example.java11;

/**-----------------------
 * *       Vous devez obtenir ce résultat : 
 *
 * Entrée : "Hello" -> Valide
 * Entrée : "" -> Invalide (vide ou espaces)
 * Entrée : "   " -> Invalide (vide ou espaces)
 * Entrée : null -> Invalide (null)
 * 
 * Exercice 2 - Analyse du journal utilisateur :
 * Nombre de lignes : 3
 * Dates extraites :
 * 2023-01-01
 * 2023-01-02
 * 2023-01-03
 * 
 * Exercice 3 - Formatage de la citation :
 ***** La vie est belle *****
 *  
 *  
 *------------------------**/

public class StringMethodsDemo {
    public static void main(String[] args) {
        System.out.println("Travaillez dans le fichier src/main/java/com/example/java11/StringMethodsDemo.java");
        // Exercice 1: Utilisez isBlank pour valider l'entrée utilisateur
        String[] inputs = {"Hello", "", "   ", null};
        
        // TODO: Écrivez une méthode qui vérifie si chaque entrée est valide ou vide
        
        // Exercice 2: Utilisez lines() pour compter et extraire les lignes
        String userLog = "2023-01-01: Login\n2023-01-02: Update profile\n2023-01-03: Logout";
        
        // TODO: Obtenez le nombre de lignes et extrayez la date de chaque ligne
        
        // Exercice 3: Utilisez strip et repeat pour formater un texte
        String quote = "  La vie est belle  ";
        
        // TODO: Enlevez les espaces et encadrez la citation avec des étoiles
    }
}
