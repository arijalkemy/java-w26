public class Cobrador extends Cliente {

    @Override
    void realizarTransaccion(ITransaccion transaccion) {
        if (transaccion instanceof ConsultaSaldo || transaccion instanceof RetiroEfectivo) {
            transaccion.transaccionOk();
        } else {
            transaccion.transaccionNoOk();
        }
    }
}
