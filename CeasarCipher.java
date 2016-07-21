import java.util.Scanner;

public class CeasarCipher {
    private static String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String encrypt(String plainText, int key) {
        String cipherText = "";
        for (int i = 0; i < plainText.length(); i++) {
            int index = ALPHABET.indexOf(plainText.charAt(i));
            int keyVal = (index + key) % 26;
            char charToReplace = ALPHABET.charAt(keyVal);
            cipherText += charToReplace;
        }
        return cipherText;
    }

    public static String decrypt(String cipherText, int key) {
        String plainText = "";
        for (int i = 0; i < cipherText.length(); i++) {
            int index = ALPHABET.indexOf(cipherText.charAt(i));
            int keyVal = (index - key) % 26;
            if (keyVal < 0) {
                keyVal += ALPHABET.length();
            }
            char charToReplace = ALPHABET.charAt(keyVal);
            plainText += charToReplace;
        }
        return plainText;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the plain text : ");
        String plainText = sc.nextLine();
        System.out.println("Enter the key : ");
        int key = sc.nextInt();
        String cipherText = encrypt(plainText, key);
        System.out.println("Cipher Text : " + cipherText);
        plainText=decrypt(cipherText,key);
        System.out.println("Plain Text : " + plainText);
    }
}
