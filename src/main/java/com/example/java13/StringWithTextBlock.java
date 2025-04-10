package com.example.java13;

public class StringWithTextBlock {

    public static void main(String[] args) {
        //AVANT JAVA 13
        String html2 = "<html>\n"
                + "      <body>\n"
                + "           <h1>Hello, World!</h1>\n"
                + "       </body>\n"
                + "</html>";

        String html = """
                      <html>
                          <body>
                              <h1>Hello, World!</h1>
                          </body>
                      </html>
                      """;
        System.out.println(html);

        String text = """
                            Line 1 with a quote: \"coucou \"
                            Line 2 with a tab \tFin

                      """;

        System.out.println(text);
    }
}
