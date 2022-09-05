package se.salt.jfs.saltstars;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

import static java.net.http.HttpResponse.BodyHandlers.ofString;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationTest {
    static HttpClient client = HttpClient.newBuilder().build();
    private static int server_port = Integer.parseInt(String.valueOf(Application.loadProperties().get("server.port")));



    @BeforeAll
    static void startServer() {
        Application.main(new String[]{});
    }


    @Test
    void thePortIsConfigured() {
        assertNotNull(Application.loadProperties().getProperty("server.port"));
    }


    @Test
    void shouldReturnUnknownFriendWithoutQueryParameter() {
        try {
            HttpRequest req = HttpRequest.newBuilder(URI.create("http://localhost:" + server_port + "/")).build();
            HttpResponse<String> response = client.send(req, ofString(StandardCharsets.UTF_8));
            String body = response.body();
            String expected = """
                    {
                        "name": "Unknown Friend"
                    }
                    """;
            assertEquals(response.statusCode(), 200);
            assertEquals(expected, body);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            fail("Failed to parse response");
        }
    }

    @Test
    void shouldReturnCorrectNamedWithQueryParameter() {
        try {
            HttpRequest req = HttpRequest.newBuilder(URI.create("http://localhost:" + server_port + "?name=John")).build();
            HttpResponse<String> response = client.send(req, ofString(StandardCharsets.UTF_8));
            String body = response.body();
            String expected = """
                    {
                        "name": "John"
                    } 
                    """;
            assertEquals(response.statusCode(), 200);
            assertEquals(expected, body);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            fail("Failed to parse response");
        }
    }


}