public class Ejecutivo extends Cliente{

    void realizarTransaccion(ITransaccion transaccion) {
        if (transaccion instanceof Deposito || transaccion instanceof Transferencia) {
            transaccion.transaccionOk();
        }
        else{
            transaccion.transaccionNoOk();
        }
    }

}
