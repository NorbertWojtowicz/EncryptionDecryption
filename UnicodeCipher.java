package encryptdecrypt;

public class UnicodeCipher implements Cipher {

    public String cryptMessage(String type, String data, int key) {
        switch (type) {
            case "enc":
                return encryptMessage(data, key);
            case "dec":
                return decryptMessage(data, key);
            default:
                return null;
        }
    }

    public String encryptMessage(String data, int key) {
        StringBuilder output = new StringBuilder();
        for (char i : data.toCharArray()) {
            output.append((char)((i + key) % 127));
        }
        return output.toString();
    }

    public String decryptMessage(String data, int key) {
        StringBuilder output = new StringBuilder();
        for (char i : data.toCharArray()) {
            output.append((char)(i - key));
        }
        return output.toString();
    }
}
