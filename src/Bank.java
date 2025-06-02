public class Bank {

    int customerCounter;
    int accountCounter;
    private String name;
    private Customer[] clients;
    private Account[] accounts;

    public Bank(String name) {
        this.name = name;
        this.clients = new Customer[10];
        this.accounts = new Account[10];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Customer[] getNames() {
        return clients;
    }

    public void setNames(Customer[] names) {
        this.clients = names;
    }


    public Account[] getAccounts() {
        return accounts;
    }

    public void setAccounts(Account[] accounts) {
        this.accounts = accounts;
    }


    private Account getAccount(String iban) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] != null && accounts[i].getIban().compareTo(iban) == 0) {
                return accounts[i];
            }
        }
        return null;
    }


    public boolean getClientExists(String nif) {
        return clientExists(nif);
    }


    public Account getAccountByIban(String iban) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] != null && accounts[i].getIban() == iban) {
                return accounts[i];
            }
        }
        return null;
    }


    private boolean clientExists(String nif) {
        for (int i = 0; i < clients.length; i++) {
            if (clients[i] != null && clients[i].getNif().compareTo(nif) == 0) {
                return true;
            }
        }
        return false;
    }


    private boolean accountExists(String nif) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] != null && accounts[i].hasNif(nif)) {
                return true;
            }
        }
        return false;
    }


    private boolean customerExists(String nif) {
        for (int i = 0; i < clients.length; i++) {
            if (clients[i] != null && clients[i].getNif() == nif) {
                return true;
            }
        }
        return false;
    }


    public String createCustomer(String name, String nif) {
        if (customerExists(nif)) {
            return "Already exists";
        }

        Customer newCustomer = new Customer(nif, name);
        this.clients[customerCounter] = newCustomer;
        customerCounter++;
        return "Created";
    }


    public String createDebitAccount(String nif) {
        if (!customerExists(nif)) {
            return "Customer does not exist";
        }
        if (accountExists(nif)) {
            return "Already exists";
        }

        DebitAccount newDebitAccount = new DebitAccount(nif);
        this.accounts[accountCounter] = newDebitAccount;
        accountCounter++;

        return newDebitAccount.getIban();
    }


    public String createCreditAccount(String nif) {
        if ((!customerExists(nif))) {
            return "Customer does not exist";
        }

        CreditAccount newCreditAccount = new CreditAccount(nif);
        this.accounts[accountCounter] = newCreditAccount;
        accountCounter++;

        return newCreditAccount.getIban();

    }


    public String depositToAccount(String iban, double value) {
        Account accountToDeposit = getAccountByIban(iban);

        if (accountToDeposit == null) {
            return "Don't have an account";
        }
        accountToDeposit.deposit(value);
        return "You deposited" + value;
    }

    public String pay(String iban, double value){
        Account accountToPay = getAccountByIban(iban);

        if (accountToPay == null) {
            return "Don't have an account";
        }
        accountToPay.pay(value);
        return "You payed" + value;
    }

    public String WithDraw(String iban, double value){
        DebitAccount accountToWithDraw = (DebitAccount) getAccountByIban(iban);

        if (accountToWithDraw == null) {
            return "Don't have an account";
        }
        accountToWithDraw.whithdraw(value);
        return "You withdrawed" + value;
    }


}

































