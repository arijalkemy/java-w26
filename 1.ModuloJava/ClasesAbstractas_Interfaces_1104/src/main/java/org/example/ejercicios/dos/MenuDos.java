package org.example.ejercicios.dos;

import org.example.ejercicios.dos.clases.Curriculum;
import org.example.ejercicios.dos.clases.Informe;
import org.example.ejercicios.dos.clases.Libro;

import java.util.Scanner;

public class MenuDos {
    public static void mostrar (){
        String[] habilidades = {"Programación en Java", "Desarrollo web", "Análisis de datos"};

        Curriculum cv = new Curriculum("Juan Pérez", habilidades);
        Libro libro = new Libro("Ficción", 300, "El Señor de los Anillos", "J.R.R. Tolkien");
        Informe informe = new Informe("Informe sobre el cambio climático", 10, "Impacto del cambio climático en la biodiversidad", "Dr. Juan Pérez", "Dra. María Gómez");
        int opc = 0;
        do{
            Scanner scan = new Scanner(System.in);
            System.out.println("***** Ejercicio dos *****");
            System.out.println("1) imprimir libro cargado" );
            System.out.println("2) imprimir curriculum cargado");
            System.out.println("3) imprimr informe cargado");
            System.out.println("4) Volver a menu principal");
            System.out.println("Elija una opcion: ");
            opc = scan.nextInt();
            scan.nextLine();
            switch (opc){
                case 1:
                    libro.imprimir();
                    break;
                case 2:
                    cv.imprimir();
                    break;
                case 3:
                    informe.imprimir();
                    break;
                case 4:

                    break;
                default:
                    System.out.println("Ingrese una opcion valida");
            }
            System.out.println("Ingrese enter para continuar");

            scan.nextLine();
        }while(opc!=4);
    }
}
