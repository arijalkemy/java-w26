import org.example.banco.Bank.Bank;

public class Executive {
    private final Bank bank;

    public Executive() {
        this.bank = new Bank();
    }

    public void withdraw() {
        System.out.println(bank.getWithdraw());
    }

    public void transaction() {
        System.out.println(bank.getTransaction());
    }

    public void paymentServices() {
        System.out.println(bank.getPaymentServices());
    }

    public void withdrawal() {
        System.out.println(bank.getWithdrawal());
    }
}
