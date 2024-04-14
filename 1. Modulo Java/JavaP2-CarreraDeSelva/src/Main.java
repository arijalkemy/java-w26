import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Categoria> categorias = new ArrayList<Categoria>();
        List<Participante> participantes = new ArrayList<Participante>();

        Random random = new Random();

        categorias.add(new Categoria(
                "Circuito Chico",
                "2 km por selva y arroyos.",
                1300,
                1500
                ));
        categorias.add(new Categoria(
                "Circuito Mediano",
                "5 km por selva, arroyos y barro.",
                2000,
                2300
        ));
        categorias.add(new Categoria(
                "Circuito Avanzado",
                "10 km por selva, arroyos, barro y escalada en piedra.",
                -1,
                2800
        ));

        Participante participante = new Participante(
                1,
                "12345",
                "Participante 0",
                "Apellido 0",
                17,
                1234567890,
                1234567890,
                "A+"
        );

        participante.setInscripcion(categorias.get(2));

        participantes.add(participante);

        for (int i = 1; i < 10; i++ ) {
            participantes.add(new Participante(
                    i,
                    "" + i*12345,
                    "Participante " + i,
                    "Apellido " + i,
                    random.nextInt(5) + 17,
                    1234567890,
                    1234567890,
                    "A+"
            ));
            participantes.get(i).setInscripcion(categorias.get(random.nextInt(2)));
        }



        System.out.println("Inscripcion Incial:");
        for (int i = 0; i < participantes.size()-1; i++ ) {
            if (participantes.get(i).getMontoInscrito() != -1){

                System.out.println(participantes.get(i).getNombre() + " inscrito a " + participantes.get(i).getInscripcion().getNombre() + " con monto de inscripcion de: $"+ participantes.get(i).getMontoInscrito() + " y edad: " + participantes.get(i).getEdad());

            }
            else {
                System.out.println(participantes.get(i).getNombre() + " No se pudo inscribir a " + participantes.get(i).getInscripcion().getNombre() + " por minoria de edad");
            }

        }

        System.out.println("Desinscribiendo al Participante 4");

        participantes.remove(4);

        for (int i = 0; i < participantes.size()-1; i++ ) {
            if (participantes.get(i).getMontoInscrito() != -1){

                System.out.println(participantes.get(i).getNombre() + " inscrito a " + participantes.get(i).getInscripcion().getNombre() + " con monto de inscripcion de: $"+ participantes.get(i).getMontoInscrito() + " y edad: " + participantes.get(i).getEdad());

            }
            else {
                System.out.println(participantes.get(i).getNombre() + " No se pudo inscribir a " + participantes.get(i).getInscripcion().getNombre() + " por minoria de edad");
            }

        }

        System.out.println("Monto Total Recaudado por Categoria");

        double total_chico = 0;
        double total_mediano = 0;
        double total_avanzado = 0;

        for (int i = 0; i < participantes.size()-1; i++ ) {
            switch (participantes.get(i).getInscripcion().getNombre()){
                case "Circuito Chico":
                    total_chico += participantes.get(i).getMontoInscrito();
                case "Circuito Mediano":
                    total_mediano += participantes.get(i).getMontoInscrito();
                case "Circuito Avanzado":
                    if (participantes.get(i).getMontoInscrito() != -1)
                    total_avanzado += participantes.get(i).getMontoInscrito();

            }
        }

        System.out.println("Categoria Chica: " + total_chico);
        System.out.println("Categoria Mediana: " + total_chico);
        System.out.println("Categoria Avanzada: " + total_avanzado);


    }
}