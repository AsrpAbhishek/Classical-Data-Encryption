package utility;

import Socket.EncryptionClient;
import Socket.EncryptionServer;

import java.io.*;
import java.net.*;

public class Main {
    public static void main(String[] args) {
        // Start the server in a new thread
        new Thread(() -> EncryptionServer.main(args)).start();

        try {
            // Give the server a moment to start
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Define the inputs for testing
        String hostname = "localhost";
        int port = 12345;
        String text = "HelloWorld";
        String method = "Caesar";
        String key = "3";

        try (Socket socket = new Socket(hostname, port)) {
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);

            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            // Send the inputs
            writer.println(text);
            writer.println(method);
            writer.println(key);

            // Read the encrypted text
            String encryptedText = reader.readLine();
            System.out.println("Encrypted text: " + encryptedText);
        } catch (UnknownHostException ex) {
            System.out.println("Server not found: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("I/O error: " + ex.getMessage());
        }
    }
}
