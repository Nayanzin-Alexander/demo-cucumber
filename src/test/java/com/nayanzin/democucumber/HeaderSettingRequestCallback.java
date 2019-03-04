package com.nayanzin.democucumber;

import org.springframework.http.HttpHeaders;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.web.client.RequestCallback;

import java.io.IOException;
import java.util.Map;

import static java.util.Objects.nonNull;

public class HeaderSettingRequestCallback implements RequestCallback {

    final Map<String, String> requestHeaders;

    private String body;

    public HeaderSettingRequestCallback(final Map<String, String> headers) {
        this.requestHeaders = headers;
    }

    public void setBody(final String body) {
        this.body = body;
    }

    @Override
    public void doWithRequest(ClientHttpRequest request) throws IOException {
        final HttpHeaders clientHeaders = request.getHeaders();
        for (final Map.Entry<String, String> header : this.requestHeaders.entrySet()) {
            clientHeaders.add(header.getKey(), header.getValue());
        }
        if (nonNull(body)) {
            request.getBody().write(body.getBytes());
        }
    }
}
