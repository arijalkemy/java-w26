public class Ejecutivos implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Transaccion ejecutiva exitosa");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transaccion ejecutiva no exitosa");
    }
    public void deposito() {
        System.out.println("Realizando depósito.");
    }

    public void transferencia() {
        System.out.println("Realizando transferencia.");
    }
}
