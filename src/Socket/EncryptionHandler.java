package Socket;

import Encryption.*;
import java.io.*;
import java.net.*;

public class EncryptionHandler extends Thread {
    private Socket socket;

    public EncryptionHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try (InputStream input = socket.getInputStream();
             BufferedReader reader = new BufferedReader(new InputStreamReader(input));
             OutputStream output = socket.getOutputStream();
             PrintWriter writer = new PrintWriter(output, true)) {

            String text = reader.readLine();
            String method = reader.readLine();
            String key = reader.readLine();

            String encryptedText = "";
            switch (method) {
                case "Caesar":
                    encryptedText = Caesar.encrypt(text, Integer.parseInt(key));
                    break;
                case "MonoAlphabetic":
                    encryptedText = MonoAlphabetic.encrypt(text, key);
                    break;
                case "Hill":
                    int[][] keyMatrix = {{1, 2}, {3, 4}}; // example key matrix
                    HillCipher hillCipher = new HillCipher(keyMatrix);
                    encryptedText = hillCipher.encrypt(text.substring(0, 2)); // Hill cipher requires a fixed length input
                    break;
                case "Playfair":
                    Playfair playfairCipher = new Playfair(key);
                    encryptedText = playfairCipher.encrypt(text);
                    break;
                case "ROT13":
                    encryptedText = ROT13.encrypt(text);
                    break;
                case "Transposition":
                    int[] transpositionKey = {0, 2, 1}; // example key
                    encryptedText = Transposition.encrypt(text, transpositionKey);
                    break;
                case "Vernam":
                    encryptedText = Vernam.encrypt(text, key);
                    break;
                case "Vigenere":
                    encryptedText = Vigenere.encrypt(text, key);
                    break;
            }
            writer.println(encryptedText);
        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
