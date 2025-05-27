import java.io.*;
import java.net.*;

public class ChatServer {
    public static void main(String[] args) {
        int port = 1234;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started. Waiting for client...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected!");

            // Streams for communication
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Read and respond
            BufferedReader serverInput = new BufferedReader(new InputStreamReader(System.in));
            String clientMsg, serverMsg;

            while ((clientMsg = in.readLine()) != null) {
                System.out.println("Client: " + clientMsg);

                System.out.print("You: ");
                serverMsg = serverInput.readLine();
                out.println(serverMsg);
            }

            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
