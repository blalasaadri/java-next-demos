package com.github.blalasaadri.javaNextDemos.java10;

public class App10 {
    public static void main(String[] args) {
        var app = new App10();

        var greeting = app.greet("World");

        System.out.println(greeting);

        app.advancedVar();
    }

    String greet(String name) {
        return "Hello, " + name + "!";
    }

    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //

    void advancedVar() {
        var fancyNewObject = new Object() {
            String fancyFunction() {
                return "Fancy!";
            }
        };

        System.out.println(fancyNewObject.fancyFunction());
    }
}
