package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Categoria circuitoChico= new Categoria(1,TipoCategoria.CIRCUITOCHICO,"Circuito chico","2 km por selva y arroyos.");
        Categoria circuitoMedio= new Categoria(2,TipoCategoria.CIRCUITOMEDIO,"Circuito medio","5 km por selva, arroyos y barro.");
        Categoria circuitoAvanzado= new Categoria(3,TipoCategoria.CIRCUITOAVANZADO,"Circuito avanzado","10 km por selva, arroyos, barro y escalada en piedra.");
        long contador=1;
        Participante participante;
        Scanner scanner = new Scanner(System.in);
        int opcion;
        Inscripcion inscripcion= new Inscripcion();
        List<Inscripcion> inscripciones=new ArrayList<>();

        do {
            System.out.println("Menú de Opciones");
            System.out.println("1. Ingresar datos del participante a inscribir");
            System.out.println("2. Mostrar los participantes inscriptos a una categoría");
            System.out.println("3. Desinscribir a un participante");
            System.out.println("4. Calcular los montos totales recaudados");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    participante= ingresarDatos(scanner);
                    do{
                        System.out.println("Seleccione el circuito al que lo quiere inscribir");
                        System.out.println("Menú de Circuitos");
                        System.out.println("1. Circuito chico: 2 km por selva y arroyos.");
                        System.out.println("2. Circuito medio: 5 km por selva, arroyos y barro.");
                        System.out.println("3. Circuito avanzado: 10 km por selva, arroyos, barro y escalada en piedra.");
                        System.out.println("4. Salir");
                        System.out.print("Seleccione una opción: ");
                        opcion = scanner.nextInt();

                        switch (opcion) {
                            case 1:
                                contador++;
                                inscripcion=new Inscripcion(contador,circuitoChico,participante);
                                System.out.println(inscripcion);
                                opcion=4;
                                break;
                            case 2:
                                contador++;
                                inscripcion=new Inscripcion(contador,circuitoMedio,participante);
                                System.out.println("Has elegido el Circuito medio: 5 km por selva, arroyos y barro.");
                                System.out.println(inscripcion);
                                opcion=4;
                                break;
                            case 3:
                                if(puedeInscribirse(participante)){
                                    System.out.println("Has elegido el Circuito avanzado: 10 km por selva, arroyos, barro y escalada en piedra.");
                                    contador++;
                                    inscripcion=new Inscripcion(contador,circuitoAvanzado,participante);
                                    System.out.println(inscripcion);
                                    opcion=4;
                                }else{
                                    System.out.println("El participante no puede inscribirse a este circuito, debe ser mayor");
                                }
                                break;
                            case 4:
                                System.out.println("Saliendo al menú principal...");
                                break;
                            default:
                                System.out.println("Opción inválida. Por favor, seleccione nuevamente.");
                                break;
                        }
                    }while (opcion!=4);
                    if(inscripcion!=null){
                        inscripciones.add(inscripcion);
                    }
                    break;
                case 2:
                    System.out.println("Elija el circuito a filtrar");
                    System.out.println("1. Circuito chico: 2 km por selva y arroyos.");
                    System.out.println("2. Circuito medio: 5 km por selva, arroyos y barro.");
                    System.out.println("3. Circuito avanzado: 10 km por selva, arroyos, barro y escalada en piedra.");
                    opcion = scanner.nextInt();
                    int finalOpcion = opcion;
                    inscripciones= inscripciones.stream().
                            filter(i-> i.getCategoria().getTipoCategoria().equals(TipoCategoria.values()[finalOpcion +1] )).toList();
                    inscripciones.forEach(i->i.toString());

                    break;

                case 3:
                    System.out.println("Ingrese el nro de participante a desinscribir");
                    long nroParticipante = scanner.nextInt();
                    inscripciones= inscripciones.stream().filter(i-> i.getParticipante().getNroParticipante()!= nroParticipante)
                            .toList();
                    inscripciones.forEach(i->i.toString());
                    break;

                    case 4:

                        System.out.println("Monto recaudado categoría Circuito chico");
                        double montoTotalCC= inscripciones.stream().
                                filter(i-> i.getCategoria().getTipoCategoria().equals(TipoCategoria.CIRCUITOCHICO ))
                                .toList().stream().mapToDouble(Inscripcion::calcularMontoTotal)
                                .sum();
                        System.out.println("$"+ montoTotalCC);
                        System.out.println("Monto recaudado categoría Circuito medio");
                        double montoTotalCM= inscripciones.stream().
                                filter(i-> i.getCategoria().getTipoCategoria().equals(TipoCategoria.CIRCUITOMEDIO ))
                                .toList().stream().mapToDouble(Inscripcion::calcularMontoTotal)
                                .sum();
                        System.out.println("$"+ montoTotalCM );
                        System.out.println("Monto recaudado categoría Circuito Avanzado");
                        double montoTotalCA= inscripciones.stream().
                                filter(i-> i.getCategoria().getTipoCategoria().equals(TipoCategoria.CIRCUITOAVANZADO))
                                .toList().stream().mapToDouble(Inscripcion::calcularMontoTotal)
                                .sum();
                        System.out.println("$"+ montoTotalCA);
                        System.out.println("Monto recaudado en total es: ");
                        double montoTotal= inscripciones.stream().mapToDouble(Inscripcion::calcularMontoTotal)
                                .sum();
                        System.out.println("$"+ montoTotal );

                        break;

                default:
                    System.out.println("Opción inválida. Por favor, seleccione nuevamente.");
                    break;
            }
        } while (opcion != 5);

        scanner.close();
    }
    public static boolean  puedeInscribirse(Participante participante){
        boolean puedeInscribirse= false;
        if(participante.esMayor()){
            puedeInscribirse=true;
        }
        return puedeInscribirse;
    }



    public static Participante ingresarDatos(Scanner scanner) {
        System.out.println("Ingrese los datos del participante:");

        System.out.print("Número de participante: ");
        int numeroParticipante = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del salto de línea

        System.out.print("DNI: ");
        String dni = scanner.nextLine();

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();

        System.out.print("Edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del salto de línea

        System.out.print("Celular: ");
        String celular = scanner.nextLine();

        System.out.print("Número de emergencia: ");
        String numeroEmergencia = scanner.nextLine();

        System.out.print("Grupo sanguíneo: ");
        String grupoSanguineo = scanner.nextLine();
        Participante participante= new Participante(numeroParticipante,Long.parseLong(dni),nombre,apellido,edad,celular,numeroEmergencia,grupoSanguineo);
        return participante;
    }
}
