import org.example.banco.Bank.Bank;

public class DebtCollertor {
    private final Bank bank;

    public DebtCollertor() {
        this.bank = new Bank();
    }

    public void withdrawal() {
        System.out.println(this.bank.getWithdrawal());
    }

    public void checkBalance() {
        System.out.println(this.bank.getCheckBalance());
    }
}
