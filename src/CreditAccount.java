public class CreditAccount extends Account {

    private Card creditCard;

    public CreditAccount(String nif) {
        super(nif);

    }

    public Card getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(Card creditCard) {
        this.creditCard = creditCard;
    }

    @Override
    public double checkBalance() {
        if (balance < -100) {
            System.out.println("Yor balance is below expected");
            return balance;
        }
        return super.checkBalance();
    }

    @Override
    public void pay(double value) {
        if (balance < -100) {
            System.out.println("ERROR");
        } else {
            balance -= value*0.02;
            System.out.println("-" + value*0.02);
        }
    }
}