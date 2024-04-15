package ClasesAbstractasInterfaces.Banco.transaccion;

public interface RealizarDeposito extends Transaccion {
    default void realizarDeposito(double saldo, boolean estado){
        System.out.println(estado ? "Su deposito por: " + saldo + " ha sido exitoso" : "El depisto ha sido  fallido");
    };
}
