package org.example;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        int opc;
        do{
           opc = Menu.mostrarMenu();
           switch (opc){
               case 1:
                   Menu.ejercicioUno();
                   break;
               case 2:
                   Menu.ejercicioDos();
                   break;
               case 3:
                   System.out.println("Gracias por usar el programa");
                   break;
               default:
                   System.out.println("Elija una opcion correcta");
           }

        }while (opc!=3);
    }
}
