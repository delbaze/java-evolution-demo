package com.example.java14;

public class StringWithTextBlock {

    public static void main(String[] args) {
        String json = """
            {\
                "name": "John",\
                "age": 30,\
                "city": "Paris"\s
            }
            """;
        System.out.println(json);
    }
}
