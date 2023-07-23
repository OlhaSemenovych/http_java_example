package module7;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Slf4j
public class HttpStatusChecker {

    private static final HttpClient CLIENT = HttpClient.newHttpClient();

    public static String getStatusImage(int code) throws InterruptedException, IOException {
        URI formattedLink = URI.create(String.format("https://http.cat/%s.jpg", code));
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(formattedLink)
                    .GET()
                    .build();
            log.info("Received request status code: [{}]", getStatusCode(request));
            if (getStatusCode(request) == 404) {
                log.error("Entered status code don't exist! Please enter a valid status code!");
            }
        } catch (IOException e) {
            throw new IOException(e.getMessage());
        }
        return String.valueOf(formattedLink);
    }

    private static int getStatusCode(HttpRequest request) throws InterruptedException, IOException {
        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        return response.statusCode();
    }

}
