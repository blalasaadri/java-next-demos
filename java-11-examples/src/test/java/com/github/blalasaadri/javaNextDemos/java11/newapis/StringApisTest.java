package com.github.blalasaadri.javaNextDemos.java11.newapis;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("InnerClassMayBeStatic")
class StringApisTest {

    @Nested
    class Strippings {

        @Test
        void stripLeading_removesAllLeadingWhitespaces() {
            var original = "   Hey,  there!   ";

            String stripped = original.stripLeading();

            assertThat(stripped)
                    .isEqualTo("Hey,  there!   ");
        }

        @Test
        void stripTrailing_removesAllTrailingWhitespaces() {
            var original = "   Hey,  there!   ";

            String stripped = original.stripTrailing();

            assertThat(stripped)
                    .isEqualTo("   Hey,  there!");
        }

        @Test
        void strip_removesBothLeadingAndTrailingWhitespaces() {
            var original = "   Hey,  there!   ";

            String stripped = original.strip();

            assertThat(stripped)
                    .isEqualTo("Hey,  there!");
        }

    }

    @Nested
    @DisplayName("String.lines()")
    class Lines {

        @Test
        void forAMultilineStringWithLineFeed_separatesItIntoStreamOfLines() {
            var multilineString = "one\ntwo\nthree\nfour\nfive";

            Stream<String> lines = multilineString.lines();

            assertThat(lines)
                    .containsExactly(
                            "one",
                            "two",
                            "three",
                            "four",
                            "five"
                    );
        }

        @Test
        void forAMultilineStringWithCarriageReturn_separatesItIntoStreamOfLines() {
            var multilineString = "one\rtwo\rthree\rfour\rfive";

            Stream<String> lines = multilineString.lines();

            assertThat(lines)
                    .containsExactly(
                            "one",
                            "two",
                            "three",
                            "four",
                            "five"
                    );
        }

        @Test
        void forAMultilineStringWithCarriageReturnAndALineFeed_separatesItIntoStreamOfLines() {
            var multilineString = "one\r\ntwo\r\nthree\r\nfour\r\nfive";

            Stream<String> lines = multilineString.lines();

            assertThat(lines)
                    .containsExactly(
                            "one",
                            "two",
                            "three",
                            "four",
                            "five"
                    );
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "",
            " ", // Regular space, does not work for non-breaking spaces
            "\t",
            "\n",
            "\r",
            "\u005Ct", // Horizontal tabulation
            "\u005Cn", // Line feed
            "\u000B", // Vertical tabulator
            "\u005Cf", // Form feed
            "\u005Cr", // Carriage return
            "\u001C", // File separator
            "\u001D", // Group separator
            "\u001E", // Record separator
            "\u001F", // Unit separator
    })
    void emptyStrings_areBlank(String emptyString) {
        assertThat(emptyString.isBlank())
                .isTrue();
    }

    @Test
    void repeat_repeatsAString() {
        var original = "ho ";

        String repeated = original.repeat(3);

        assertThat(repeated)
                .isEqualTo("ho ho ho ");
    }
}
