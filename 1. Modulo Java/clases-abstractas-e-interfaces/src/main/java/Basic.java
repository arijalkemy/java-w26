public class Basic extends Cliente {

    @Override
    void realizarTransaccion(ITransaccion transaccion) {
        if (transaccion instanceof ConsultaSaldo || transaccion instanceof PagoServicio
                || transaccion instanceof RetiroEfectivo) {
            transaccion.transaccionOk();
        }
        else{
            transaccion.transaccionNoOk();
        }
    }
}
