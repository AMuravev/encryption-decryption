package encryptdecrypt;

public class Cryptographer extends CryptographerFactory {

    public Cryptographer(String... args) {
        super(args);
    }

    @Override
    protected void setData() {
        if (command.getData().equals("") && command.getInputFile() != null) {
            data = FileManager.read(command.getInputFile());
        } else {
            data = command.getData();
        }
    }

    @Override
    protected void setAlgorithm() {
        cryptAlgorithm = command.getAlgorithm().equals("unicode") ? new AlgorithmUnicode() : new AlgorithmShift();
    }
}
