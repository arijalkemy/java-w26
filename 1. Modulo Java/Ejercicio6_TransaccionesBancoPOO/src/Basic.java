//Clase implementadora
public class Basic implements Transaccion{
    //atributos propios
    private String nombre;
    private String documento;
    private String numeroCuenta;
    private int saldo;
    private boolean estado;

    //metodo para calcular saldo
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

    //Metodo para pagar servicios
    public void pagoServicios(int monto){
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
    //metodo para retirar en efectivo
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
        System.out.println("Basic: La transacción se realizo con exito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Basic: La transacción ha sido rechazada");
    }

    //Setters y Getters
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
