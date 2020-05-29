package encryptdecrypt;

abstract class CryptographerFactory {

    protected Command command;
    protected CryptAlgorithm cryptAlgorithm;
    protected String data = "";

    public CryptographerFactory(String... args) {
        this.command = new Command(args);
    }

    public void execute() {
        setAlgorithm();
        setData();
        String tmpData = convert(command.getMode(), command.getKey(), data);
        output(tmpData);
    }

    protected abstract void setData();

    protected abstract void setAlgorithm();

    public String convert(String type, int key, String data) {
        return type.equals(CryptAlgorithm.ENCRYPT) ? cryptAlgorithm.encrypt(data, key) : cryptAlgorithm.decrypt(data, key);
    }

    public void output(String data) {
        if (command.getOutputFile().equals("")) {
            System.out.println(data);
        } else {
            FileManager.write(command.getOutputFile(), data);
        }
    }

}
