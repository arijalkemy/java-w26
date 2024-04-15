package punto1;

public class Deposito implements Transaccion{
    public void realizarDeposito(){
        System.out.println("Realizandose el deposito");
    }

    @Override
    public void transaccionOk() {
        System.out.println("Deposito realizado correctamente");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Deposito no ha sido realizado");
    }
}
