public class Cobrador extends Cliente{

    @Override
    void realizarTransaccion(Transaccion transaccion) {
        if (transaccion instanceof ConsultaDeSaldo || transaccion instanceof RetiroDeEfectivo){
            transaccion.transaccionOk();
        }
        else {
            transaccion.transaccionNoOk();
        }
    }
}
