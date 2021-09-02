package encryptdecrypt;

public interface Cipher {
    String encryptMessage(String data, int key);
    String decryptMessage(String data, int key);
}
