package com.github.blalasaadri.javaNextDemos.java10;

public class App10 {
  public static void main(String[] args) {
    var app = new App10();

    var greeting = app.greet("World");

    System.out.println(greeting);
  }

  String greet(String name) {
    return "Hello, " + name + "!";
  }
}
