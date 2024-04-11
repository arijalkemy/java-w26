public class ConsultaDeSaldo implements Transaccion {

    @Override
    public void TransaccionOK() {
        System.out.println("Consulta de saldo correcta");
    }

    @Override
    public void TransaccionNoOk() {
        System.out.println("Fallo la consulta de saldo");
    }
}
