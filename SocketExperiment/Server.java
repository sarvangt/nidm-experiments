import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        int port = 5000;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started. Waiting for a client...");

            Socket socket = serverSocket.accept(); // Accept a client connection
            System.out.println("Client connected!");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String messageFromClient = in.readLine();
            System.out.println("Received from client: " + messageFromClient);

            String response = "Hello from Server!";
            out.println(response);
            System.out.println("Sent to client: " + response);

            socket.close();
            System.out.println("Connection closed.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
