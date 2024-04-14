public class DebtCollector implements GetCash, CheckBalance, Transaction {
    @Override
    public void checkBalance() {
        System.out.println("Usuario cobrador chequea su salario");
    }

    @Override
    public void removalEffective(double amount) {
        System.out.println("Usuario cobrador retira: " + amount + "efectivo");
    }
}
