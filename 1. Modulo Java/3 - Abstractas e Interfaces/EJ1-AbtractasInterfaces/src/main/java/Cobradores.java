public class Cobradores extends Cliente{

    @Override
    public void retirarEfectivo(){
        Transaccion retiro = new RetiroDeEfectivo();
        retiro.TransaccionOK();
    }

    @Override
    public void consultarSaldo() {
        Transaccion consultaDeSaldo = new ConsultaDeSaldo();
        consultaDeSaldo.TransaccionNoOk();
    };

}
