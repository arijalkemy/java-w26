public class Basic extends Cliente{
    @Override
    void realizarTransaccion(Transaccion transaccion) {
        if (transaccion instanceof ConsultaDeSaldo || transaccion instanceof PagoServicios || transaccion instanceof RetiroDeEfectivo){
            transaccion.transaccionOk();
        }
        else {
            transaccion.transaccionNoOk();
        }
    }
}
