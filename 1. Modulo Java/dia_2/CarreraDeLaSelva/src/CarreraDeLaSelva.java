import java.util.HashMap;
import java.util.Map;

public class CarreraDeLaSelva {

    public void inscribirParticipante(int idCategoria, String nombre, String apellido, int edad, int dni, String celular, String numeroEmergencia, String grupoSanguineo, Map inscritos) {
        Map<String, Object> participante = new HashMap<>();
        participante.put("Nombre", nombre);
        participante.put("Apellido", apellido);
        participante.put("DNI", dni);
        participante.put("Edad", edad);
        participante.put("Celular", celular);
        participante.put("NumeroEmergencia", numeroEmergencia);
        participante.put("GrupoSanguineo", grupoSanguineo);
        participante.put("Categoria", idCategoria);

        double monto = 0.0;
        if (idCategoria == 1) {
            if (edad < 18) {
                finalizarInscripción(participante, inscritos, 1300);
            } else {
                finalizarInscripción(participante, inscritos, 1500);
            }
        } else if (idCategoria == 2) {
            if (edad < 18) {
                finalizarInscripción(participante, inscritos, 2000);
            } else {
                finalizarInscripción(participante, inscritos, 2300);
            }
        } else if (idCategoria == 3) {
            if (edad < 18) {
                System.out.println("No se puede inscribir porque es menor de 18 años");

            } else {
                finalizarInscripción(participante, inscritos, 2800);
            }
        }
    }

    private void finalizarInscripción(Map participante, Map inscritos, double monto) {
        System.out.println("Participante:" + participante.get("Nombre") + participante.get("Apellido") + ": Monto para abonar: $" + monto);
        participante.put("Monto", monto);

        inscritos.put(inscritos.size() + 1, participante);

    }

    public void mostrarInscritosPorCategoria(int idCategoria, Map<Integer, String> categorias, Map<Integer, Map<String, Object>> inscritos) {
        String categoria = categorias.get(idCategoria);
        if (categoria != null) {
            System.out.println("inscritos en la categoria: " + categoria);
            inscritos.forEach((idParticipante, participante) -> {
                if ((int) participante.get("Categoria") == idCategoria) {
                    String nombreCompleto = participante.get("Nombre").toString() + " " + participante.get("Apellido").toString();
                    System.out.println("Número de inscripción: " + idParticipante + ", Nombre: " + nombreCompleto);
                }
            });
        } else {
            System.out.println("La categoría " + idCategoria + "no existe");
        }
    }

    public void desinscribirParticipante(int numeroDeInscripcion, Map participantes) {
        participantes.remove(numeroDeInscripcion);
    }

    public void calcularTotalRecaudado(Map<Integer, String> categorias, Map<Integer, Map<String, Object>> participantes) {
        Map<Integer, Double> totalPorCategoria = new HashMap<>();
        double total = 0;

        for (Map.Entry<Integer, Map<String, Object>> entry : participantes.entrySet()) {
            Integer id = entry.getKey();
            Map<String, Object> participante = entry.getValue();
            int idCategoria = (int) participante.get("Categoria");
            double monto = (double) participante.get("Monto");
            totalPorCategoria.put(idCategoria, totalPorCategoria.getOrDefault(idCategoria, 0.0) + monto);
            total += monto;
        }


        categorias.forEach((idCategoria, nombreCategoria) -> {
            double montoCategoria = totalPorCategoria.getOrDefault(idCategoria, 0.0);
            System.out.println("Monto total recaudado en la categoría " + nombreCategoria + montoCategoria);
        });

        System.out.println("Monto total recaudado en toda la carrera: " + total);
    }
}
