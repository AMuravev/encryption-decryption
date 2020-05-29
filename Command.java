package encryptdecrypt;

public class Command {

    private int key = 0;
    private String mode = CryptAlgorithm.ENCRYPT;
    private String data = "";
    private String inputFile = null;
    private String outputFile = "";
    private String algorithm = null;

    Command(String... args) {

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-mode":
                    mode = args[++i];
                    break;
                case "-key":
                    key = Integer.parseInt(args[++i]);
                    break;
                case "-data":
                    data = args[++i];
                    break;
                case "-in":
                    inputFile = args[++i];
                    break;
                case "-out":
                    outputFile = args[++i];
                    break;
                case "-alg":
                    algorithm = args[++i];
                    break;
            }
        }
    }

    public int getKey() {
        return key;
    }

    public String getMode() {
        return mode;
    }

    public String getData() {
        return data;
    }

    public String getInputFile() {
        return inputFile;
    }

    public String getOutputFile() {
        return outputFile;
    }

    public String getAlgorithm() {
        return algorithm;
    }
}
