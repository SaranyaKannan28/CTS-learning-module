import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class HttpClientExample {
    public static void main(String[] args) {
        try {
            // Step 1: Create HTTP client
            HttpClient client = HttpClient.newHttpClient();

            // Step 2: Create GET request to GitHub API
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.github.com/repos/openai/gpt-3"))
                    .GET()
                    .build();

            // Step 3: Send the request
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Step 4: Print status and response body
            System.out.println("Status Code: " + response.statusCode());
            System.out.println("Response Body:\n" + response.body());

            // Step 5: Parse JSON with Gson (optional)
            JsonElement element = JsonParser.parseString(response.body());
            JsonObject obj = element.getAsJsonObject();

            System.out.println("\nParsed JSON:");
            System.out.println("Name: " + obj.get("name").getAsString());
            System.out.println("Description: " + obj.get("description").getAsString());
            System.out.println("Stars: " + obj.get("stargazers_count").getAsInt());
            System.out.println("Forks: " + obj.get("forks_count").getAsInt());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
