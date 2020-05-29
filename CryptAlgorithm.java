package encryptdecrypt;

abstract class CryptAlgorithm {

    public final static String ENCRYPT = "enc";
    public final static String DECRYPT = "dec";

    abstract String encrypt(String data, int key);

    abstract String decrypt(String data, int key);

}

class AlgorithmShift extends CryptAlgorithm {

    @Override
    String encrypt(String data, int key) {
        return data.codePoints()
                .map(c -> shiftCharEnc(c, key))
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    @Override
    String decrypt(String data, int key) {
        return data.codePoints()
                .map(c -> shiftCharDec(c, key))
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    static char shiftCharEnc(int c, int key) {

        char charTmp = (char) c;
        if ((charTmp >= 'a' && charTmp <= 'z')) {

            char charShift = (char) (charTmp + key);
            if (charShift > 'z') {
                return (char) (charTmp - (26 - key));
            } else {
                return (char) (charTmp + key);
            }

        } else {
            return charTmp;
        }
    }

    static char shiftCharDec(int c, int key) {

        char charTmp = (char) c;

        if ((charTmp >= 'a' && charTmp <= 'z')) {

            char charShift = (char) (charTmp - key);
            if (charShift < 'a') {
                return (char) (charTmp + (26 - key));
            } else {
                return (char) (charTmp - key);
            }

        } else {
            return charTmp;
        }

    }
}

class AlgorithmUnicode extends CryptAlgorithm {

    @Override
    String encrypt(String data, int key) {
        return data.codePoints()
                .map(c -> c + key)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    @Override
    String decrypt(String data, int key) {
        return data.codePoints()
                .map(c -> c - key)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}