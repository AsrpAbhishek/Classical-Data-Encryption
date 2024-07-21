package utility;

import Encryption.*;
import java.util.Random;
import java.util.Scanner;

public class TimeComplexityChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text to encrypt: ");
        String text = scanner.nextLine();

        System.out.print("Enter encryption method (Caesar, MonoAlphabetic, Hill, Playfair, ROT13, Transposition, Vernam, Vigenere): ");
        String method = scanner.nextLine();

        System.out.print("Enter key (for Caesar, enter shift value; for others, enter the key string): ");
        String key = scanner.nextLine();

        long startTime, endTime;
        String encryptedText = "";

        switch (method) {
            case "Caesar":
                startTime = System.nanoTime();
                encryptedText = Caesar.encrypt(text, Integer.parseInt(key));
                endTime = System.nanoTime();
                System.out.println("Caesar Cipher: " + (endTime - startTime) + " ns");
                break;

            case "MonoAlphabetic":
                startTime = System.nanoTime();
                encryptedText = MonoAlphabetic.encrypt(text, key);
                endTime = System.nanoTime();
                System.out.println("MonoAlphabetic Cipher: " + (endTime - startTime) + " ns");
                break;

            case "Hill":
                int[][] keyMatrix = { {1, 2}, {3, 4} }; // example key matrix
                HillCipher hillCipher = new HillCipher(keyMatrix);
                startTime = System.nanoTime();
                encryptedText = hillCipher.encrypt(text.substring(0, 2)); // Hill cipher requires a fixed length input
                endTime = System.nanoTime();
                System.out.println("Hill Cipher: " + (endTime - startTime) + " ns");
                break;

            case "Playfair":
                Playfair playfairCipher = new Playfair(key);
                startTime = System.nanoTime();
                encryptedText = playfairCipher.encrypt(text);
                endTime = System.nanoTime();
                System.out.println("Playfair Cipher: " + (endTime - startTime) + " ns");
                break;

            case "ROT13":
                startTime = System.nanoTime();
                encryptedText = ROT13.encrypt(text);
                endTime = System.nanoTime();
                System.out.println("ROT13 Cipher: " + (endTime - startTime) + " ns");
                break;

            case "Transposition":
                int[] transpositionKey = {0, 2, 1}; // example key
                startTime = System.nanoTime();
                encryptedText = Transposition.encrypt(text, transpositionKey);
                endTime = System.nanoTime();
                System.out.println("Transposition Cipher: " + (endTime - startTime) + " ns");
                break;

            case "Vernam":
                String vernamKey = generateRandomText(text.length());
                startTime = System.nanoTime();
                encryptedText = Vernam.encrypt(text, vernamKey);
                endTime = System.nanoTime();
                System.out.println("Vernam Cipher: " + (endTime - startTime) + " ns");
                break;

            case "Vigenere":
                startTime = System.nanoTime();
                encryptedText = Vigenere.encrypt(text, key);
                endTime = System.nanoTime();
                System.out.println("Vigenere Cipher: " + (endTime - startTime) + " ns");
                break;

            default:
                System.out.println("Unknown encryption method.");
                break;
        }

        System.out.println("Encrypted text: " + encryptedText);
    }

    private static String generateRandomText(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append((char) (random.nextInt(26) + 'A'));
        }
        return sb.toString();
    }
}
