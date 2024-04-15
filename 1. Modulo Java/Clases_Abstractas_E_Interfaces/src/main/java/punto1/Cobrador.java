package punto1;

public class Cobrador {
    ConsultaSaldo consultaSaldo = new ConsultaSaldo();
    RetiroEfectivo retiroEfectivo = new RetiroEfectivo();

    public void consultarSaldo() {
        consultaSaldo.consultarSaldo();
        consultaSaldo.transaccionOk();
    }
    public void retiroEfectivo() {
        retiroEfectivo.realizarRetiro();
        retiroEfectivo.transaccionOk();

    }
}
