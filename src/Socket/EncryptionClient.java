package Socket;

import java.io.*;
import java.net.*;

public class EncryptionClient {
    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 12345;

        try (Socket socket = new Socket(hostname, port)) {
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);

            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Enter text to encrypt: ");
            String text = consoleReader.readLine();

            System.out.print("Enter encryption method (Caesar, MonoAlphabetic, Hill, Playfair, ROT13, Transposition, Vernam, Vigenere): ");
            String method = consoleReader.readLine();

            System.out.print("Enter key (for Caesar, enter shift value; for others, enter the key string): ");
            String key = consoleReader.readLine();

            writer.println(text);
            writer.println(method);
            writer.println(key);

            String encryptedText = reader.readLine();
            System.out.println("Encrypted text: " + encryptedText);
        } catch (UnknownHostException ex) {
            System.out.println("Server not found: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("I/O error: " + ex.getMessage());
        }
    }
}
