public class DebitAccount extends Account{

    private Card[] debitCard;

    public DebitAccount(String nif) {
        super(nif);

    }

    public Card[] getDebitCard() {
        return debitCard;
    }

    public void setDebitCard(Card[] debitCard) {
        this.debitCard = debitCard;
    }


    public void whithdraw (double value) {
        if (balance < value) {
            System.out.println("You wish ypu had that money bitch");
        }
        balance -= value;
    }

    @Override
    public void pay(double value) {
        if (balance > 0) {
            balance -= value;
        }
        System.out.println("Go work bitch");
    }
}
