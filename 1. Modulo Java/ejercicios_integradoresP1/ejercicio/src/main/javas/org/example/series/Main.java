package org.example.series;

import java.util.Scanner;

public class Main {
    static Scanner teclado = new Scanner(System.in);
    public static void main(String [] args){
        int menu, subMenu;
        Integer valorInicial, valorSerie;
        Double valorInicialD, valorSerieD;
        Float valorInicialF, valorSerieF;
        Prototipo serie;
        do{
            menu = mainMenu();
            switch (menu){
                case 1:
                    System.out.println("Ingrese un valor incial para la serie: ");
                    valorInicial= teclado.nextInt();
                    System.out.println("Ingrese el valor de serie: ");
                    valorSerie=teclado.nextInt();
                    serie= new SerieInt(valorInicial,valorSerie);
                    break;
                case 2:
                    System.out.println("Ingrese un valor incial para la serie: ");
                    valorInicialD= teclado.nextDouble();
                    System.out.println("Ingrese el valor de serie: ");
                    valorSerieD=teclado.nextDouble();
                    serie=new SerieDouble(valorInicialD,valorSerieD);
                    break;
                case 3:
                    System.out.println("Ingrese un valor incial para la serie: ");
                    valorInicialF= teclado.nextFloat();
                    System.out.println("Ingrese el valor de serie: ");
                    valorSerieF=teclado.nextFloat();
                    serie=new SerieFloat(valorInicialF,valorSerieF);
                    break;
                default:
                    System.out.println("Saliendo del programa");
                    return;
            }
            do {
                subMenu=subMenu();
                switch (subMenu){
                    case 1:
                        serie.valorSiguiente();
                        System.out.println("El siguiente valor de la serie es: "+serie.valorActual);
                        break;
                    case 2:
                        System.out.println("Ingresa el numero de veces que deseas ejecutar la serie: ");
                        serie.ejecutarNVeces(teclado.nextInt());
                        break;
                    case 3:
                        serie.resetear();
                        System.out.println("Valor inicial de la serie reiniciada");
                        break;
                    default:
                        break;
                }
            }while (subMenu<4);
        }while (menu<4);


    }
    public static int mainMenu (){
        int opcion=0;
        System.out.println("----- M E N Ú  P R I N C I P A L ----");
        System.out.println("Selecciona un tipo de dato para la serie");
        System.out.println("1. Intiger");
        System.out.println("2. Double");
        System.out.println("3. Float");
        System.out.println("4. Salir");
        opcion= teclado.nextInt();
        if(opcion<=0 || opcion>4){
            return mainMenu();
        }
        return opcion;
    }
    public  static  int subMenu(){
        int opcion=0;
        System.out.println("----- M E N Ú  S E R I E S -----");
        System.out.println("Seleccione una opción");
        System.out.println("1. Obtener el siguiente valor de la serie");
        System.out.println("2. Obtener los siguientes n valores de series");
        System.out.println("3. Reiniciar la serie");
        System.out.println("4. Salir al menú principal");
        opcion=teclado.nextInt();
        if (opcion<=0 || opcion>4){
            return subMenu();
        }
        return opcion;
    }

}
