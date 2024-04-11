package org.example;

/**
 * Hello world!
 *
 */
import java.util.List;
import java.util.ArrayList;
public class App
{
    public static void main( String[] args )
    {
        //EJERCICIO 1

        //BASIC
        System.out.println("BASIC: ");
        ITransaccion transaccionBasic = new ConsultaDeSaldo();
        Basic basic = new Basic();
        basic.consultarSaldo(transaccionBasic);
        transaccionBasic = new PagoDeServicio();
        basic.pagoServicios(transaccionBasic);
        transaccionBasic = new RetiroEnEfectivo();
        basic.retiroEfectivo(transaccionBasic);

        //COBRADOR
        System.out.println("COBRADOR: ");
        ITransaccion transaccionCobrador = new ConsultaDeSaldo();
        Cobrador cobrador = new Cobrador();
        cobrador.consultarSaldo(transaccionCobrador);
        transaccionCobrador = new RetiroEnEfectivo();
        cobrador.retiroEnEfectivo(transaccionCobrador);

        //EJECUTIVO
        System.out.println("EJECUTIVO: ");
        ITransaccion transaccionEjecutivo = new Deposito();
        Ejecutivo ejecutivo = new Ejecutivo();
        ejecutivo.deposito(transaccionEjecutivo);
        transaccionEjecutivo = new Transferencia();
        ejecutivo.transferencia(transaccionEjecutivo);



        //EJERCICIO 2
        List<String> habilidades = new ArrayList<>();
        habilidades.add("ninguna");

        IImprimible interfazCurriculum = new Curriculum("Marcos", "Bellotti", 45332233, habilidades);
        interfazCurriculum.imprimir();

        IImprimible interfazLibro = new LibroEnPDF(22,"Pedro","Libro", "Literario");
        interfazLibro.imprimir();

        IImprimible interfazInforme = new Informe(22,"Jorge", "Julian", "Texto");
        interfazInforme.imprimir();

        //EJERCICIO 3





    }
}
