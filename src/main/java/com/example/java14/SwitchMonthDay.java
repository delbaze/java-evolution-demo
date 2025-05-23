package com.example.java14;

/**------------------------------------------------------------------------------------------------
 **                                         Vous devez obtenir
 * Démo Java 14 - Switch avec Java 14
 * Mois : JAN - Jours : 31
 * Mois : FEB - Jours : 29
 * Mois : MAR - Jours : 31
 * Mois : APR - Jours : 30
 * Mois : MAY - Jours : 31
 * Mois : JUN - Jours : 30
 * Mois : JUL - Jours : 31
 * Mois : AUG - Jours : 31
 * Mois : SEP - Jours : 30
 * Mois : OCT - Jours : 31
 * Mois : NOV - Jours : 30
 * Mois : DEC - Jours : 31
 *------------------------------------------------------------------------------------------------**/
public class SwitchMonthDay {
    public static void main(String[] args) {
        System.out.println("Travaillez dans le fichier src/main/java/com/example/java14/SwitchMonthDay.java");

        boolean isLeapYear = true; // Année bissextile pour tester février
        
        // TODO 1 : Créez un tableau de String contenant les abréviations des 12 mois
        // Exemple : "JAN", "FEB", "MAR", etc.
        String[] months = null; // Remplacez ceci
        
        // TODO 2 : Parcourez le tableau avec une boucle for et pour chaque mois :
        // - Utilisez une Switch Expression pour déterminer le nombre de jours
        // - Gérez février avec un bloc yield tenant compte de isLeapYear (28 ou 29 jours)
        // - Les mois de 31 jours : JAN, MAR, MAY, JUL, AUG, OCT, DEC
        // - Les mois de 30 jours : APR, JUN, SEP, NOV
        // - Lancez une exception pour un mois invalide
        // - Stockez le résultat dans une variable "days"
        
        // TODO 3 : Affichez pour chaque mois une ligne au format :
        // "Mois : [nom] - Jours : [nombre]"
        
        // Indice : Voici un début pour le switch (à intégrer dans la boucle) :
        /*
        int days = switch (month) {
            case "JAN" -> 31;
            default -> 0; // À compléter
        };
        */
    }
}
