public class Ejecutivos implements Deposito, Transferencia {
    public Ejecutivos() {
    }

    @Override
    public String realizarDeposito() {
        return "Realizando deposito...";
    }

    @Override
    public String transaccionOK() {
        return "Transaccion OK";
    }

    @Override
    public String transaccionNoOK() {
        return "Transaccion no OK";
    }

    @Override
    public String realizarTransferencia() {
        return "Realizando transferencia...";
    }
}
