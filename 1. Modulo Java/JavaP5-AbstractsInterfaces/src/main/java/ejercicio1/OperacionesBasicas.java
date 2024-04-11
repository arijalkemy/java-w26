package ejercicio1;

public abstract class OperacionesBasicas {
    double saldo;

    public OperacionesBasicas(double saldo) {
        this.saldo = saldo;
    }

    public void retiroEfectivo(double cantidad) {
        System.out.println("Retiro de " + cantidad);
    }

    public void consultaDeSaldo() {
        System.out.println("Tu saldo es " + this.saldo );
    }

}
