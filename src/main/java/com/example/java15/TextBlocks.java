package com.example.java15;

/**
 * Exercice : Text Blocks (Java 13-15)
 *
 * Objectif : Refactoriser des chaînes multiligne en utilisant les text blocks
 * pour améliorer la lisibilité.
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
        String html = """
                        <html>
                            <body>
                                <h1>Hello, Java!</h1>
                                <p>Text blocks make multiline strings easier.</p>
                            </body>
                        </html>
                     """;

        System.out.println("HTML Output:");
        System.out.println(html);
        System.out.println("------------------");
    }

    static void executeSQL() {
        String query = """
              SELECT e.employee_id,
                      e.first_name,
                      e.last_name,
                      d.department_name
               FROM employees e
               JOIN departments d
                 ON e.department_id = d.department_id
               WHERE d.location_id IN (1000, 1700)
               ORDER BY e.last_name ASC
               """;

        System.out.println("SQL Query:");
        System.out.println(query);
        System.out.println("------------------");
    }

    static void processJSON() {
        String json = """
                    {
                        "name": "John Doe",
                        "age": 30,
                        "address": {
                            "street": "123 Main St",
                            "city": "Anytown",
                            "zipCode": "12345"
                        },
                        "phoneNumbers": [
                            "555-1234",
                            "555-5678"
                        ]
                    }
                    """;

        System.out.println("JSON Data:");
        System.out.println(json);
        System.out.println("------------------");
    }

    static void displayUserInfo(String username, int score) {
        // String message = "User Information:\n"
        //         + "Username: " + username + "\n"
        //         + "Score: " + score + "\n"
        //         + "Status: " + (score >= 80 ? "Excellent" : "Good");

        String message2 = """
                    User Information:
                    Username: %s
                    Score: %d
                    Status: %s
                """.formatted(username, score, score >= 80 ? "Excellent" : "Good");

        System.out.println(message2);
        System.out.println("------------------");
    }
}
