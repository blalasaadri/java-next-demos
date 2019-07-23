package com.github.blalasaadri.javaNextDemos.java11;

import com.github.blalasaadri.javaNextDemos.java11.http2.Http2Client;
import com.github.blalasaadri.javaNextDemos.java11.http2.Http2ProResponseBody;
import com.github.blalasaadri.javaNextDemos.java11.lambdavar.LambdaVar;

import java.io.IOException;

public class App11 {

    private static Http2Client http2Client = new Http2Client();

    public static void main(String[] args) throws IOException, InterruptedException {
        http2Client.getViaHttp2("https://http2.pro/api/v1", Http2ProResponseBody.class)
                .ifPresent(response -> {
                    System.out.printf("HTTP/2 was %s.\n", (response.isHttp2() ? "used" : "not used"));
                    System.out.printf("So, that's the protocol \"%s\".\n", response.getProtocol());
                    System.out.printf("HTTP2 push is %s.\n", (response.isPush() ? "supported" : "not supported"));
                    System.out.printf("The user agent \"%s\" was used.\n", response.getUserAgent());
                });

        System.out.println();

        LambdaVar lambdaVar = new LambdaVar();
        lambdaVar.repeat3times(args);
    }

}
