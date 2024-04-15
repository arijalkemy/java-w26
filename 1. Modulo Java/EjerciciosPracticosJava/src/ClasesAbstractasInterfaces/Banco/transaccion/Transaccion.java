package ClasesAbstractasInterfaces.Banco.transaccion;

public interface Transaccion {
    static boolean transaccionOk(){return true;};
    static boolean transaccionNoOk(){return false;};
}
