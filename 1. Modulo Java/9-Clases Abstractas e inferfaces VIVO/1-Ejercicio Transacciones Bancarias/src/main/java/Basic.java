public class Basic implements CheckBalance, ServicePayment, GetCash, Transaction{
    @Override
    public void checkBalance() {
        System.out.println("Chequeo de mi saldo en cuenta");
    }

    @Override
    public void removalEffective(double amount) {
        System.out.println("Quiero retirar esta cantidad de efectivo: "  + amount);
    }

    @Override
    public void servicePayment(double amount, String serviceName) {
        System.out.println("Quiero pagar " + amount + "De este servicio " + serviceName);
    }
}
