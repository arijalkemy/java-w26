public class Cobrador implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Transaccion de cobrador exitosa");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transaccion de cobrador no exitosa");
    }
    public void retiroEfectivo() {
        System.out.println("Realizando retiro de efectivo.");
    }

    public void consultaSaldo() {
        System.out.println("Consultando saldo.");
    }
}
