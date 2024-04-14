import java.util.ArrayList;
import java.util.List;

public class Persona {
    private String nombre;
    private String apellido;
    private List<String> habilidades;

    public Persona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.habilidades = new ArrayList<>();
    }

    public void agregarHabilidad(String... habilidad) {
        for (String h : habilidad) {
            this.habilidades.add(h);
        }
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", habilidades=" + habilidades +
                '}';
    }
}
