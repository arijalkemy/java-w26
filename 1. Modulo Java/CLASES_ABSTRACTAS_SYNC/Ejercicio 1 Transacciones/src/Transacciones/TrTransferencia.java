package Transacciones;


public class TrTransferencia implements Transaccion {
    
    @Override
    public void noOk() {
        System.out.println("La transferencia fue imposible!!!"); 
    }

    @Override
    public void ok() {
        System.out.println("La transferencias se realizo corrrectamente");
    }

}
