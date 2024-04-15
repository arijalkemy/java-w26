package ClasesAbstractasInterfaces.Banco.cliente;

import ClasesAbstractasInterfaces.Banco.transaccion.ConsultaDeSaldo;
import ClasesAbstractasInterfaces.Banco.transaccion.PagarServicio;
import ClasesAbstractasInterfaces.Banco.transaccion.RetiroDeEfectivo;

public class Basic extends Cliente implements ConsultaDeSaldo, PagarServicio, RetiroDeEfectivo {
    public Basic() {
    }
}
