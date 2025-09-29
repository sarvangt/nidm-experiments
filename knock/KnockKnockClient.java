// KnockKnockClient.java
import java.io.*;
import java.net.*;

public class KnockKnockClient {
    public static void main(String[] args) {
        String hostname = "127.0.0.1"; // same computer
        int port = 65432;

        try (Socket socket = new Socket(hostname, port)) {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String serverLine = in.readLine();
            System.out.println("SERVER: " + serverLine);

            // Reply 1
            out.println("Who's there?");
            System.out.println("CLIENT: Who's there?");

            serverLine = in.readLine();
            System.out.println("SERVER: " + serverLine);

            // Reply 2
            out.println(serverLine + " who?");
            System.out.println("CLIENT: " + serverLine + " who?");

            serverLine = in.readLine();
            System.out.println("SERVER: " + serverLine);

        } catch (UnknownHostException ex) {
            System.out.println("Server not found: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("I/O error: " + ex.getMessage());
        }
    }
}
