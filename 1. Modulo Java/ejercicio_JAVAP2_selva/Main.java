import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Crear objetos de tipo Categoria
        Categoria circuitoChico = new Categoria(1, "Circuito chico", "2 km por selva y arroyos");
        Categoria circuitoMedio = new Categoria(2, "Circuito medio", "5 km por selva, arroyos y barro");
        Categoria circuitoAvanzado = new Categoria(3, "Circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra");

        // Crear objeto de tipo Participante
        Participante participante1 = new Participante(1, "12345678", "Juan", "Perez", 25, "123456789", "987654321", "A+");

        // Inscribir participante en una categoría
        Inscripcion inscripcion1 = new Inscripcion(1, circuitoChico, participante1);
        
    }
}
