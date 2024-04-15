package punto1;

public class ConsultaSaldo implements Transaccion{
    public void consultarSaldo(){
        System.out.println("Consultando saldo");
    }

    @Override
    public void transaccionOk() {
        System.out.println("Se consultó el saldo");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se ha podido consultar saldo");
    }
}
