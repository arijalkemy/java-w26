package ClasesAbstractasInterfaces.Banco.cliente;

import ClasesAbstractasInterfaces.Banco.transaccion.ConsultaDeSaldo;
import ClasesAbstractasInterfaces.Banco.transaccion.RetiroDeEfectivo;

public class Cobrador extends Cliente implements RetiroDeEfectivo, ConsultaDeSaldo {
    public Cobrador() {
    }
}
