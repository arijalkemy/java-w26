public class Ejecutivo extends Cliente{

    @Override
    public void transferir() {
        Transaccion transferencia = new Transferencia();
        transferencia.TransaccionOK();
    };

    @Override
    public void depositar() {
        Transaccion deposito = new Deposito();
        deposito.TransaccionOK();
    };
}
