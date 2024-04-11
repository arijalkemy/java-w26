public class Bank {
    private org.example.banco.Bank.ITransaction checkBalance;
    private org.example.banco.Bank.ITransaction withdraw;
    private org.example.banco.Bank.ITransaction withdrawal;
    private org.example.banco.Bank.ITransaction transaction;
    private org.example.banco.Bank.ITransaction paymentServices;

    public Bank() {
        this.checkBalance = new TypeTransaction();
        this.withdraw = new org.example.banco.Bank.TypeTransaction();
        this.withdrawal = new org.example.banco.Bank.TypeTransaction();
        this.transaction = new org.example.banco.Bank.TypeTransaction();
        this.paymentServices = new org.example.banco.Bank.TypeTransaction();
    }

    public String getCheckBalance() {
        return "Consultando el saldo";
    }

    public String getWithdraw() {
        return "Realizando Deposito";
    }


    public String getWithdrawal() {
        return "Realizando retiro de efectivo";
    }


    public String getTransaction() {
        return "Realizando Transeferencia";
    }


    public String getPaymentServices() {
        return "Realizando pago de servicios";
    }
}
