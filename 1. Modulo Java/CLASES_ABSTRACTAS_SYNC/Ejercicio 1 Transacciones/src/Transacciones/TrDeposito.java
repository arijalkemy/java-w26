package Transacciones;


public class TrDeposito implements Transaccion {

    @Override
    public void noOk() {
        System.out.println("Deposito NO OK");
    }

    @Override
    public void ok() {
        System.out.println("Depositado OK");
    }

    

}
