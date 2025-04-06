package com.example.java12;

public class SwitchDemo {
    public static void main(String[] args) {

        //AVANT JAVA 12
        String day = "MONDAY";
        String result;
        
        switch (day) {
            case "MONDAY":
                result = "Début de semaine";
                break;
            case "FRIDAY":
                result = "Fin de semaine";
                break;
            default:
                result = "Milieu de semaine";
                break;
        }
        
        System.out.println(result); // Début de semaine
    }
}
