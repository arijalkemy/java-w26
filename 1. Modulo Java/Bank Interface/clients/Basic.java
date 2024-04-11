import org.example.banco.Bank.Bank;

public class Basic {
    private final Bank bank;

    public Basic() {
        this.bank = new Bank();
    }

    public void checkBalance() {
        System.out.println(this.bank.getCheckBalance());
    }

    public void paymentServices() {
        System.out.println(this.bank.getPaymentServices());
    }

    public void withdrawal() {
        System.out.println(this.bank.getWithdrawal());
    }
}
