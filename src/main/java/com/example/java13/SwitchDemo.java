package com.example.java13;

import java.util.Map;
import java.util.stream.Stream;

public class SwitchDemo {

    //switch expressions
    public static void main(String[] args) {
        String day = "WEDNESDAY"; // Vous pouvez changer cette valeur pour tester différents cas

        String result = switch (day) {
            case "MONDAY" -> {
                int heuresTravaillees = 8;
                yield "Début de semaine avec " + heuresTravaillees + " heures de travail";
            }
            case "FRIDAY" ->
                "Fin de semaine, enfin le repos !";
            case "WEDNESDAY" -> {
                // Cas complexe avec plusieurs instructions
                String messageBase = "Milieu de semaine";
                int jourNumero = 3; // Mercredi est le 3e jour
                boolean estFatigue = jourNumero > 2; // Condition pour ajouter un commentaire

                if (estFatigue) {
                    System.out.println("Déjà mercredi, la fatigue se fait sentir...");
                    yield messageBase + " (on est mercredi, courage pour la suite !)";
                } else {
                    yield messageBase + " (on est mercredi, encore frais !)";
                }
            }
            case "SATURDAY", "SUNDAY" -> {
                // Gestion d'un week-end avec calcul
                double pourcentageSemaine = 100.0 * (day.equals("SATURDAY") ? 6 : 7) / 7;
                yield "Week-end ! " + String.format("%.1f%% de la semaine est terminé", pourcentageSemaine);
            }
            default -> {
                // Cas par défaut avec une vérification
                if (day.isEmpty()) {
                    yield "Erreur : jour non spécifié";
                } else {
                    yield "Jour inconnu : " + day;
                }
            }
        };

        String dayDemo = "MONDAY";
        String resultDemo = switch (dayDemo) {
            case "MONDAY" ->
                "Début de semaine";
            case "FRIDAY" ->
                "Fin de semaine";
            default ->
                "Milieu de semaine";
        };

        String dayDemo2 = "MONDAY";
        String resultDemo2 = Stream.of(
                Map.entry("MONDAY", "Début de semaine"),
                Map.entry("FRIDAY", "Fin de semaine")
        )
                .filter(entry -> entry.getKey().equals(dayDemo2))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElse("Milieu de semaine");
        System.out.println("Résultat2 : " + resultDemo2);
        
        System.out.println("Résultat : " + result);
    }
}
