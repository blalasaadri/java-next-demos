package com.github.blalasaadri.javaNextDemos.java13.textblocks;

public class TextBlocks {
    private static final String HTML_BOILERPLATE =
            """
            <html>
                <head>
                    <title>%s</title>
                </head>
                <body>
                    %s
                </body>
            </html>
            """;

    public static String toHtmlPage(String title, String body) {
        return String.format(HTML_BOILERPLATE, title, body);
    }
}
