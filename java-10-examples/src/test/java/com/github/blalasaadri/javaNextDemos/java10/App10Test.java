package com.github.blalasaadri.javaNextDemos.java10;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.TestInstance.Lifecycle;

@SuppressWarnings("InnerClassMayBeStatic")
class App10Test {

    @Nested
    @TestInstance(Lifecycle.PER_CLASS)
    class greet {
        @ParameterizedTest(name = "Greeting {0} gives \"{1}\"")
        @MethodSource(value = "greetings")
        void shouldReturnGreeting(String name, String expectedGreeting) {
            var app = new App10();

            var greeting = app.greet(name);

            assertThat(greeting).isEqualTo(expectedGreeting);
        }

        private Stream<Arguments> greetings() {
            return Stream.of(
                    Arguments.of("User", "Hello, User!"),
                    Arguments.of("World", "Hello, World!")
            );
        }
    }

}
