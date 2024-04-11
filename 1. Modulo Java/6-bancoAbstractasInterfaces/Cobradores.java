public class Cobradores extends Cliente implements ITransaccion {
    public Cobradores() {
        nombre = "Cobrador";
    }

    public void transaccionOK() {
        System.out.println("... transaccion realizada.");
        System.out.println();
    }

    public void transaccionNoOk() {
        System.out.println("... transaccion realizada.");
        System.out.println();
    }

    @Override
    public void depositar() {
        System.out.println(nombre);
        super.depositar();
        transaccionNoOk();
    }

    @Override
    public void transferir() {
        System.out.println(nombre);
        super.transferir();
        transaccionNoOk();
    }

    @Override
    public void consultar() {
        System.out.println(nombre);
        super.consultar();
        transaccionOK();
    }

    @Override
    public void pagar() {
        System.out.println(nombre);
        super.pagar();
        transaccionNoOk();
    }

    @Override
    public void retirar() {
        System.out.println(nombre);
        super.retirar();
        transaccionOK();
    }
}
