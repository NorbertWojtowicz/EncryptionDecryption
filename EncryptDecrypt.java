package encryptdecrypt;

import java.io.File;

public class EncryptDecrypt {
    private Cipher algorithm = new ShiftCipher();
    private String mode = "enc";
    private String data = "";
    private int key = 0;
    private File sourceFile = null;
    private File outFile = null;

    EncryptDecrypt(String[] args) {
        setProperties(args);
        if (sourceFile != null && "".equals(data)) {
            data = Message.getData(sourceFile);
        }
    }

    public void cryptMessage() {
        String crypted;
        switch (mode) {
            case "enc":
                crypted = algorithm.encryptMessage(data, key);
                break;
            case "dec":
                crypted = algorithm.decryptMessage(data, key);
                break;
            default:
                throw new IllegalArgumentException();
        }
        if (outFile != null) {
            Message.writeToFile(outFile, crypted);
        } else {
            System.out.println(crypted);
        }
    }

    private void setProperties(String[] args) {
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-mode":
                    setMode(args[i + 1]);
                    break;
                case "-key":
                    setKey(Integer.parseInt(args[i + 1]));
                    break;
                case "-data":
                    appendToData(args[i + 1]);
                    break;
                case "-out":
                    setOutFile(new File(args[i + 1]));
                    break;
                case "-in":
                    if ("".equals(data)) {
                        setSourceFile(new File(args[i + 1]));
                    }
                    break;
                case "-alg":
                    if (args[i + 1].equals("unicode")) {
                        setAlgorithm(new UnicodeCipher());
                    }
            }
        }
    }

    public void setAlgorithm(Cipher algorithm) {
        this.algorithm = algorithm;
    }

    private void setKey(int key) {
        this.key = key;
    }

    private void setMode(String mode) {
        this.mode = mode;
    }

    private void appendToData(String data) {
        this.data += data;
    }

    private void setOutFile(File outFile) {
        this.outFile = outFile;
    }

    private void setSourceFile(File sourceFile) {
        this.sourceFile = sourceFile;
    }
}
