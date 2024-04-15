package ClasesAbstractasInterfaces.Banco.transaccion;

public interface PagarServicio extends Transaccion {
    default void pagarServicio(boolean estado){
        System.out.println("El pago fue" + (estado ? " exitoso" : " fallido"));
    };
}
