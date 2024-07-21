package Encryption;

public class Vernam {
    public static String encrypt(String text, String key) {
        if (text.length() != key.length()) {
            throw new IllegalArgumentException("Key length must match text length");
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char ch = (char) (text.charAt(i) ^ key.charAt(i));
            result.append(ch);
        }
        return result.toString();
    }
}

