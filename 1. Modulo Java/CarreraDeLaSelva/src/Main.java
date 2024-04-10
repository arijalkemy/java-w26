import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static java.util.Map.entry;

public class Main {
    public static void main(String[] args) {
        // VERSIÓN SIN CLASES, SOLO CON MAP Y VECTORES
        try {
            Map<Integer, String[]> mapCircuitos = Map.of(
                    1, new String[]{"Circuito chico", "2 km por selva y arroyos."},
                    2, new String[]{"Circuito medio", "5 km por selva, arroyos y barro."},
                    3, new String[]{"Circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra."}
            );
            int categoria = 1;
            double monto = 0;
            int participante = 0;
            Map<Integer, String[]> mapInscripciones = new HashMap<>();
            Map<Integer, String[]> mapParticipantes = new HashMap<>();
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("seleccione una opción: ");
                System.out.println("1. Suscribir participante");
                System.out.println("2. Inscribir participante");
                System.out.println("3. Desinscribir participante");
                System.out.println("4. Ver participantes por categoria");
                System.out.println("5. Ver Recaudo por categoria");
                System.out.println("6. Salir");
                int opcion = scanner.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese el dni");
                        String dni = scanner.next();
                        System.out.println("Ingrese el nombre");
                        String nombre = scanner.next();
                        System.out.println("Ingrese el apellido");
                        String apellido = scanner.next();
                        System.out.println("Ingrese el numero de telefono");
                        String telefono = scanner.next();
                        System.out.println("Ingrese el numero de telefono de emergencia");
                        String telefonoEmergencia = scanner.next();
                        System.out.println("Ingrese la edad");
                        int edad = scanner.nextInt();
                        System.out.println("Ingrese el grupo sanguineo");
                        String grupoSanguineo = scanner.next();
                        System.out.println("¿En cuál categoría lo desea suscribir?");
                        for (Map.Entry<Integer, String[]> entry : mapCircuitos.entrySet()) {
                            System.out.println(entry.getKey() + " " + entry.getValue()[0]);
                        }
                        categoria = scanner.nextInt();
                        if (categoria < 1 || categoria > 3) {
                            System.out.println("No existe la categoría ingresada");
                            continue;
                        }
                        monto = 0;
                        if (categoria == 1) monto = edad < 18 ? 1300 : 1500;
                        if (categoria == 2) monto = edad < 18 ? 2000 : 2300;
                        if (categoria == 3) {
                            if (edad < 18) {
                                System.out.println("No se pueden inscribir menores a la categoría");
                                continue;
                            }
                            monto = 2800;
                        }
                        mapParticipantes.put(mapParticipantes.size() + 1, new String[]{dni, Integer.toString(edad), nombre, apellido, telefono, telefonoEmergencia, grupoSanguineo});
                        mapInscripciones.put(mapParticipantes.size(), new String[]{Integer.toString(mapInscripciones.size()), Integer.toString(categoria), Double.toString(monto)});
                        System.out.println("Número de participante: " + mapParticipantes.size());
                        break;

                    case 2:
                        if (mapParticipantes.size() == 0) {
                            System.out.println("No hay participantes para inscribir");
                            continue;
                        }
                        System.out.println("Seleccione un participante: ");
                        for (Map.Entry<Integer, String[]> entry : mapParticipantes.entrySet()) {
                            System.out.println(entry.getKey() + " " + entry.getValue()[2] + " " + entry.getValue()[3]);
                        }
                        participante = scanner.nextInt();
                        if (!mapParticipantes.containsKey(participante)) {
                            System.out.println("No existe participante con el id " + participante);
                            continue;
                        }
                        System.out.println("¿En cuál categoría lo desea suscribir?");
                        for (Map.Entry<Integer, String[]> entry : mapCircuitos.entrySet()) {
                            System.out.println(entry.getKey() + " " + entry.getValue()[0]);
                        }
                        categoria = scanner.nextInt();
                        if (categoria < 1 || categoria > 3) {
                            System.out.println("No existe la categoría ingresada");
                            continue;
                        }
                        monto = 0;
                        edad = Integer.valueOf(mapParticipantes.get(participante)[1]);
                        if (categoria == 1) monto = edad < 18 ? 1300 : 1500;
                        if (categoria == 2) monto = edad < 18 ? 2000 : 2300;
                        if (categoria == 3) {
                            if (edad < 18) {
                                System.out.println("No se pueden inscribir menores a la categoría");
                                continue;
                            }
                            monto = 2800;
                        }
                        mapInscripciones.get(participante)[1] = Integer.toString(categoria);
                        mapInscripciones.get(participante)[2] = Double.toString(monto);
                        break;
                    case 3:
                        if (mapParticipantes.size() == 0) {
                            System.out.println("No hay participantes para Desinscribir");
                            continue;
                        }
                        System.out.println("Seleccione un participante: ");
                        for (Map.Entry<Integer, String[]> entry : mapParticipantes.entrySet()) {
                            System.out.println(entry.getKey() + " " + entry.getValue()[2] + " " + entry.getValue()[3]);
                        }
                        participante = scanner.nextInt();
                        if (!mapParticipantes.containsKey(participante)) {
                            System.out.println("No existe participante con el id " + participante);
                            continue;
                        }
                        mapInscripciones.remove(participante);
                        System.out.println("Participante desuscrito");
                        break;
                    case 4:
                        if (mapParticipantes.size() == 0) {
                            System.out.println("No hay participantes para mostrar");
                            continue;
                        }
                        for (Map.Entry<Integer, String[]> entry : mapCircuitos.entrySet()) {
                            System.out.println(entry.getKey() + " " + entry.getValue()[0]);
                        }
                        categoria = scanner.nextInt();
                        if (categoria < 1 || categoria > 3) {
                            System.out.println("No existe la categoría ingresada");
                            continue;
                        }
                        for (Map.Entry<Integer, String[]> entry : mapInscripciones.entrySet()) {
                            if (Integer.valueOf(entry.getValue()[1]) == categoria) {
                                var idPersona = entry.getKey();
                                System.out.println("---------------"+"Participante "+idPersona+"---------------");
                                System.out.println("DNI: "+mapParticipantes.get(idPersona)[0]);
                                System.out.println("Edad: "+mapParticipantes.get(idPersona)[1]);
                                System.out.println("Nombre: "+mapParticipantes.get(idPersona)[2]);
                                System.out.println("Apellido: "+mapParticipantes.get(idPersona)[3]);
                                System.out.println("Telefono: "+mapParticipantes.get(idPersona)[4]);
                                System.out.println("Telefono Emergencia: "+mapParticipantes.get(idPersona)[5]);
                                System.out.println("Grupo Sanguineo: "+mapParticipantes.get(idPersona)[6]);
                                System.out.println("A pagar: "+entry.getValue()[2]);
                                System.out.println("--------------------------------------------");
                            }
                        }
                        break;
                    case 5:
                        if (mapInscripciones.size() == 0) {
                            System.out.println("No hay recaudos");
                            continue;
                        }
                        for (Map.Entry<Integer, String[]> entry : mapCircuitos.entrySet()) {
                            System.out.println(entry.getKey() + " " + entry.getValue()[0]);
                        }
                        categoria = scanner.nextInt();
                        if (categoria < 1 || categoria > 3) {
                            System.out.println("No existe la categoría ingresada");
                            continue;
                        }
                        double suma = 0;
                        for (Map.Entry<Integer, String[]> entry : mapInscripciones.entrySet()) {
                            if (Integer.valueOf(entry.getValue()[1]) == categoria) {
                                suma += Double.parseDouble(entry.getValue()[2]);
                            }
                        }
                        System.out.println("--------------------------------------------");
                        System.out.println("Total suma: "+suma);
                        System.out.println("--------------------------------------------");
                        break;
                    case 6:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opción invalida");
                }
            }
        }catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}


