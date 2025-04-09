package com.example.java11;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Demo {

    public static void main(String[] args) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://example.com"))
                .build();

        try {
            // HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            // System.out.println(response.body()); // SYNCHRONE
            var response = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .thenApply(HttpResponse::body)
                    .thenAccept(System.out::println)
                    .exceptionally(throwable -> {
                        System.err.println("Erreur: " + throwable.getMessage());
                        return null;
                    });
            // System.out.println(response.body()); // ASYNCHRONE
        } catch (Exception e) {
            e.printStackTrace();
        }
        //IOException 
        //InterrupedException
        // statusCode()
    }
}
