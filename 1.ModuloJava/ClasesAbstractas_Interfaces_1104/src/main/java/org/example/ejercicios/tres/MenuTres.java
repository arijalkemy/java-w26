package org.example.ejercicios.tres;

import org.example.ejercicios.tres.clases.Gato;
import org.example.ejercicios.tres.clases.Perro;
import org.example.ejercicios.tres.clases.Vaca;

import java.util.Scanner;

public class MenuTres {

    public static void ejercicio(){
        Scanner scan = new Scanner(System.in);
        int opc=0;
        Gato gato = new Gato("Garfield", "naranja");
        Perro perro = new Perro("Morena", "negro");
        Vaca vaca = new Vaca("Luffy", "blanco y negro");
        do {
            System.out.println("***** Animales que comen y que ruido hacen *****");
            System.out.println("1) Ejecutar con Vaca");
            System.out.println("2) Ejecutar con Gato");
            System.out.println("3) Ejecutar con Perro");
            System.out.println("4) volver a menu principal");
            System.out.println("Elija una opcion: ");
            opc= scan.nextInt();
            switch (opc){
                case 1:
                    System.out.println(perro.toString());
                    perro.comerCarne();
                    System.out.println("El perro hace :");
                    perro.hacerRuido();
                    break;
                case 2:
                    System.out.println(gato.toString());
                    gato.comerCarne();
                    System.out.println("El gato hace :");
                    gato.hacerRuido();
                    break;
                case 3:
                    System.out.println(vaca.toString());
                    vaca.comerPlantas();
                    System.out.println("La vaca hace :");
                    vaca.hacerRuido();
                    break;
                case 4:
                    System.out.println("Volviendo a principal");
                    break;
                default:
                    System.out.println("Ingrese opcion valida");
            }
            System.out.println("Oprima enter para contuinar");
            scan.nextLine();
            scan.nextLine();
        }while (opc!=4);
    }

}
