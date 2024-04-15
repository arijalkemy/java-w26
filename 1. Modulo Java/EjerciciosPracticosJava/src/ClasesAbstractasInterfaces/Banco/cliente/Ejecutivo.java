package ClasesAbstractasInterfaces.Banco.cliente;

import ClasesAbstractasInterfaces.Banco.transaccion.RealizarDeposito;
import ClasesAbstractasInterfaces.Banco.transaccion.Transferencia;

public class Ejecutivo extends Cliente implements RealizarDeposito, Transferencia {
    public Ejecutivo() {
    }
}
