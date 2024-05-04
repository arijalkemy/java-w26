
import java.util.ArrayList;

public class CarreraDeLaSelva {
    
    public static void main(String[] args) {
        // Creación de categorías de circuitos
        Categoria circuitoChico = new Categoria(1, "Circuito chico", "2 km por selva y arroyos");
        Categoria circuitoMedio = new Categoria(2, "Circuito medio", "5 km por selva, arroyos y barro");
        Categoria circuitoAvanzado = new Categoria(3, "Circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra");

        // Creación de participantes
        Participante participante1 = new Participante(1, "12345678", "Juan", "Perez", 25, "123456789", "987654321", "A+");
        Participante participante2 = new Participante(2, "87654321", "Maria", "Gomez", 30, "987654321", "123456789", "B-");
        Participante participante3 = new Participante(3, "56781234", "Pedro", "Lopez", 28, "654321987", "321987654", "O+");
        Participante participante4 = new Participante(4, "43218765", "Ana", "Lopez", 27, "987654321", "123456789", "AB+");

        // Creación de inscripciones
        Inscripcion inscripcion = new Inscripcion(1, circuitoChico, participante1);
        Inscripcion inscripcion2 = new Inscripcion(2, circuitoMedio, participante2);
        Inscripcion inscripcion3 = new Inscripcion(3, circuitoAvanzado, participante3);
        Inscripcion inscripcion4 = new Inscripcion(4, circuitoChico, participante4);

        // Creación de lista de inscripciones
        ArrayList<Inscripcion> inscripciones = new ArrayList<Inscripcion>();
        inscripciones.add(inscripcion);
        inscripciones.add(inscripcion2);
        inscripciones.add(inscripcion3);
        inscripciones.add(inscripcion4);

        // Impresión de los participantes por circuito
        imprimirParticipantes(inscripciones);

        // Remoción de una inscripción
        inscripciones.remove(inscripcion2);

        System.out.println("-------- Actualizacion de inscripciones --------");

        // Impresión de los participantes por circuito después de la actualización
        imprimirParticipantes(inscripciones);

        System.out.println("-------- Calculo total de monto recaudado --------");
        
        // Cálculo del monto total recaudado por circuito
        calculoMonto(inscripciones);


        
        
    }

    // Metodo para imprimir los participantes por circuito
    public static void imprimirParticipantes(ArrayList<Inscripcion> inscripciones)
    {
        Categoria circuitoChico = new Categoria(1, "Circuito chico", "2 km por selva y arroyos");
        Categoria circuitoMedio = new Categoria(2, "Circuito medio", "5 km por selva, arroyos y barro");
        Categoria circuitoAvanzado = new Categoria(3, "Circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra");
        System.out.println("Participantes por circuito:");
        Categoria[] circuitos = {circuitoChico, circuitoMedio, circuitoAvanzado};
        for (Categoria circuito : circuitos) {
            System.out.println(circuito.getNombre() + ":");
            for (Inscripcion inscripcionActual : inscripciones) {
                if (inscripcionActual.getCategoria().getNombre().equals(circuito.getNombre())) {
                    System.out.println(" {");
                    System.out.println("    - Participante: " + inscripcionActual.getParticipante().getNombre() + " " + inscripcionActual.getParticipante().getApellido());
                    System.out.println("    - Numero de inscripcion: " + inscripcionActual.getNumeroDeInscripcion());
                    System.out.println("    - Monto: " + inscripcionActual.getMonto());
                    System.out.println(" }");
                }
            }
        }
    }

    // Metodo para calcular el monto total recaudado por circuito
    public static void calculoMonto(ArrayList<Inscripcion> inscripciones)
    {
        Categoria circuitoChico = new Categoria(1, "Circuito chico", "2 km por selva y arroyos");
        Categoria circuitoMedio = new Categoria(2, "Circuito medio", "5 km por selva, arroyos y barro");
        Categoria circuitoAvanzado = new Categoria(3, "Circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra");
        System.out.println("Participantes por circuito:");
        Categoria[] circuitos = {circuitoChico, circuitoMedio, circuitoAvanzado};
        int montoTotal = 0;
        for (Categoria circuito : circuitos) {
            System.out.println(circuito.getNombre() + ":");
            for (Inscripcion inscripcionActual : inscripciones) {
                if (inscripcionActual.getCategoria().getNombre().equals(circuito.getNombre())) {
                    montoTotal+= inscripcionActual.getMonto();
                }
                   
            }
            System.out.println(" {");
            System.out.println("    - Monto recaudado: " + montoTotal);
            System.out.println(" }");
            montoTotal = 0;
        }
    }
}
