package com.github.blalasaadri.javaNextDemos.java13.textblocks;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("InnerClassMayBeStatic")
class TextBlocksTest {
    @Nested
    @DisplayName("text blocks can be used for markup")
    class TextBlocksCanBeUsedForMarkup {
        @Test
        void rendersTitleIntoHtml() {
            final var title = "My grandiose title";

            var html = TextBlocks.toHtmlPage(title, "body");

            assertThat(html)
                    .matches("[\\s\\S]*<title>" + title + "</title>[\\s\\S]*");
        }

        @Test
        void rendersBodyIntoHtml() {
            final var body = """
                <div class="body">
                    <label for="myWonderfulInput">My wonderful input</label>
                    <input type="text" id="myWonderfulInput"/>
                </div>
                """;

            var html = TextBlocks.toHtmlPage("title", body);

            assertThat(html)
                    .matches("[\\s\\S]*<body>\\s*" + body + "\\s*</body>[\\s\\S]*");
        }
    }

    @Nested
    @DisplayName("indendation")
    class Indentation {
        @Test
        void endingTheMultilineStringRightAfterTheString_returnsStringWithoutClosingEndline() {
            final var multilineString = """
            This is a multiline string""";
            final var expectedString = "This is a multiline string";

            assertThat(multilineString)
                    .isEqualTo(expectedString);
        }

        @ParameterizedTest
        @ValueSource(strings = {
                """
            This is a multiline string
            """,
            """
This is a multiline string
            """
        })
        void whenStringBeginsBeforeOpeningDelimiter_stringIsNormalizedToTheBeginningOfTheContent(String multilineString) {
            final var expectedString = "This is a multiline string\n";

            assertThat(multilineString)
                    .isEqualTo(expectedString);
        }

        @ParameterizedTest
        @ValueSource(strings = {
        """
            This is a multiline string
""",
                    """
            This is a multiline string
"""
        })
        void whenEndingDelimiterBeginsBeforeContent_stringIsIndented(String multilineString) {
            final var expectedString = "            This is a multiline string\n";

            assertThat(multilineString)
                    .isEqualTo(expectedString);
        }
    }
}
