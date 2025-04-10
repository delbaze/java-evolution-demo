package com.example.java11;

import java.net.URI;
import java.net.http.*;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
// import java.net.URI;
// import java.io.IOException;
// import java.util.concurrent.CompletableFuture;
// import java.util.List;
// import java.util.stream.Collectors;
// import java.util.stream.IntStream;

/**
 * ------------------------------------------------------------------------------------------------
 * * Vous devez obtenir ce résultat : Requête synchrone : Statut : 200 Corps : {
 * "userId": 1, "id": 1, "title": "sunt aut facere repellat provident occaecati
 * excepturi optio reprehenderit", "body": "quia et suscipit\nsuscipit
 * recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas
 * totam\nnostrum rerum est autem sunt rem eveniet architecto" }
 *
 * Requête asynchrone : Statut : 200 Corps : { "userId": 1, "id": 1, "title":
 * "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
 * "body": "quia et suscipit\nsuscipit recusandae consequuntur expedita et
 * cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt
 * rem eveniet architecto" }
 *
 * Requêtes en parallèle : Post /posts/1 - Statut : 200 Corps : { "userId": 1,
 * "id": 1, "title": "sunt aut facere repellat provident occaecati excepturi
 * optio reprehenderit", "body": "quia et suscipit\nsuscipit recusandae
 * consequuntur expedita et cum\nreprehenderit molestiae ut ut quas
 * totam\nnostrum rerum est autem sunt rem eveniet architecto" }
 *
 * Post /posts/2 - Statut : 200 Corps : { "userId": 1, "id": 2, "title": "qui
 * est esse", "body": "est rerum tempore vitae\nsequi sint nihil reprehenderit
 * dolor beatae ea dolores neque\nfugiat blanditiis voluptate porro vel nihil
 * molestiae ut reiciendis\nqui aperiam non debitis possimus qui neque nisi
 * nulla" }
 *
 * Post /posts/3 - Statut : 200 Corps : { "userId": 1, "id": 3, "title": "ea
 * molestias quasi exercitationem repellat qui ipsa sit aut", "body": "et iusto
 * sed quo iure\nvoluptatem occaecati omnis eligendi aut ad\nvoluptatem
 * doloribus vel accusantium quis pariatur\nmolestiae porro eius odio et labore
 * et velit aut" }
 *
 *
 *
 * ------------------------------------------------------------------------------------------------*
 */
public class HttpClientDemo {

    public static void main(String[] args) throws Exception {
        System.out.println("Travaillez dans le fichier src/main/java/com/example/java11/HttpClientDemo.java");

        // Créez un client HTTP
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2) //Utilise HTTP/2 si disponible
                .build();

        // TODO: Créez une requête GET vers "https://jsonplaceholder.typicode.com/posts/1"
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/posts/1"))
                .GET()
                .build();

        // TODO: Envoyez la requête de manière synchrone et affichez le résultat
        System.out.println("Requête synchrone : ");
        HttpResponse<String> syncResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("JE SUIS APRES LA REQUETE");
        System.out.println("Statut: " + syncResponse.statusCode());
        System.out.println("Corps: " + syncResponse.body());

        System.out.println();
        // TODO: Envoyez la même requête de manière asynchrone

        System.out.println("Requête asynchrone : ");

        CompletableFuture<HttpResponse<String>> asyncResponse = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
        asyncResponse.thenAccept(response -> {
            System.out.println("Statut : " + response.statusCode());
            System.out.println("Corps : " + response.body());
        }).join();
        System.out.println("Coucou");

        System.out.println();

        ///
        // Bonus: Envoyez plusieurs requêtes en parallèle et attendez que toutes soient terminées (en récupérant dynamiquement différents id de posts dans l'url : posts/1, posts/2, posts/3 par exemple)
                //indices : utiliser CompletableFuture.allOf, join() 
                // send et sendAsync
                // attention, le join() transforme une opération asynchrone en une opération synchrone au moment
                //où vous l'appelez
                //thenCompose()
  
        System.out.println("Requêtes en parallèle : ");
        List<CompletableFuture<HttpResponse<String>>> futures = IntStream.rangeClosed(1, 3)
                .mapToObj(i -> {
                    HttpRequest req = HttpRequest.newBuilder()
                            .uri(URI.create("https://jsonplaceholder.typicode.com/posts/" + i))
                            .GET()
                            .build();
                    return client.sendAsync(req, HttpResponse.BodyHandlers.ofString());
                })
                .collect(Collectors.toList());

        // CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        // futures.forEach(future -> {
        //     HttpResponse<String> response = future.join();
        //     System.out.println("Post : " + response.uri().getPath() + " - Statut : " + response.statusCode());
        //     System.out.println("Corps : " + response.body());
        //     System.out.println();
        // });
        // CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
        // .thenRun(() -> { 
        //     String body1 = futures.get(0).getNow("Erreur par défaut");
        //     String body2 = futures.get(1).getNow("Erreur par défaut");
        //     System.out.println("Résultat 1 : " + body1);
        //     System.out.println("Résultat 2 : " + body2);


        // }).exceptionally(throwable -> {
        //     System.err.println("Erreur : " + throwable.getMessage());
        //     return null;
        // });
        futures.forEach(future -> {
            HttpResponse<String> response = future.join();
            System.out.println("Post : " + response.uri().getPath() + " - Statut : " + response.statusCode());
            System.out.println("Corps : " + response.body());
            System.out.println();
        });
    }
}
//java.util.concurrent
