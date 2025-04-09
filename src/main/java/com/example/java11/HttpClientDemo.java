package com.example.java11;

import java.net.http.*;
// import java.net.URI;
// import java.io.IOException;
// import java.util.concurrent.CompletableFuture;
// import java.util.List;
// import java.util.stream.Collectors;
// import java.util.stream.IntStream;

/**------------------------------------------------------------------------------------------------
 * *                                           Vous devez obtenir ce résultat : 
 * Requête synchrone :
 * Statut : 200
 * Corps : {
 *   "userId": 1,
 *   "id": 1,
 *   "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
 *   "body": "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"
 * }
 * 
 * Requête asynchrone :
 * Statut : 200
 * Corps : {
 *   "userId": 1,
 *   "id": 1,
 *   "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
 *   "body": "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"
 * }
 * 
 * Requêtes en parallèle :
 * Post /posts/1 - Statut : 200
 * Corps : {
 *   "userId": 1,
 *   "id": 1,
 *   "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
 *   "body": "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"
 * }
 * 
 * Post /posts/2 - Statut : 200
 * Corps : {
 *   "userId": 1,
 *   "id": 2,
 *   "title": "qui est esse",
 *   "body": "est rerum tempore vitae\nsequi sint nihil reprehenderit dolor beatae ea dolores neque\nfugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis\nqui aperiam non debitis possimus qui neque nisi nulla"
 * }
 * 
 * Post /posts/3 - Statut : 200
 * Corps : {
 *   "userId": 1,
 *   "id": 3,
 *   "title": "ea molestias quasi exercitationem repellat qui ipsa sit aut",
 *   "body": "et iusto sed quo iure\nvoluptatem occaecati omnis eligendi aut ad\nvoluptatem doloribus vel accusantium quis pariatur\nmolestiae porro eius odio et labore et velit aut"
 * }
 *   
 *   
 *
 *------------------------------------------------------------------------------------------------**/

public class HttpClientDemo {

    public static void main(String[] args) throws Exception {
        System.out.println("Travaillez dans le fichier src/main/java/com/example/java11/HttpClientDemo.java");

        // Créez un client HTTP
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .build();

        // TODO: Créez une requête GET vers "https://jsonplaceholder.typicode.com/posts/1"
        // TODO: Envoyez la requête de manière synchrone et affichez le résultat
        // TODO: Envoyez la même requête de manière asynchrone
        
        // Bonus: Envoyez plusieurs requêtes en parallèle et attendez que toutes soient terminées (en récupérant dynamiquement différents id de posts dans l'url : posts/1, posts/2, posts/3 par exemple)
        //indices : utiliser CompletableFuture.allOf, join()
    }
}
//java.util.concurrent