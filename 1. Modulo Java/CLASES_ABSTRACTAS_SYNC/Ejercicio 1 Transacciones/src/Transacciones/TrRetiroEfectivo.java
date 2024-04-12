package Transacciones;

public class TrRetiroEfectivo implements Transaccion{

    @Override
    public void noOk() {
        System.out.println("Imposible retirar dinero");
    }

    @Override
    public void ok() {
        System.out.println("Retiro de efectivo correct");
    }

}
