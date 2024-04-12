package Transacciones;

public class TrPagarServicios implements Transaccion {

    @Override
    public void noOk() {
        System.out.println("No fue posible realizar el pago, valide:");
        System.out.println("- Su saldo");
        System.out.println("- Identificador del servicio");
    }

    @Override
    public void ok() {
        System.out.println("El servicio se pago correctamente."); 
    }

}
