package com.example.java15;

/**
 * Exercice : Text Blocks (Java 13-15)
 * 
 * Objectif : Refactoriser des chaînes multiligne en utilisant
 * les text blocks pour améliorer la lisibilité.
 */
public class TextBlocks {

    public static void main(String[] args) {

        System.out.println("Travaillez dans le fichier src/main/java/com/example/java15/TextBlocks.java");


        // Exercice 1: Convertir cette chaîne HTML en text block
        useHTML();
        
        // Exercice 2: Convertir cette requête SQL en text block
        executeSQL();
        
        // Exercice 3: Convertir ce JSON en text block et utiliser l'indentation
        processJSON();
        
        // Exercice 4: Bonus - Utiliser des expressions dans un text block
        String username = "Alice";
        int score = 95;
        displayUserInfo(username, score);
    }
    
    static void useHTML() {
        String html = "<html>\n" +
                     "    <body>\n" +
                     "        <h1>Hello, Java!</h1>\n" +
                     "        <p>Text blocks make multiline strings easier.</p>\n" +
                     "    </body>\n" +
                     "</html>";
        
        System.out.println("HTML Output:");
        System.out.println(html);
        System.out.println("------------------");
    }
    
    static void executeSQL() {
        String query = "SELECT e.employee_id,\n" +
                      "       e.first_name,\n" +
                      "       e.last_name,\n" +
                      "       d.department_name\n" +
                      "FROM employees e\n" +
                      "JOIN departments d\n" +
                      "  ON e.department_id = d.department_id\n" +
                      "WHERE d.location_id IN (1000, 1700)\n" +
                      "ORDER BY e.last_name ASC";
        
        System.out.println("SQL Query:");
        System.out.println(query);
        System.out.println("------------------");
    }
    
    static void processJSON() {
        String json = "{\n" +
                     "    \"name\": \"John Doe\",\n" +
                     "    \"age\": 30,\n" +
                     "    \"address\": {\n" +
                     "        \"street\": \"123 Main St\",\n" +
                     "        \"city\": \"Anytown\",\n" +
                     "        \"zipCode\": \"12345\"\n" +
                     "    },\n" +
                     "    \"phoneNumbers\": [\n" +
                     "        \"555-1234\",\n" +
                     "        \"555-5678\"\n" +
                     "    ]\n" +
                     "}";
        
        System.out.println("JSON Data:");
        System.out.println(json);
        System.out.println("------------------");
    }
    
    static void displayUserInfo(String username, int score) {
        String message = "User Information:\n" +
                         "Username: " + username + "\n" +
                         "Score: " + score + "\n" +
                         "Status: " + (score >= 80 ? "Excellent" : "Good");
        
        System.out.println(message);
        System.out.println("------------------");
    }
}