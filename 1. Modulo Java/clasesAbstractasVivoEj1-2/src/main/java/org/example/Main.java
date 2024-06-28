package org.example;

import org.example.ejer2.Curriculum;
import org.example.ejer2.Ejer2;
import org.example.ejer2.Informe;
import org.example.ejer2.PDF;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        /* EJERCCIO 1 */
        // Operaciones Ejecutivo
//        UserEjecutive ejecutive = new UserEjecutive();
//        ejecutive.hacerDeposito();
//        ejecutive.realizarTransferencia();
//
//        // Operaciones basic
//        UserBasic basic = new UserBasic();
//        basic.realizarConsultaSaldo();
//        basic.realizarRetiro();
//        basic.realizarPagoServicios();
//
//        // Operaciones cobrador
//        UserCobrador cobrador = new UserCobrador();
//        cobrador.realizarRetiro();
//        cobrador.realizarConsultaSaldo();}

        /* EJERCICIO 2 */
        Curriculum curr = new Curriculum("Luis", new ArrayList<>());
        PDF pdf = new PDF(12, "Autor", "Titulo", "Comedia");
        Informe informe = new Informe(120, 12, "Autor", "Revisor");

        Ejer2.impresion(curr);
        Ejer2.impresion(pdf);
        Ejer2.impresion(informe);
    }
}

