package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class CarreraDeLaSelva {
    public static void main(String[] args) {
        List<Map<String, String>> categorias = new ArrayList<>();

        Map<String, String> miniCategoria = new HashMap<>();
        Map<String, String> miniCategoria2 = new HashMap<>();
        Map<String, String> miniCategoria3 = new HashMap<>();
        miniCategoria.put("nombre", "Circuito chico");
        miniCategoria.put("descripcion", "2 km por selva y arroyos");
        categorias.add(miniCategoria);
        miniCategoria2.put("nombre", "Circuito medio");
        miniCategoria2.put("descripcion", "5 km por selva, arroyos y barro");
        categorias.add(miniCategoria2);
        miniCategoria3.put("nombre", "Circuito avanzado");
        miniCategoria3.put("descripcion", "10 km por selva, arroyos, barro y escalada en piedra");
        categorias.add(miniCategoria3);

        for (Map<String, String> categoria : categorias) {
            System.out.println("Categoria:");
            for (Map.Entry<String, String> entry : categoria.entrySet()) {
                System.out.println("  " + entry.getKey() + ": " + entry.getValue());
            }
            System.out.println("-----------------------------");
        }

        List<Map<String, String>> participantes = new ArrayList<>();

        crearParticipante(participantes, "87654321B", "Maria", "Gomez", "30", "123456789", "987654321", "A-");

        List<Map<String, String>> inscripciones = new ArrayList<>();

        Map<String, String> inscripcion = new HashMap<>();
        String monto = "";
        Map<String, String> cat = obtenerCategoria(categorias, "Circuito chico");
        monto = calcularMontoInscripcion(cat, participantes.get(0));

        inscripcion.put("numero_inscripcion", String.valueOf(inscripciones.size() + 1));
        inscripcion.put("categoria", cat.get("nombre"));
        inscripcion.put("dni", participantes.get(0).get("dni"));
        inscripcion.put("monto", monto);

        inscripciones.add(inscripcion);
        Map<String, String> inscripcion1 = new HashMap<>();
        crearParticipante(participantes, "12345678C", "Carlos", "Lopez", "35", "234567890", "876543210", "B+");
        cat = obtenerCategoria(categorias, "Circuito medio");
        monto = calcularMontoInscripcion(cat, participantes.get(1));
        inscripcion1.put("numero_inscripcion", String.valueOf(inscripciones.size() + 1));
        inscripcion1.put("categoria", cat.get("nombre"));
        inscripcion1.put("dni", participantes.get(1).get("dni"));
        inscripcion1.put("monto", monto);

        inscripciones.add(inscripcion1);
        Map<String, String> inscripcion2 = new HashMap<>();
        crearParticipante(participantes, "87654321D", "Laura", "Martinez", "28", "345678901", "765432109", "AB-");
        cat = obtenerCategoria(categorias, "Circuito avanzado");
        monto = calcularMontoInscripcion(cat, participantes.get(2));
        inscripcion2.put("numero_inscripcion", String.valueOf(inscripciones.size() + 1));
        inscripcion2.put("categoria", cat.get("nombre"));
        inscripcion2.put("dni", participantes.get(2).get("dni"));
        inscripcion2.put("monto", monto);

        inscripciones.add(inscripcion2);

        verInscripciones(inscripciones);
        inscripciones.remove(inscripcion);
        System.out.println("########################");

        verInscripciones(inscripciones);

        calcularMontos(inscripciones);

    }

    public static void verInscripciones(List<Map<String, String>> inscripciones) {
        for (Map<String, String> mini : inscripciones) {
            System.out.println("Inscripcion:");
            for (Map.Entry<String, String> entry : mini.entrySet()) {
                System.out.println("  " + entry.getKey() + ": " + entry.getValue());
            }
            System.out.println("-----------------------------");
        }
    }


    public static Map<String, String> obtenerCategoria(List<Map<String, String>> categorias, String nombreCategoria) {
        for (Map<String, String> categoria : categorias) {
            if (categoria.get("nombre").equals(nombreCategoria)) {
                return categoria;
            }
        }

        return null;
    }

    public static String calcularMontoInscripcion(Map<String, String> categoria, Map<String, String> participante) {
        String monto = "";

        switch (categoria.get("nombre")) {
            case "Circuito chico":
                monto = Integer.parseInt(participante.get("edad")) < 18 ? "1300" : "1500";
                break;
            case "Circuito medio":
                monto = Integer.parseInt(participante.get("edad")) < 18 ? "2000" : "2300";
                break;
            case "Circuito avanzado":
                if (Integer.parseInt(participante.get("edad")) < 18) {
                    System.out.println("No se permite inscripciones a menores de 18 años en el Circuito avanzado.");
                    return null;
                }
                monto = "2800";
                break;
            default:
                System.out.println("Categoría no válida.");
                return null;
        }

        return monto;
    }

    public static void crearParticipante(List<Map<String, String>> participantes, String dni, String nombre, String apellido, String edad, String celular, String numeroEmergencia, String grupoSanguineo) {
        Map<String, String> participante = new HashMap<>();
        participante.put("dni", dni);
        participante.put("nombre", nombre);
        participante.put("apellido", apellido);
        participante.put("edad", edad);
        participante.put("celular", celular);
        participante.put("numero_emergencia", numeroEmergencia);
        participante.put("grupo_sanguineo", grupoSanguineo);
        participantes.add(participante);
    }

    public static void calcularMontos(List<Map<String, String>> inscripciones) {
        Map<String, Integer> montosPorCategoria = new HashMap<>();
        int montoTotal = 0;

        for (Map<String, String> inscripcion : inscripciones) {
            String categoria = inscripcion.get("categoria");
            int monto = Integer.parseInt(inscripcion.get("monto"));

            montosPorCategoria.put(categoria, montosPorCategoria.getOrDefault(categoria, 0) + monto);
            montoTotal += monto;
        }

        for (Map.Entry<String, Integer> entry : montosPorCategoria.entrySet()) {
            System.out.println("Monto total para la categoría " + entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("Monto total para toda la carrera: " + montoTotal);
    }

}