package org.example;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        //ejercicios 1 y 2
        Persona personaSinPeso = new Persona("Manuel",20, "33333333");
        Persona personaParametros = new Persona("juan",21,"44645369",75.4,1.72);

        Scanner scan = new Scanner(System.in);
        int opc;

        do {
            System.out.println( "***** CALCULAR IMC Y MAYORIA DE EDAD *****" );
            System.out.println( "Opcion 1) cargar persona por teclado" );
            System.out.println( "Opcion 2) Usar Persona cargada en el sistema" );
            System.out.println( "Opcion 3) Usar Persona cargada en el sistema sin altura ni peso" );
            System.out.println( "Opcion 4) salir" );
            System.out.println( "Elija una opcion" );
            opc = scan.nextInt();
            scan.nextLine();
            switch (opc){
                case 1:
                    System.out.println( "Ingrese Nombre:" );
                    String nom = scan.nextLine();
                    System.out.println( "Ingrese edad:" );
                    int edad = scan.nextInt();
                    scan.nextLine();
                    System.out.println( "Ingrese DNI:" );
                    String dni = scan.nextLine();
                    System.out.println( "Ingrese Peso en kilogramos: (puede dejarlo en 0)" );
                    double peso = scan.nextDouble();
                    scan.nextLine();
                    System.out.println( "Ingrese altura en metros: (puede dejarlo en 0) ");
                    double altura = scan.nextDouble();
                    scan.nextLine();
                    Persona personaIngresada = new Persona(nom, edad,dni,peso,altura);
                    System.out.println( "Persona ingresada:" );
                    System.out.println(personaIngresada.toString());
                    System.out.println( "------------------------" );
                    personaIngresada.mostrarPesoyEdad();
                    System.out.println( "Presione enter para contuinar" );
                    scan.nextLine();
                    break;

                case 2:
                    personaParametros.mostrarPesoyEdad();
                    break;
                case 3:
                    personaSinPeso.mostrarPesoyEdad();
                    break;
                case 4:
                    System.out.println( "Gracias por usar el programa, adios." );
                    break;
                default:
                    System.out.println( "Opcion incorrecta elija una opcion del 1 al 3" );
            }
        }while(opc!=4);


    }

}
