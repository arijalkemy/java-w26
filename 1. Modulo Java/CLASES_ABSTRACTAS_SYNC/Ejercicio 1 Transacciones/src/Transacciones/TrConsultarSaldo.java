package Transacciones;

public class TrConsultarSaldo implements Transaccion {

    @Override
    public void noOk() {
        System.out.println("La consulta fue imposible de realizar!!!"); 
    }

    @Override
    public void ok() {
        System.out.println("La consulta se realizo correctamente."); 
    }
    
}
