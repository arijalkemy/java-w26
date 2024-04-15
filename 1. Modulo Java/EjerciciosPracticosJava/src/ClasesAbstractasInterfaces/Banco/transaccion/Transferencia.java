package ClasesAbstractasInterfaces.Banco.transaccion;

public interface Transferencia extends Transaccion{
    default void estadoTransaccion(boolean estado){
        System.out.println("La transferencia fue" + (estado ? " exitosa" : " fallida"));
    };
}
