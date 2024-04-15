package ClasesAbstractasInterfaces.Banco.transaccion;

public interface ConsultaDeSaldo extends Transaccion {
    default void consultaDeSaldo (double saldo, boolean estado){
        System.out.println(estado ? "Su saldo es: " + saldo : "Consulta de saldo fallida");
    }
}
