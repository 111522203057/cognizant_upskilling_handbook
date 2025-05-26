import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientExample {
    public static void main(String[] args) {
        try {
            // Create HttpClient
            HttpClient client = HttpClient.newHttpClient();

            // Create HttpRequest for GitHub API (fetch user info)
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://api.github.com/users/octocat"))
                    .GET()
                    .build();

            // Send request and get response
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Print response status code
            System.out.println("Status Code: " + response.statusCode());

            // Print response body
            System.out.println("Response Body:\n" + response.body());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
