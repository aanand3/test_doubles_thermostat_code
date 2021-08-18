package smarthome;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpModeSwitch implements ModeSwitch {
    private HttpClient httpClient;
    private URL url;

    public HttpModeSwitch(URL url, HttpClient httpClient) {
        this.url = url;
        this.httpClient = httpClient;
    }

    public Mode currentMode() {
        var request = HttpRequest.newBuilder(URI.create(url + "/currentMode"))
                .header("accept", "application/json")
                .build();

        HttpResponse<String> response = null;
        try {
            response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return Mode.valueOf(String.valueOf(response.body()));
    }
}
