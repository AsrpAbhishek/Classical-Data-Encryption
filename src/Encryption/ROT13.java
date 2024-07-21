package Encryption;

public class ROT13 {
    public static String encrypt(String text) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                ch = (char)(base + (ch - base + 13) % 26);
            }
            result.append(ch);
        }
        return result.toString();
    }
}
