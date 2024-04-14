public class Executive implements Deposit, Transfer, Transaction{
    @Override
    public void deposit(double amount) {
        System.out.println("Usuario ejecutivo Deposita: " + amount);
    }

    @Override
    public void transfer(double amount, String accountNumber) {
        System.out.println("Usuario Ejecutivo Transfiere " + amount + " a esta cuenta: " + accountNumber);
    }
}
