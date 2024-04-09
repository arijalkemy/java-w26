import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
            boolean fin = false;
            //creo tres mapas para cada carrera
            Map<Integer, Participante> participantesChico = new HashMap<>();
            Map<Integer, Participante> participantesMedio = new HashMap<>();
            Map<Integer, Participante> participantesAvanzado = new HashMap<>();

            Scanner teclado = new Scanner(System.in);

            //decidi hacer ingreso manual, de los participantes
            do {
                System.out.println("Inserte los datos del inscripto: ");
                System.out.println("Inserte dni: ");
                int dni = teclado.nextInt();
                teclado.nextLine();
                System.out.println("Inserte Nombre y Apellido: ");
                String nombreApellido = teclado.nextLine();
                System.out.println("Inserte edad: ");
                int edad = teclado.nextInt();
                System.out.println("Inserte categoria: ");
                System.out.println("Chico, Medio o Avanzado.");
                String categoria = teclado.next();

                //instancia participante
                Participante participante = new Participante(dni, nombreApellido, edad, categoria);

                //se accede a la categoria donde fue inscripto el participante para agregarlo al mapa correspondiente
                switch (participante.getCategoria()){
                    case "Chico":
                        participantesChico.put(participante.getId() ,participante);
                        break;
                    case "Medio":
                        participantesMedio.put(participante.getId() ,participante);
                        break;
                    case "Avanzado":
                        //si el participante es menor, no es agregado al mapa avanzado
                        if (participante.getMonto() != 0) {
                            participantesAvanzado.put(participante.getId() ,participante);
                        }
                        break;
                    default:
                        break;
                }
                System.out.println("Desea seguir? (fin para salir)");
                String finTeclado = teclado.next();
                if (finTeclado.equals("fin")){
                    fin = true;
                }
            } while (!fin);

            teclado.close();


            //se muestran los participantes de los circuitos.
            System.out.println("Circuito Chico: ");
            for (Map.Entry<Integer, Participante> entrada: participantesChico.entrySet()){
                Participante valor = entrada.getValue();
                System.out.println("Participante: " + valor.getNombreApellido() + ". Dni: " + valor.getDni() + ". Circuito: " + valor.getCategoria() + ". Monto: " + valor.getMonto());
            }
            System.out.println("Circuito Medio: ");
            for (Map.Entry<Integer, Participante> entrada: participantesMedio.entrySet()){
                Participante valor = entrada.getValue();
                System.out.println("Participante: " + valor.getNombreApellido() + ". Dni: " + valor.getDni() + ". Circuito: " + valor.getCategoria()  + ". Monto: " + valor.getMonto());
            }
            System.out.println("Circuito Avanzado: ");
            for (Map.Entry<Integer, Participante> entrada: participantesAvanzado.entrySet()){
                Participante valor = entrada.getValue();
                System.out.println("Participante: " + valor.getNombreApellido() + ". Dni: " + valor.getDni() + ". Circuito: " + valor.getCategoria() + ". Monto: " + valor.getMonto());
            }

            //implentacion para eliminar a un participante. Es directamente

            /*participantesChico.remove(1); eliminar participante


            for (Map.Entry<Integer, Participante> entrada: participantesChico.entrySet()) {
                Integer clave = entrada.getKey();
                Participante valor = entrada.getValue();
                System.out.println("Participante: " + valor.nombreApellido + ". Dni: " + valor.dni + ". Circuito: " + valor.categoria);
            }
            */
            int totalChico = 0;
            int totalMedio = 0;
            int totalAvanzado = 0;
            int total = 0;
            for (Map.Entry<Integer, Participante> entrada: participantesChico.entrySet()) {
                Integer clave = entrada.getKey();
                totalChico += participantesChico.get(clave).getMonto();
            }
            for (Map.Entry<Integer, Participante> entrada: participantesMedio.entrySet()) {
                Integer clave = entrada.getKey();
                totalMedio += participantesMedio.get(clave).getMonto();
            }
            for (Map.Entry<Integer, Participante> entrada: participantesAvanzado.entrySet()) {
                Integer clave = entrada.getKey();
                totalAvanzado += participantesAvanzado.get(clave).getMonto();
            }

            total = totalChico + totalMedio + totalAvanzado;

            System.out.println("El monto de circuito chico recaudado es: " + totalChico);
            System.out.println("El monto de circuito medio recaudado es: " + totalMedio);
            System.out.println("El monto de circuito avanzado recaudado es: " + totalAvanzado);
            System.out.println("El monto total recaudado es: " + total);


        }
    }
