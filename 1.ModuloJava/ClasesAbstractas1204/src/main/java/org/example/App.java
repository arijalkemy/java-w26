package org.example;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    public App() {
    }

    public static void main(String[] args) {
       Scanner scn = new Scanner(System.in);
       SumarDos sumDos = new SumarDos(1, 0);
       RestarVeinte rveinte = new RestarVeinte(1, 0.0);
       MultiplicarPorTres mtres = new MultiplicarPorTres(1, 3.0);
       int opc = 0;
       do {
          opc = mostrarMenu();
           System.out.println("Clase pre cargada:");
          switch (opc) {
             case 1:
                 System.out.println(sumDos.toString());
                break;
             case 2:
                 System.out.println(rveinte.toString());
                break;
             case 3:
                 System.out.println(mtres.toString());
          }
          System.out.println("presione enter para contuinar");
           scn.nextLine();

          int opcmenudos = 0;
          if (opc != 4) {
             do {
                opcmenudos = verMenuSerie();
                switch (opcmenudos) {
                   case 1:
                      System.out.println("ingrese cuantas veces quiere realizar la serie");
                      int v = scn.nextInt();
                      if (opc == 1) {
                         sumDos.ejercutarnVeces(v);
                      } else if (opc == 2) {
                         rveinte.ejercutarnVeces(v);
                      } else {
                         mtres.ejercutarnVeces(v);
                      }
                      break;
                   case 2:
                      if (opc == 1) {
                         sumDos.reiniciar();
                         System.out.println(sumDos.toString());
                      } else if (opc == 2) {
                         rveinte.reiniciar();
                         System.out.println(rveinte.toString());
                      } else {
                         mtres.reiniciar();
                         System.out.println(rveinte.toString());
                      }
                      break;
                   case 3:
                      if (opc == 1) {
                         System.out.println("El siguiente valor de la serie es" + String.valueOf(sumDos.siguienteValor()));
                      } else if (opc == 2) {
                         System.out.println("El siguiente valor de la serie es" + String.valueOf(rveinte.siguienteValor()));
                      } else {
                         System.out.println("El siguiente valor de la serie es" + String.valueOf(mtres.siguienteValor()));
                      }
                }

                System.out.println("presione enter para contuinar");
                scn.nextLine();
             } while(opcmenudos != 4);
          }
       } while(opc != 4);

    }

    public static int mostrarMenu() {
       Scanner scan = new Scanner(System.in);
       System.out.println("***** Bootcamp Java 12/04 Turno Ma\u00f1ana*****");
       System.out.println("1) Ejecutar Serie de sumar 2 (Enteros)");
       System.out.println("2) Ejecutar Serie de restar 20.8 (Double)");
       System.out.println("3) Ejecutar Serie de multiplicar por 3 (double)");
       System.out.println("4) Salir");
       System.out.println("Elija una opcion: ");
       return scan.nextInt();
    }

    public static int verMenuSerie() {
       Scanner scan = new Scanner(System.in);
       System.out.println("*****************"+ "Menu de serie" +"*****************");
       System.out.println("1) Ejecutar x veces");
       System.out.println("2) reiniciar");
       System.out.println("3) Siguiente valor");
       System.out.println("4) volver al menu principal");
       System.out.println("Elija una opcion: ");
       return scan.nextInt();
    }
 }
