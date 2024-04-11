public class Basic extends Cliente{

    @Override
    public void pagarServicios(){
        Transaccion pago = new PagoDeServicios();
        pago.TransaccionOK();
    };

    @Override
    public void consultarSaldo() {
        Transaccion consultaSaldo = new ConsultaDeSaldo();
        consultaSaldo.TransaccionOK();
    }

    @Override
    public void retirarEfectivo() {
        Transaccion retiro = new RetiroDeEfectivo();
        retiro.TransaccionNoOk();
    }
}
