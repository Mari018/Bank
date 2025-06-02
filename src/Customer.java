public class Customer {

    private String nif;
    private String name;
    private String[] iban;
    private String[] cardsId;
    private int counterIbans;


    public Customer(String nif, String name) {
        this.nif = nif;
        this.name = name;
        this.iban = new String[3000];
    }

    public String getNif() {
        return nif;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getIban() {
        return iban;
    }

    public void addIBAN(String iban) {
        this.iban[counterIbans++] = iban;
    }
}