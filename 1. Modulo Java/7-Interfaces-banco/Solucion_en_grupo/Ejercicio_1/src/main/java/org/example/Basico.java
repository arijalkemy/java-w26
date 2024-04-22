package org.example;

public class Basico extends Cliente{
    public Basico(String nombre_apellido) {
        super(nombre_apellido);
    }

    public void depositar() {

    }

    public void transferir() {

    }

    @Override
    public void consultar_saldo() {
        System.out.println(super.nombre_apellido + "Hizo una consulta de saldo");
    }

    @Override
    public void pagar_servicio() {
        System.out.println(super.nombre_apellido + "Hizo un pago de servicio");
    }

    @Override
    public void retirar_efectivo() {
        System.out.println(super.nombre_apellido + "Hizo un retiro de efectivo");
    }
}
