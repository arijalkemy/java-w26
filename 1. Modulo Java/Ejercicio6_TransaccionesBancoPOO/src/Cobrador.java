//Clase implementadora
public class Cobrador implements Transaccion {
    private String nombre;
    private String documento;
    private String numeroCuenta;
    private int saldo;
    private boolean estado;

    //Metodo consultar saldo del cliente cobrador
    public void consultarSaldo(){
        if(this.estado){
            System.out.println("validando información...");
            System.out.println("Realizando el deposito...");
            System.out.println("Esperando respuesta del servidor...");
            this.transaccionOk();
        }else{
            System.out.println("validando información...");
            System.out.println("Realizando el deposito...");
            System.out.println("Esperando respuesta del servidor...");
            this.transaccionNoOk();
        }
    }
    //metodo retirar efectivo del cliente cobrador
    public void retirarEfectivo(int monto){
        if(this.saldo>monto){
            System.out.println("validando información...");
            System.out.println("Realizando la transferencia...");
            System.out.println("Esperando respuesta del servidor...");
            this.transaccionOk();
        }else {
            System.out.println("validando información...");
            System.out.println("Realizando la transferencia...");
            System.out.println("Esperando respuesta del servidor...");
            this.transaccionNoOk();
        }
    }
    //Metodos implementados con la misma firma del metodo de la interface
    @Override
    public void transaccionOk() {
        System.out.println("Cobrador: La transacción se realizo con exito");
    }
    //setters y Getters
    @Override
    public void transaccionNoOk() {
        System.out.println("Cobrador: La transacción ha sido rechazada");
    }

    public String getNombre() {
        return nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public int getSaldo() {
        return saldo;
    }

    public boolean isEstado() {
        return estado;
    }
}
