package Encryption;

public class MonoAlphabetic {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public static String encrypt(String text, String key) {
        text = text.toLowerCase();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            int index = ALPHABET.indexOf(ch);
            if (index != -1) {
                result.append(key.charAt(index));
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }
}

