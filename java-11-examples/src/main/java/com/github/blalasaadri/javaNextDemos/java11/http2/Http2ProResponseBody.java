package com.github.blalasaadri.javaNextDemos.java11.http2;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.blalasaadri.javaNextDemos.java11.http2.ImmutableHttp2ProResponseBody;
import org.immutables.value.Value;

/**
 * Response format defined by https://http2.pro/doc/api
 */
@Value.Immutable
@Value.Style(get = {"get*", "is*"})
@JsonDeserialize(builder = ImmutableHttp2ProResponseBody.Builder.class)
public interface Http2ProResponseBody {
    String getProtocol();

    boolean isPush();

    @JsonProperty("user_agent")
    String getUserAgent();

    boolean isHttp2();
}
