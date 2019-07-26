package com.github.blalasaadri.javaNextDemos.java12.newapis;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("InnerClassMayBeStatic")
class StringApisTest {

    @Nested
    @DisplayName("String.indent(int)")
    class Indent {
        @Test
        void withAPositiveNumber_indentsAllLinesOfAString() {
            var original = "\n"
                    + "zero\n"
                    + "one\n"
                    + "two\n"
                    + "three";

            String indented = original.indent(4);

            assertThat(indented)
                    .isEqualTo("    \n"
                            + "    zero\n"
                            + "    one\n"
                            + "    two\n"
                            + "    three\n"
                    );
        }

        @Test
        void withANegativeNumber_removesUpToThatNumberOfLeadingWhitespaces() {
            var original = "\n"
                    + "zero\n"
                    + " one\n"
                    + "  two\n"
                    + "   three\n"
                    + "    four";

            String indented = original.indent(-3);

            assertThat(indented)
                    .isEqualTo("\n"
                            + "zero\n"
                            + "one\n"
                            + "two\n"
                            + "three\n"
                            + " four\n"
                    );
        }

        @Test
        void normalizesLinebreaks() {
            var original = "\r"
                    + "zero\r"
                    + "one\r"
                    + "two\r"
                    + "three";

            String indented = original.indent(4);

            assertThat(indented)
                    .isEqualTo("    \n"
                            + "    zero\n"
                            + "    one\n"
                            + "    two\n"
                            + "    three\n"
                    );
        }
    }

    @Nested
    @DisplayName("String.transform(Function)")
    class Transform {
        @Test
        void transform_canTransformStringsIntoOtherStrings() {
            var transformedString = "Hello, %s"
                    .transform(s -> String.format(s, "World"))
                    .transform(s -> s + "!");

            assertThat(transformedString)
                    .isEqualTo("Hello, World!");
        }

        @Test
        void transform_canTranssformStringsIntoNonStrings() {
            int transformedValue =
                    "{ \"id\": 123, \"name\": \"myWonderfulObject\" }"
                            .transform(this::extractIdAsString)
                            .transform(Integer::parseInt);

            assertThat(transformedValue)
                    .isEqualTo(123);
        }

        private String extractIdAsString(String s) {
            Pattern p = Pattern.compile(".*\"id\":\\s*(?<digits>\\d+).*");
            Matcher matcher = p.matcher(s);
            matcher.find();
            return matcher.group("digits");
        }
    }
}
