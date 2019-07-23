package com.github.blalasaadri.javaNextDemos.java11.http2;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class Http2ClientTest {

    private static final String HTTP2_CAPABLE_API = "https://http2.pro/api/v1";

    @Test
    void http2Calls_useHttp2() throws IOException, InterruptedException {
        var http2Client = new Http2Client();

        var result =
                http2Client.getViaHttp2(HTTP2_CAPABLE_API, Http2ProResponseBody.class);

        assertThat(result)
                .map(Http2ProResponseBody::isHttp2)
                .contains(true);
    }

    @Test
    void http1Calls_useHttp1() throws IOException, InterruptedException {
        var http2Client = new Http2Client();

        var result =
                http2Client.getViaHttp1(HTTP2_CAPABLE_API, Http2ProResponseBody.class);

        assertThat(result)
                .map(Http2ProResponseBody::isHttp2)
                .contains(false);
    }
}
