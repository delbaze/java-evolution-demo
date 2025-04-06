package com.example.java13;

public class StringWithTextBlock{
    public static void main(String[] args) {
        String html = """
                      <html>
                          <body>
                              <h1>Hello, World!</h1>
                          </body>
                      </html>
                      """;
        System.out.println(html);
    }
}
