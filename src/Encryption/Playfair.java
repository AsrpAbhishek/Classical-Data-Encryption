package Encryption;

public class Playfair {
    private char[][] matrix = new char[5][5];

    public Playfair(String key) {
        boolean[] used = new boolean[26];
        int x = 0, y = 0;
        for (char c : key.toCharArray()) {
            if (!used[c - 'a']) {
                matrix[x][y] = c;
                used[c - 'a'] = true;
                y++;
                if (y == 5) {
                    y = 0;
                    x++;
                }
            }
        }
        for (char c = 'a'; c <= 'z'; c++) {
            if (!used[c - 'a'] && c != 'j') {
                matrix[x][y] = c;
                used[c - 'a'] = true;
                y++;
                if (y == 5) {
                    y = 0;
                    x++;
                }
            }
        }
    }

    public String encrypt(String text) {
        // Method to implement the Playfair encryption
        return text; // placeholder
    }
}
