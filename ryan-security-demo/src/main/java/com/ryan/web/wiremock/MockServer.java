package com.ryan.web.wiremock;

import com.github.tomakehurst.wiremock.client.WireMock;

/**
 * @author ryan
 * @version Id: MockServer, v 0.1 2022/4/12 4:01 PM ryan Exp $
 */
public class MockServer {

    public static void main(String[] args) {
        WireMock.configureFor("localhost",8062);
        WireMock.removeAllMappings();

        WireMock.stubFor(
                WireMock.get(
                        WireMock.urlPathEqualTo("/order/1"))
                        .willReturn(WireMock.aResponse().withBody("{\"id\":1}").withStatus(200))
        );
    }
}
