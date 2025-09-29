// KnockKnockServer.java
import java.io.*;
import java.net.*;

public class KnockKnockServer {
    public static void main(String[] args) {
        int port = 65432; // you can change if needed
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("KnockKnock Server is listening on port " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");

                // Input and output streams
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                // Protocol start
                out.println("KNOCK KNOCK");

                String line = in.readLine();
                if (line != null && line.equalsIgnoreCase("Who's there?")) {
                    out.println("LETTUCE");
                } else {
                    out.println("ERROR: Expected 'Who's there?'");
                    socket.close();
                    continue;
                }

                line = in.readLine();
                if (line != null && line.equalsIgnoreCase("Lettuce who?")) {
                    out.println("LETTUCE IN, IT'S COLD OUTSIDE!");
                } else {
                    out.println("ERROR: Expected 'Lettuce who?'");
                }

                socket.close();
                System.out.println("Client disconnected");
            }
        } catch (IOException ex) {
            System.out.println("Server error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
