package org.example;

import java.util.*;

public class Main {


    private static int inscritos = 1;

    public static void main(String[] args) {
        // Map de la carrera
        Map<String, Map<Integer, Map<String, Object>>> carrera = new HashMap<>();

        // Crear objetos de tipo categoría
        Map<String, Object> circuitoChico = new HashMap<>();
        circuitoChico.put("nombre", "Circuito chico");
        circuitoChico.put("descripcion", "2 km por selva y arroyos");

        Map<String, Object> circuitoMedio = new HashMap<>();
        circuitoMedio.put("nombre", "Circuito medio");
        circuitoMedio.put("descripcion", "5 km por selva, arroyos y barro");

        Map<String, Object> circuitoAvanzado = new HashMap<>();
        circuitoAvanzado.put("nombre", "Circuito avanzado");
        circuitoAvanzado.put("descripcion", "10 km por selva, arroyos, barro y escalada en piedra");

        // Crear Maps para almacenar inscripciones por categoría
        Map<Integer, Map<String, Object>> inscripcionesCircuitoChico = new HashMap<>();
        Map<Integer, Map<String, Object>> inscripcionesCircuitoMedio = new HashMap<>();
        Map<Integer, Map<String, Object>> inscripcionesCircuitoAvanzado = new HashMap<>();

        // almacenamos las  inscripciones en la carrera
        carrera.put("chico", inscripcionesCircuitoChico);
        carrera.put("mediano", inscripcionesCircuitoMedio);
        carrera.put("avanzado", inscripcionesCircuitoAvanzado);

        // Crear un nuevo participante e inscribirlo en una categoría
        HashMap<String, Object> participante1 = new HashMap<>();
        participante1.put("dni", "12345678");
        participante1.put("nombre", "Juan");
        participante1.put("apellido", "Pérez");
        participante1.put("edad", 25);
        participante1.put("celular", "123456789");
        participante1.put("numeroEmergencia", "987654321");
        participante1.put("grupoSanguineo", "O+");
        participante1.put("categoria", circuitoChico.get("nombre"));

        inscribirParticipante(participante1, inscripcionesCircuitoChico, circuitoChico, carrera);

        // Crear un nuevo participante e inscribirlo en una categoría
        HashMap<String, Object> participante2 = new HashMap<>();
        participante2.put("dni", "12345678");
        participante2.put("nombre", "Juan");
        participante2.put("apellido", "Pérez");
        participante2.put("edad", 25);
        participante2.put("celular", "123456789");
        participante2.put("numeroEmergencia", "987654321");
        participante2.put("grupoSanguineo", "O+");
        participante2.put("categoria", circuitoChico.get("nombre"));

        inscribirParticipante(participante2, inscripcionesCircuitoAvanzado, circuitoAvanzado, carrera);

        // se agregan participantes de manera aleatoria
        agregarParticipantesAleatorios(circuitoChico, inscripcionesCircuitoChico, carrera);
        agregarParticipantesAleatorios(circuitoChico, inscripcionesCircuitoMedio, carrera);
        agregarParticipantesAleatorios(circuitoChico, inscripcionesCircuitoAvanzado, carrera);

        // Se muestran los inscritos por categoria
        mostrarInscritosCategoria(inscripcionesCircuitoChico, circuitoChico);
        mostrarInscritosCategoria(inscripcionesCircuitoMedio, circuitoMedio);
        mostrarInscritosCategoria(inscripcionesCircuitoAvanzado, circuitoAvanzado);

        // se elimina un participante y se muestra como quedan las inscripciones de la categoria correspondiente
        desinscribirParticipante(participante1, inscripcionesCircuitoChico, carrera);
        mostrarInscritosCategoria(inscripcionesCircuitoChico, circuitoChico);

        // se calculan los abonos
        System.out.println();
        System.out.println("############ Recaudos ###########");
        calcularRecaudo(carrera);

    }

    public static void inscribirParticipante(Map<String, Object> participante, Map<Integer, Map<String, Object>> inscripciones, Map<String, Object> categoria,  Map<String, Map<Integer, Map<String, Object>>> carrera) {
        int abono;
        // verificamos si el participante ya se encuentra inscrito
        if (estaInscrito(carrera, (String) participante.get("dni")) == -1) {
            abono = calcularAbono(categoria, participante);
            // verificamos si el participante cumple con los requisitos de inscripcion
            if (abono == 0) {
                System.out.println("El participante no cumple con los requisitos de inscripcion");
            }else {
                participante.put("abono", abono);
                inscripciones.put(inscritos, participante);
                inscritos++;
                System.out.println("Inscripcion realizada con exito, monto a abonar: " + abono);
            }
        } else {
            System.out.println("El participante con DNI" + participante.get("dni") + " ya está inscrito");
        }
    }

    public static void desinscribirParticipante(Map<String, Object> participante, Map<Integer, Map<String, Object>> inscripciones,  Map<String, Map<Integer, Map<String, Object>>> carrera) {
        int numeroInscripcion = estaInscrito(carrera, (String) participante.get("dni"));
        //verificamos si el participante se encuentra inscrito en dicha categoria
        if (numeroInscripcion != -1) {
            inscripciones.remove(numeroInscripcion);
            System.out.println("Usuario eliminado con exito!");
        }
        System.out.println("Usuario no encontrado");
    }

    public static int calcularAbono(Map<String, Object> categoria, Map<String, Object> infoPersona) {
        int abono;
        switch ((String) categoria.get("nombre")) {
            case "Circuito chico":
                abono = (int) infoPersona.get("edad") < 18 ? 1300 : 1500;
                break;
            case "circuito Medio":
                abono = (int) infoPersona.get("edad") < 18 ? 2000 : 2300;
                break;
            case "Circuito avanzado":
                abono = (int) infoPersona.get("edad") >= 18 ? 2800 : 0;
                break;
            default:
                abono = 0;
        }
        return abono;
    }

    public static Integer estaInscrito(Map<String, Map<Integer, Map<String, Object>>> carrera, String dni) {
        for(Map<Integer, Map<String, Object>> inscripciones: carrera.values()){
            for (Integer inscripcion : inscripciones.keySet()) {
                Map<String, Object> persona = inscripciones.get(inscripcion);
                if (persona.get("dni") == dni) {
                    return inscripcion;
                }
            }
        }

        return -1;
    }

    //Método que calcula los abonos por categoria y el abono de toda la carrera
    public static void calcularRecaudo(Map<String, Map<Integer, Map<String, Object>>> carrera) {
        int abonoTotal = 0;
        for (String inscripciones : carrera.keySet()) {
            int abonoCategoria = 0;
            for (Integer inscripcion : carrera.get(inscripciones).keySet()) {
                Map<String, Object> infoInscripcion = carrera.get(inscripciones).get(inscripcion);
                abonoCategoria += (int) infoInscripcion.get("abono");
            }
            abonoTotal += abonoCategoria;
            System.out.println("Abono categoria " + inscripciones + " $$" + abonoCategoria);
        }
        System.out.println("Abono total: $$ " + abonoTotal);

    }

    //d) Mostrar por pantalla todos los inscriptos a una determinada categoría con sus correspondientes datos y número de inscripción.
    public static void mostrarInscritosCategoria(Map<Integer, Map<String, Object>> inscripciones, Map<String, Object> categoria) {
        System.out.println("Integrantes de la categoría " + categoria.get("nombre") + ":");
        if (inscripciones != null) {
            for (Map.Entry<Integer, Map<String, Object>> entry : inscripciones.entrySet()) {
                System.out.println("########## Inscripcion: " + entry.getKey() + " ###############");
                System.out.println("DNI: " + entry.getValue().get("dni"));
                System.out.println("Nombre: " + entry.getValue().get("nombre"));
                System.out.println("Apellido: " + entry.getValue().get("apellido"));
                System.out.println("Edad: " + entry.getValue().get("edad"));
                System.out.println("Teléfono: " + entry.getValue().get("celular"));
                System.out.println("Grupo sanguíneo: " + entry.getValue().get("grupoSanguineo"));
                System.out.println();
            }
        } else {
            System.out.println("No hay inscritos en la categoría " + categoria);
        }
    }

    // Método para agregar participantes aleatorios a una categoría
    static void agregarParticipantesAleatorios(Map<String, Object> categoria, Map<Integer, Map<String, Object>> inscripciones,  Map<String, Map<Integer, Map<String, Object>>> carrera) {
        Random rand = new Random();
        int cantidadParticipantes = rand.nextInt(10) + 1; // Generar un número aleatorio entre 1 y 10
        for (int i = 0; i < cantidadParticipantes; i++) {
            Map<String, Object> participante = generarParticipanteAleatorio();
            inscribirParticipante(participante, inscripciones, categoria, carrera);
        }
    }

    // Método para generar un participante aleatorio
    static Map<String, Object> generarParticipanteAleatorio() {
        Random rand = new Random();
        Map<String, Object> participante = new HashMap<>();
        participante.put("dni", String.valueOf(rand.nextInt(1000000000))); // Generar DNI aleatorio de 9 dígitos
        participante.put("nombre", "Nombre" + rand.nextInt(100)); // Generar nombre aleatorio
        participante.put("apellido", "Apellido" + rand.nextInt(100)); // Generar apellido aleatorio
        participante.put("edad", rand.nextInt(50) + 10); // Generar edad aleatoria entre 10 y 59 años
        participante.put("celular", String.valueOf(rand.nextInt(1000000000))); // Generar número de celular aleatorio de 9 dígitos
        participante.put("numeroEmergencia", String.valueOf(rand.nextInt(1000000000))); // Generar número de emergencia aleatorio de 9 dígitos
        participante.put("grupoSanguineo", new String[]{"A+", "A-", "B+", "B-", "O+", "O-"}[rand.nextInt(6)]); // Generar grupo sanguíneo aleatorio
        return participante;
    }
}