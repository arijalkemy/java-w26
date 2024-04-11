public class Deposito implements Transaccion{
    @Override
    public void TransaccionOK() {
        System.out.println("Deposito exitoso");
    }

    @Override
    public void TransaccionNoOk() {
        System.out.println("El deposito falló");
    }
}
