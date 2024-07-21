package Encryption;

import java.util.Arrays;

public class HillCipher {
    private int[][] keyMatrix;
    private int size;

    public HillCipher(int[][] keyMatrix) {
        this.keyMatrix = keyMatrix;
        this.size = keyMatrix.length;
    }

    public String encrypt(String message) {
        message = message.toUpperCase().replaceAll("[^A-Z]", "");
        int[] messageVector = new int[size];
        for (int i = 0; i < size; i++) {
            messageVector[i] = message.charAt(i) - 'A';
        }

        int[] resultVector = new int[size];
        for (int i = 0; i < size; i++) {
            resultVector[i] = 0;
            for (int j = 0; j < size; j++) {
                resultVector[i] += keyMatrix[i][j] * messageVector[j];
            }
            resultVector[i] = resultVector[i] % 26;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < size; i++) {
            result.append((char) (resultVector[i] + 'A'));
        }
        return result.toString();
    }
}

