package com.nayanzin.democucumber;

import org.apache.commons.io.IOUtils;
import org.springframework.http.client.ClientHttpResponse;
import sun.nio.ch.IOUtil;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

public class ResponseResults {

    private final ClientHttpResponse response;
    private final String body;

    public ResponseResults(final ClientHttpResponse response) throws IOException {
        this.response = response;
        final InputStream is = response.getBody();
        final StringWriter stringWriter = new StringWriter();
        IOUtils.copy(is, stringWriter);
        this.body = stringWriter.toString();
    }

    public ClientHttpResponse getResponse() {
        return response;
    }

    public String getBody() {
        return body;
    }
}
