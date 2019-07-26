package com.github.blalasaadri.javaNextDemos.java12.switchexpressions;

public class SwitchExpressions {
    public static String greet(String greeting, String name) {
        var greetingFormat = switch (greeting) {
            case "Hi" -> "Hi %s! How are you doing?";
            case "Hey" -> "Hey there, %s.";
            case "Hay", "Hj" -> "Howdy %s, you should check your spelling. ;-)";
            default -> {
                System.err.println("I don't know that greeting. Falling back to default.");
                break "Hello, %s!";
            }
        };

        // Alternative syntax:
//        String greetingFormat = switch (greeting) {
//            case "Hi": break "Hi %s! How are you doing?";
//            case "Hey": break "Hey there, %s.";
//            case "Hay", "Hj": break "Howdy %s, you should check your spelling. ;-)";
//            default:
//                System.err.println("I don't know that greeting. Falling back to default.");
//                break "Hello, %s!";
//        };

        return String.format(greetingFormat, name);
    }
}
