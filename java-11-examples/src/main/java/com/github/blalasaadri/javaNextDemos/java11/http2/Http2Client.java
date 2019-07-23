package com.github.blalasaadri.javaNextDemos.java11.http2;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Optional;

public class Http2Client {

    private ObjectMapper objectMapper = new ObjectMapper();

    public <T> Optional<T> getViaHttp2(String url, Class<T> responseClass) throws IOException, InterruptedException {
        return getViaHttp(HttpClient.Version.HTTP_2, url, responseClass);
    }

    public <T> Optional<T> getViaHttp1(String url, Class<T> responseClass) throws IOException, InterruptedException {
        return getViaHttp(HttpClient.Version.HTTP_1_1, url, responseClass);
    }

    private <T> Optional<T> getViaHttp(HttpClient.Version httpVersion, String url, Class<T> responseClass) throws IOException, InterruptedException {
        var httpClient = HttpClient.newBuilder()
                .version(httpVersion)
                .connectTimeout(Duration.ofSeconds(5))
                .followRedirects(HttpClient.Redirect.NORMAL)
                .build();
        var request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(url))
                .header("Accept-Type", "application/json")
                .build();
        var response = httpClient.send(
                request,
                HttpResponse.BodyHandlers.ofString()
        );
        if (response.statusCode() == 200) {
            return Optional.of(response.body())
                    .map(body -> {
                        try {
                            return objectMapper.readValue(body, responseClass);
                        } catch (IOException e) {
                            return null;
                        }
                    });
        }
        return Optional.empty();
    }
}
