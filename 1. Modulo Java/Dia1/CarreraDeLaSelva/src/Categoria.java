import java.util.ArrayList;
import java.util.List;

public class Categoria {
    private int id;
    private String nombre;
    private String descripcion;
    private List<Participante> inscriptos;

    public Categoria(int id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.inscriptos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public List<Participante> getInscriptos() {
        return inscriptos;
    }

    public void inscribirParticipante(Participante participante) {
        inscriptos.add(participante);
    }

    public void desinscribirParticipante(Participante participante) {
        inscriptos.remove(participante);
    }

    public double calcularMonto(int edad) {
        if (nombre.equals("Circuito chico")) {
            if (edad < 18) {
                return 1300;
            } else {
                return 1500;
            }
        } else if (nombre.equals("Circuito medio")) {
            if (edad < 18) {
                return 2000;
            } else {
                return 2300;
            }
        } else if (nombre.equals("Circuito avanzado")) {
            return 2800;
        } else {
            return 0;
        }
    }

    public double calcularTotalRecaudado() {
        double total = 0;
        for (Participante participante : inscriptos) {
            total += calcularMonto(participante.getEdad());
        }
        return total;
    }
}
