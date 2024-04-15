package punto1;

public class Basic {
    ConsultaSaldo consultaSaldo = new ConsultaSaldo();
    PagoServicios pagoServicios = new PagoServicios();
    RetiroEfectivo retiroEfectivo = new RetiroEfectivo();

    public void consultaSaldo() {
        consultaSaldo.consultarSaldo();
        consultaSaldo.transaccionOk();
    }

    public void pagoServicios() {
        pagoServicios.realizarPago();
        pagoServicios.transaccionOk();
    }
    public void retiroEfectivo() {
        retiroEfectivo.realizarRetiro();
        retiroEfectivo.transaccionOk();
    }
}
