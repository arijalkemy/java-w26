package org.example;

import java.util.*;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static Map<Integer, Inscripcion> inscritos = new HashMap<>();
    public static List<Inscripcion> inscritosCircuitoChico = new ArrayList<>();
    public static List<Inscripcion> inscritosCircuitoMedio = new ArrayList<>();
    public static List<Inscripcion> inscritosCircuitoAvanzado = new ArrayList<>();
    public static List<Categoria> categorias = new ArrayList<>();
    public static int numInscripcion;

    public static void main(String[] args) {
        llenarDatosBase();
        System.out.println("////////// Bienvenido //////////");
        int eleccion;
        do {
            System.out.println("\n----------------------");
            System.out.println("Seleccione una opción");
            System.out.println("1.\tInscribite");
            System.out.println("2.\tMostrar inscritos");
            System.out.println("3.\tDesinscibir Participante");
            System.out.println("4.\tCalcular Recaudos");
            System.out.println("5.\tSalir");
            System.out.printf("Elección: ");
            eleccion = scanner.nextInt();
            switch (eleccion) {
                case 1:
                    inscribirParticipante();
                    break;
                case 2:
                    mostrarInscritos();
                    break;
                case 3:
                    desinscribirParticipante();
                    break;
                case 4:
                    calcularRecaudos();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("El valor ingresado no es valido");
                    break;
            }
        } while (eleccion != 5);
    }

    public static void llenarDatosBase() {
        Categoria categoria1 = new Categoria(1, "Circuito chico", "2 km por selva y arroyos, Menores de 18 años $1300. Mayores de 18 años $1500.");
        Categoria categoria2 = new Categoria(2, "Circuito medio", "5 km por selva, arroyos y barro, Menores de 18 años $2000. Mayores de 18 años $2300.");
        Categoria categoria3 = new Categoria(3, "Circuito avanzado", "10km por selva, arroyos, barro y escalada en piedra, No se permite inscripciones a menores de 18 años. Mayores de 18 años $2800");
        categorias.add(categoria1);
        categorias.add(categoria2);
        categorias.add(categoria3);
        Participante participante1 = new Participante(11111, "Alex", "Romero", 15, 314123122, 312341232, "O-");
        Participante participante2 = new Participante(22222, "Brayan", "Pinto", 29, 432829213, 432123123, "A+");
        Participante participante3 = new Participante(33333, "Ivan", "Malagon", 24, 123987273, 123412342, "B-");
        Inscripcion inscripcion1 = new Inscripcion(1, categoria1, participante1, 1300);
        Inscripcion inscripcion2 = new Inscripcion(2, categoria2, participante2, 2300);
        Inscripcion inscripcion3 = new Inscripcion(3, categoria3, participante3, 2800);
        inscritos.put(1, inscripcion1);
        inscritos.put(2, inscripcion2);
        inscritos.put(3, inscripcion3);
        inscritosCircuitoChico.add(inscripcion1);
        inscritosCircuitoMedio.add(inscripcion2);
        inscritosCircuitoAvanzado.add(inscripcion3);
        numInscripcion = 4;
    }

    public static void inscribirParticipante() {
        String nombre, apellido, grupoSanguineo;
        int edad, eleccion;
        long celular, numEmergencia, dni, total;
        System.out.println("Inscripción de participante, llena los siguientes datos");
        System.out.printf("Nombre: ");
        nombre = scanner.nextLine();
        nombre = scanner.nextLine();
        System.out.printf("Apellido: ");
        apellido = scanner.nextLine();
        System.out.printf("DNI: ");
        dni = scanner.nextLong();
        System.out.printf("Edad: ");
        edad = scanner.nextInt();
        System.out.printf("Celular: ");
        celular = scanner.nextLong();
        System.out.printf("Num Emergencia: ");
        numEmergencia = scanner.nextLong();
        System.out.printf("Grupo Sanguineo: ");
        grupoSanguineo = scanner.nextLine();
        grupoSanguineo = scanner.nextLine();
        System.out.println("\nPerfecto, ahora selecciona la categoría a competir");
        for (Categoria categoria : categorias) {
            System.out.println(categoria.getId() + " - " + categoria.getNombre() + ":\t" + categoria.getDescripcion());
        }
        while (true) {
            eleccion = scanner.nextInt();
            if (eleccion < 1 || eleccion > 3) {
                System.out.println("El número ingresado no está en el rango");
                continue;
            }
            if (eleccion == 3 && edad < 18) {
                System.out.println("Si no eres mayor de edad, no puedes participar en el Circuito Avanzado, selecciona otra opción");
                System.out.printf("Opción: ");
            } else {
                break;
            }
        }
        if (edad < 18) {
            if (eleccion == 1) {
                total = 1300;
            } else {
                total = 2000;
            }
        } else {
            if (eleccion == 1) {
                total = 1500;
            } else if (eleccion == 2) {
                total = 2300;
            } else {
                total = 2800;
            }
        }
        Participante participante = new Participante(dni, nombre, apellido, edad, celular, numEmergencia, grupoSanguineo);
        Inscripcion inscripcion = new Inscripcion(numInscripcion, categorias.get(eleccion - 1), participante, total);
        inscritos.put(numInscripcion, inscripcion);
        if (eleccion == 1) {
            inscritosCircuitoChico.add(inscripcion);
        } else if (eleccion == 2) {
            inscritosCircuitoMedio.add(inscripcion);
        } else {
            inscritosCircuitoAvanzado.add(inscripcion);
        }
        System.out.println("El valor a pagar es: " + total);
        numInscripcion++;
    }

    public static void mostrarInscritos() {
        int eleccion;
        List<Inscripcion> lista;
        System.out.println("Selecciona la categoria a listar");
        for (Categoria categoria : categorias) {
            System.out.println(categoria.getId() + " - " + categoria.getNombre() + ": " + categoria.getDescripcion());
        }
        while (true) {
            eleccion = scanner.nextInt();
            if (eleccion < 1 || eleccion > 3) {
                System.out.println("El número ingresado no está en el rango, vuelva a seleccionar");
                System.out.printf("Opción: ");
            } else {
                break;
            }
        }
        if (eleccion == 1) {
            lista = inscritosCircuitoChico;
        } else if (eleccion == 2) {
            lista = inscritosCircuitoMedio;
        } else {
            lista = inscritosCircuitoAvanzado;
        }
        for (Inscripcion inscripcion : lista) {
            System.out.println("Número de inscripción: " + inscripcion.getNumeroInscripcion());
            System.out.println("\tNombre:\t" + inscripcion.getParticipante().getNombre());
            System.out.println("\tApellido:\t" + inscripcion.getParticipante().getApellido());
            System.out.println("\tDNI:\t" + inscripcion.getParticipante().getDni());
            System.out.println("\tEdad:\t" + inscripcion.getParticipante().getEdad());
            System.out.println("\tCelular:\t" + inscripcion.getParticipante().getCelular());
            System.out.println("\tNúm Emergencia:\t" + inscripcion.getParticipante().getNumEmergencia());
            System.out.println("\tGrupo Sanguíneo:\t" + inscripcion.getParticipante().getGrupoSanguineo() + "\n");
        }
    }

    public static void desinscribirParticipante() {
        int seleccion;
        Inscripcion inscripcion;
        System.out.println("Ingrese el número de la inscripción a eliminar");
        System.out.printf("Número de la inscripción: ");
        seleccion = scanner.nextInt();
        if (inscritos.containsKey(seleccion)) {
            inscripcion = inscritos.get(seleccion);
            if (inscripcion.getCategoria().getId() == 1) {
                inscritosCircuitoChico.remove(inscripcion);
            } else if (inscripcion.getCategoria().getId() == 2) {
                inscritosCircuitoMedio.remove(inscripcion);
            } else {
                inscritosCircuitoAvanzado.remove(inscripcion);
            }
            inscritos.remove(seleccion);
        } else {
            System.out.println("No existe ninguna inscripción con dicho número de inscripción");
        }
    }

    public static void calcularRecaudos() {
        int totalChico = 0;
        int totalMedio = 0;
        int totalAvanzado = 0;
        int total;
        for (Inscripcion inscripcion : inscritosCircuitoChico) {
            totalChico += inscripcion.getMontoAbono();
        }
        for (Inscripcion inscripcion : inscritosCircuitoMedio) {
            totalMedio += inscripcion.getMontoAbono();
        }
        for (Inscripcion inscripcion : inscritosCircuitoAvanzado) {
            totalAvanzado += inscripcion.getMontoAbono();
        }
        total = totalChico + totalMedio + totalAvanzado;
        System.out.println("Total Recaudos");
        System.out.println("Circuito Chico = " + totalChico);
        System.out.println("Circuito Medio = " + totalMedio);
        System.out.println("Circuito Avanzado = " + totalAvanzado);
        System.out.println("Total: " + total);
    }
}