package org.example;

import org.example.ejercicios.dos.MenuDos;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App
{

    public static void main( String[] args )
    {
        Scanner scan  = new Scanner(System.in);
        int opc=0;
        do {
        opc= mostrarMenu();
        switch (opc){
            case 1 :
                System.out.println("op1");
                scan.nextLine();
                break;
            case 2 :
                MenuDos.mostrar();
                scan.nextLine();
                break;
            case 3 :
                System.out.println("op3");
                scan.nextLine();
                System.out.println("Apriete enter para continuar");
                break;
            case 4 :
                System.out.println("Gracias por usar el programa");
                break;
            default:
                System.out.println("Por favor ingrese una opcion valida");
        }

        }while (opc!=4);

    }
    public static int mostrarMenu(){
        Scanner scan = new Scanner(System.in);
        System.out.println("***** Bootcamp Java 11/04 *****");
        System.out.println("1) Ejecutar primer ejercicio");
        System.out.println("2) Ejecutar segundo ejercicio (INTERFAZ IMPRIMIBLE)");
        System.out.println("3) Ejecutar tercer ejercicio");
        System.out.println("4) Salir");
        System.out.println("Elija una opcion: ");
        return scan.nextInt();
    }

}
