package com.example.java12;

public class SwitchDemo2 {

    public static void main(String[] args) {
        String day = "MONDAY";

        String result = switch (day) {
            case "MONDAY" ->
                "Début de semaine";
            case "FRIDAY" ->
                "Fin de semaine";
            default ->
                "Milieu de semaine";
        };

        System.out.println(result); // Début de semaine
    }
}
