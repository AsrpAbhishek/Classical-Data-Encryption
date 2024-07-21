package Encryption;

import java.util.Arrays;

public class Transposition {
    public static String encrypt(String text, int[] key) {
        int numCols = key.length;
        int numRows = (int) Math.ceil((double) text.length() / numCols);
        char[][] matrix = new char[numRows][numCols];
        for (char[] row : matrix) Arrays.fill(row, 'X');

        for (int i = 0; i < text.length(); i++) {
            int row = i / numCols;
            int col = i % numCols;
            matrix[row][col] = text.charAt(i);
        }

        StringBuilder result = new StringBuilder();
        for (int col : key) {
            for (int row = 0; row < numRows; row++) {
                result.append(matrix[row][col]);
            }
        }

        return result.toString();
    }
}
