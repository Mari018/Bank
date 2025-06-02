public abstract class Account {

    protected double balance;
    protected String iban;
    protected String[] nif = new String[20];
    private int counterNifs;

    public Account(String nif) {
        this.nif[0] = nif;
        iban = String.valueOf((int) (Math.random() * (999999999 - 100000000 + 1)) + 100000000);
    }

    public void deposit(double value) {
        balance += value;
    }

    public abstract void pay(double value);

    public double checkBalance() {
        return balance;
    }

    public String getIban() {
        return iban;
    }

    public void addNif(String nif) {
        this.nif[counterNifs++] = nif;
    }

    public boolean hasNif(String nif) {
        for (int i = 0; i < nif.length(); i++) {
            if (this.nif[i] == nif) {
                return true;
            }
        }
        return false;
    }
}
