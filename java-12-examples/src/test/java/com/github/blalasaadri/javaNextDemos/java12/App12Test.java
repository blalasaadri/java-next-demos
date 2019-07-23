package com.github.blalasaadri.javaNextDemos.java12;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class App12Test {

    @Test
    void forHi_shouldGreetWithQuestion() {
        String greeting = App12.greet("Hi", "World");

        assertThat(greeting)
                .isEqualTo("Hi World! How are you doing?");
    }

    @Test
    void forHey_shouldGreetWithHeyThere() {
        String greeting = App12.greet("Hey", "World");

        assertThat(greeting)
                .isEqualTo("Hey there, World.");
    }

    @ParameterizedTest
    @ValueSource(strings = { "Hay", "Hj" })
    void forMisspellings_shouldGreetWithCorrection(String prompt) {
        String greeting = App12.greet(prompt, "World");

        assertThat(greeting)
                .endsWith("you should check your spelling. ;-)");
    }

    @ParameterizedTest
    @ValueSource(strings = { "¡Hola!", "Ciao" })
    void forUnknownGreetings_shouldGreetWithHello(String prompt) {
        String greeting = App12.greet(prompt, "World");

        assertThat(greeting)
                .isEqualTo("Hello, World!");
    }
}
