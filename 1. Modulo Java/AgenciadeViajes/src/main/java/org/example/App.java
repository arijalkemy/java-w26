package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       Cliente paco = new Cliente(123,"Francisco","Puente",40);
       Localizador localizador= new Localizador(paco);
       localizador.agregarReserva(new Reserva("Hotel",100));
       localizador.agregarReserva(new Reserva("Comida",90));
       localizador.agregarReserva(new Reserva("BoletoViaje",80));
       localizador.agregarReserva(new Reserva("Transporte",70));
       localizador.calcularTotal();
       localizador.aplicarDescuento();
       System.out.println(localizador.toString());

    }
}
