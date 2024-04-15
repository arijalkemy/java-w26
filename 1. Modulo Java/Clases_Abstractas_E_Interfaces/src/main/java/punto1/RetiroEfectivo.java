package punto1;

public class RetiroEfectivo implements Transaccion{
    public void realizarRetiro(){
        System.out.println("Realizando retiro de efeciivo");
    }
    @Override
    public void transaccionOk(){
        System.out.println("Retiro efectivo");
    }
    @Override
    public void transaccionNoOk(){
        System.out.println("Retiro en efectivo fallido");
    }
}
