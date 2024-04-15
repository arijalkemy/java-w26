public class Ejecutivo extends Cliente{

    @Override
    void realizarTransaccion(Transaccion transaccion) {
        if (transaccion instanceof Deposito || transaccion instanceof Transferencia){
            transaccion.transaccionOk();
        }
        else {
            transaccion.transaccionNoOk();
        }
    }
}
