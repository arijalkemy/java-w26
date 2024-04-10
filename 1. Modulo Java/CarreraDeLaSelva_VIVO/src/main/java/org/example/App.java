package org.example;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Inscripcion inscripcion = new Inscripcion();
        Scanner teclado = new Scanner(System.in);
        boolean salir = true;
        while(salir){
            System.out.println("1. Inscribir participante");
            System.out.println("2. Inscribir aleatorios");
            System.out.println("3. Listar participantes");
            System.out.println("4. Desinscribir participante");
            System.out.println("5. Salir");
            int opcion = teclado.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Enter DNI: ");
                    String error = teclado.nextLine();
                    String dni = teclado.nextLine();

                    System.out.println("Enter Nombre: ");
                    String nombre = teclado.nextLine();

                    System.out.println("Enter Apellido: ");
                    String apellido = teclado.nextLine();

                    System.out.println("Enter Edad: ");
                    int edad = teclado.nextInt();
                    teclado.nextLine();

                    System.out.println("Enter Celular: ");
                    String celular = teclado.nextLine();

                    System.out.println("Enter Celular de emergencia: ");
                    String celularEmergencia = teclado.nextLine();

                    System.out.println("Enter Grupo Sanguineo: ");
                    String grupoSanguineo = teclado.nextLine();

                    int categoria = 0;
                    do{
                        System.out.println("Enter Categoria: ");
                        System.out.println("1. Circuito chico");
                        System.out.println("2. Circuito mediano");
                        System.out.println("3. Circuito grande");
                        categoria = teclado.nextInt();
                    }while (categoria < 1 || categoria > 3);

                    Participante participante = new Participante(dni, nombre, apellido, edad, celular, celularEmergencia, grupoSanguineo);
                    int responseM = inscripcion.inscribirse(participante, categoria);
                    if (responseM == -1){
                        System.out.println("No se pudo inscribir a " + participante.nombre + " en la categoria " + categoria);
                    }else{
                        System.out.println("Se inscribió a " + participante.nombre + " en la categoria " + categoria);
                    }
                    break;
                case 2:
                    for (int i = 0; i < 9; i++) {
                        Participante pTemp = new Participante(""+(12345678+i), "Juan", "Perez", 20, "099123456", "099123456", "O+");
                        int response = inscripcion.inscribirse(pTemp, ((i%3)+1));
                        if (response == -1){
                            System.out.println("No se pudo inscribir a " + pTemp.nombre + " en la categoria " + ((i%3)+1));
                        }else{
                            System.out.println("Se inscribió a " + pTemp.nombre + " en la categoria " + ((i%3)+1));
                        }
                    }
                    break;
                case 3:
                    System.out.println("Seleccione una categoria");
                    System.out.println("1. Circuito chico");
                    System.out.println("2. Circuito mediano");
                    System.out.println("3. Circuito grande");
                    int categoriaL = teclado.nextInt();
                    ArrayList<String> inscritosCategoria = inscripcion.listarParticipantes(categoriaL);
                    System.out.println(inscritosCategoria);
                    break;
                case 4:
                    System.out.println("Ingrese el numero de incripcion: ");
                    int noIncripcion = teclado.nextInt();
                    int responseDesinscripcion = inscripcion.desinscribir(noIncripcion);
                    if(responseDesinscripcion == -1){
                        System.out.println("No se pudo desinscribir a la persona");
                    }else{
                        System.out.println("Se desinscribio a la persona");
                        ArrayList<String> inscritosRestantes = inscripcion.listarParticipantes(responseDesinscripcion);
                        System.out.println(inscritosRestantes);
                    }
                    break;
                case 5:
                    salir = false;
                    break;
            }
        }

    }
}
