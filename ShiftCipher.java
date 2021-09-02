package encryptdecrypt;

public class ShiftCipher implements Cipher {

    public String encryptMessage(String data, int key) {
        StringBuilder output = new StringBuilder();
        for (char i : data.toCharArray()) {
            char startLetter = i > 90 ? 'a' : 'A';
            if (i != ' ') {
                int originalPosition = i - startLetter;
                int newAlphabetPosition = (originalPosition + key) % 26;
                char newCharacter = (char)(startLetter + newAlphabetPosition);
                output.append(newCharacter);
            } else {
                output.append(i);
            }
        }
        return output.toString();
    }

    public String decryptMessage(String data, int key) {
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder output = new StringBuilder();
        for (char i : data.toCharArray()) {
            String letterLibrary = i > 90 ? lower : upper;
            char startLetter = i > 90 ? 'a' : 'A';
            if (i >= 65 && i <= 90 || i >= 97 && i <= 122) {
                int originalPosition = i - startLetter;
                int newAlphabetPosition = (originalPosition - key) % 26;
                if (newAlphabetPosition < 0) {
                    newAlphabetPosition = 26 + newAlphabetPosition;
                }
                char newCharacter = letterLibrary.charAt(newAlphabetPosition);
                output.append(newCharacter);
            } else {
                output.append(i);
            }
        }
        return output.toString();
    }
}
