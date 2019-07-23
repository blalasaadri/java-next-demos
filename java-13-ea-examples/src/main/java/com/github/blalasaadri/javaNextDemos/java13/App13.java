package com.github.blalasaadri.javaNextDemos.java13;

public class App13 {
    public static void main(String[] args) {
        System.out.println(greet(args[0], args[1]));
    }

    static String greet(String greeting, String name) {
//        String greetingFormat = switch (greeting) {
//            case "Hi" -> "Hi %s! How are you doing?";
//            case "Hey" -> "Hey there, %s.";
//            case "Hay", "Hj" -> "Howdy %s, you should check your spelling. ;-)";
//            default -> {
//                System.err.println("I don't know that greeting. Falling back to default.");
//                yield "Hello, %s!";
//            }
//        };

        // Alternative syntax:
        String greetingFormat = switch (greeting) {
            case "Hi": yield "Hi %s! How are you doing?";
            case "Hey": yield "Hey there, %s.";
            case "Hay", "Hj": yield "Howdy %s, you should check your spelling. ;-)";
            default:
                System.err.println("I don't know that greeting. Falling back to default.");
                yield "Hello, %s!";
        };

        return String.format(greetingFormat, name);
    }
}
