import java.io.*;
import java.net.*;

public class ChatClient {
    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 1234;

        try (Socket socket = new Socket(hostname, port)) {
            System.out.println("Connected to server.");

            // Streams for communication
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Read from keyboard and send to server
            BufferedReader clientInput = new BufferedReader(new InputStreamReader(System.in));
            String clientMsg, serverMsg;

            while (true) {
                System.out.print("You: ");
                clientMsg = clientInput.readLine();
                out.println(clientMsg);

                serverMsg = in.readLine();
                if (serverMsg == null) break;
                System.out.println("Server: " + serverMsg);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
