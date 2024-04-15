public class Ejecutivo implements Transaccion {

    @Override
    public void transaccionOk() {
        System.out.println("Transacción ejecutada correctamente.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transacción fallida.");
    }

    public void realizarDeposito() {
        System.out.println("Realizando depósito.");
    }

    public void realizarTransferencia() {
        System.out.println("Realizando transferencia.");
    }
}
